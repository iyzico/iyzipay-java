package com.iyzipay.functional;

import com.iyzipay.functional.builder.CardInformationBuilder;
import com.iyzipay.functional.builder.PaymentCardBuilder;
import com.iyzipay.functional.builder.request.CreateCardRequestBuilder;
import com.iyzipay.functional.builder.request.CreatePaymentRequestBuilder;
import com.iyzipay.functional.builder.request.CreateSubMerchantRequestBuilder;
import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.*;
import com.iyzipay.request.CreateCardRequest;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.CreateSubMerchantRequest;
import com.iyzipay.request.RetrievePaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PaymentTest extends BaseTest {

    @Test
    public void should_create_listing_payment() {
        CreatePaymentRequest request = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .build();

        Payment payment = Payment.create(request, options);

        System.out.println(payment);

        assertNull(payment.getConnectorName());
        assertEquals(Locale.TR.getValue(), payment.getLocale());
        assertEquals(Status.SUCCESS.getValue(), payment.getStatus());
        assertNotNull(payment.getSystemTime());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
        assertNotNull(payment.getPaymentId());
        assertNotNull(payment.getBasketId());
        assertEquals(payment.getPrice(), (BigDecimal.ONE));
        assertEquals(payment.getPaidPrice(), new BigDecimal("1.1"));
        assertEquals(payment.getIyziCommissionRateAmount(), new BigDecimal("0.02887500"));
        assertEquals(payment.getIyziCommissionFee(), new BigDecimal("0.25000000"));
        assertEquals(payment.getMerchantCommissionRate(), new BigDecimal("10.00000000"));
        assertEquals(payment.getMerchantCommissionRateAmount(), new BigDecimal("0.1"));
    }

    @Test
    public void should_create_marketplace_payment() {
        CreateSubMerchantRequest createSubMerchantRequest = CreateSubMerchantRequestBuilder.create()
                .personalSubMerchantRequest()
                .build();

        String subMerchantKey = SubMerchant.create(createSubMerchantRequest, options).getSubMerchantKey();
        CreatePaymentRequest request = CreatePaymentRequestBuilder.create()
                .marketplacePayment(subMerchantKey)
                .build();

        Payment payment = Payment.create(request, options);

        System.out.println(payment);

        assertNull(payment.getConnectorName());
        assertEquals(Locale.TR.getValue(), payment.getLocale());
        assertEquals(Status.SUCCESS.getValue(), payment.getStatus());
        assertNotNull(payment.getSystemTime());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
        assertNotNull(payment.getPaymentId());
        assertNotNull(payment.getBasketId());
        assertEquals(BigDecimal.ONE, payment.getPrice());
        assertEquals(new BigDecimal("1.1"), payment.getPaidPrice());
        assertEquals(new BigDecimal("0.02887500"), payment.getIyziCommissionRateAmount());
        assertEquals(new BigDecimal("0.25000000"), payment.getIyziCommissionFee());
        assertEquals(new BigDecimal("10.00000000"), payment.getMerchantCommissionRate());
        assertEquals(new BigDecimal("0.1"), payment.getMerchantCommissionRateAmount());
        assertEquals(new Integer(1), payment.getInstallment());
    }

    @Test
    public void should_create_payment_with_registered_card() {
        String externalUserId = RandomGenerator.randomId();
        CardInformation cardInformation = CardInformationBuilder.create()
                .build();
        CreateCardRequest cardRequest = CreateCardRequestBuilder.create()
                .card(cardInformation)
                .externalId(externalUserId)
                .email("email@email.com")
                .build();
        Card card = Card.create(cardRequest, options);

        PaymentCard paymentCard = PaymentCardBuilder.create()
                .cardUserKey(card.getCardUserKey())
                .cardToken(card.getCardToken())
                .build();

        CreatePaymentRequest request = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .paymentCard(paymentCard)
                .build();

        Payment payment = Payment.create(request, options);

        System.out.println(payment);

        assertNull(payment.getConnectorName());
        assertEquals(Locale.TR.getValue(), payment.getLocale());
        assertEquals(Status.SUCCESS.getValue(), payment.getStatus());
        assertNotNull(payment.getSystemTime());
        assertEquals("123456789", payment.getConversationId());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
        assertNotNull(payment.getPaymentId());
        assertNotNull(payment.getBasketId());
        assertEquals(BigDecimal.ONE, payment.getPrice());
        assertEquals(new BigDecimal("1.1"), payment.getPaidPrice());
        assertEquals(new BigDecimal("0.02887500"), payment.getIyziCommissionRateAmount());
        assertEquals(new BigDecimal("0.25000000"), payment.getIyziCommissionFee());
        assertEquals(new BigDecimal("10.00000000"), payment.getMerchantCommissionRate());
        assertEquals(new BigDecimal("0.1"), payment.getMerchantCommissionRateAmount());
        assertEquals(new Integer(1), payment.getInstallment());
        assertEquals("0008", payment.getLastFourDigits());
    }

    @Test
    public void should_retrieve_payment() {
        CreatePaymentRequest request = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .build();

        Payment createdPayment = Payment.create(request, options);

        System.out.println(createdPayment);

        RetrievePaymentRequest retrievePaymentRequest = new RetrievePaymentRequest();
        retrievePaymentRequest.setLocale(Locale.TR.getValue());
        retrievePaymentRequest.setConversationId("123456789");
        retrievePaymentRequest.setPaymentId(createdPayment.getPaymentId());

        Payment payment = Payment.retrieve(retrievePaymentRequest, options);
        assertEquals(Locale.TR.getValue(), payment.getLocale());
        assertEquals(Status.SUCCESS.getValue(), payment.getStatus());
        assertEquals(new Integer(1), payment.getInstallment());
        assertEquals("123456789", payment.getConversationId());
        assertEquals(createdPayment.getPaymentId(), payment.getPaymentId());
        assertEquals("0008", createdPayment.getLastFourDigits());
        assertNotNull(payment.getSystemTime());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
        assertNotNull(payment.getBasketId());
    }
}