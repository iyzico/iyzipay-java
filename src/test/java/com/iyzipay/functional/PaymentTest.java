package com.iyzipay.functional;

import com.iyzipay.functional.builder.CardInformationBuilder;
import com.iyzipay.functional.builder.PaymentCardBuilder;
import com.iyzipay.functional.builder.request.CreateCardRequestBuilder;
import com.iyzipay.functional.builder.request.CreatePaymentRequestBuilder;
import com.iyzipay.functional.builder.request.CreateSubMerchantRequestBuilder;
import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.Card;
import com.iyzipay.model.CardInformation;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Payment;
import com.iyzipay.model.PaymentCard;
import com.iyzipay.model.Status;
import com.iyzipay.model.SubMerchant;
import com.iyzipay.request.CreateCardRequest;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.CreateSubMerchantRequest;
import com.iyzipay.request.RetrievePaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
        assertTrue(payment.verifySignature(options.getSecretKey()));
        assertNotEquals(0, payment.getSystemTime());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
        assertNotNull(payment.getPaymentId());
        assertNotNull(payment.getBasketId());
        assertNotNull(payment.getHostReference());
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
        assertTrue(payment.verifySignature(options.getSecretKey()));
        assertNotEquals(0, payment.getSystemTime());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
        assertNotNull(payment.getPaymentId());
        assertNotNull(payment.getBasketId());
        assertNotNull(payment.getHostReference());
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
        assertTrue(payment.verifySignature(options.getSecretKey()));
        assertNotEquals(0, payment.getSystemTime());
        assertEquals("123456789", payment.getConversationId());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
        assertNotNull(payment.getPaymentId());
        assertNotNull(payment.getBasketId());
        assertNotNull(payment.getHostReference());
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
        assertTrue(createdPayment.verifySignature(options.getSecretKey()));
        assertEquals(new Integer(1), payment.getInstallment());
        assertEquals("123456789", payment.getConversationId());
        assertEquals(createdPayment.getPaymentId(), payment.getPaymentId());
        assertEquals("0008", createdPayment.getLastFourDigits());
        assertNotEquals(0, payment.getSystemTime());
        assertNotNull(payment.getHostReference());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
        assertNotNull(payment.getBasketId());
    }
}