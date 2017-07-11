package com.iyzipay.functional.builder.request;

import com.iyzipay.functional.builder.AddressBuilder;
import com.iyzipay.functional.builder.BuyerBuilder;
import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.*;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class CreateCheckoutFormInitializeRequestBuilder extends BaseRequestBuilder {

    private String basketId = RandomGenerator.randomId();
    private String paymentGroup = PaymentGroup.LISTING.name();
    private String currency = Currency.TRY.name();
    private Buyer buyer = BuyerBuilder.create().build();
    private Address shippingAddress = AddressBuilder.create().build();
    private Address billingAddress = AddressBuilder.create().build();
    private List<Integer> enabledInstallments = Arrays.asList(2, 3, 6, 9);
    private List<BasketItem> basketItems;
    private String callbackUrl;
    private Integer forceThreeDS;
    private String cardUserKey;
    private String posOrderId;
    private String paymentSource;
    private BigDecimal price;
    private BigDecimal paidPrice;

    private CreateCheckoutFormInitializeRequestBuilder() {
    }

    public static CreateCheckoutFormInitializeRequestBuilder create() {
        return new CreateCheckoutFormInitializeRequestBuilder();
    }

    public CreateCheckoutFormInitializeRequestBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder paidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder basketId(String basketId) {
        this.basketId = basketId;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder paymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder paymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder currency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder buyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder shippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder basketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder forceThreeDS(Integer forceThreeDS) {
        this.forceThreeDS = forceThreeDS;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder cardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder posOrderId(String posOrderId) {
        this.posOrderId = posOrderId;
        return this;
    }

    public CreateCheckoutFormInitializeRequestBuilder enabledInstallments(List<Integer> enabledInstallments) {
        this.enabledInstallments = enabledInstallments;
        return this;
    }

    public CreateCheckoutFormInitializeRequest build() {
        CreateCheckoutFormInitializeRequest createCheckoutFormInitializeRequest = new CreateCheckoutFormInitializeRequest();
        createCheckoutFormInitializeRequest.setLocale(locale);
        createCheckoutFormInitializeRequest.setConversationId(conversationId);
        createCheckoutFormInitializeRequest.setPrice(price);
        createCheckoutFormInitializeRequest.setPaidPrice(paidPrice);
        createCheckoutFormInitializeRequest.setBasketId(basketId);
        createCheckoutFormInitializeRequest.setPaymentGroup(paymentGroup);
        createCheckoutFormInitializeRequest.setPaymentSource(paymentSource);
        createCheckoutFormInitializeRequest.setCurrency(currency);
        createCheckoutFormInitializeRequest.setBuyer(buyer);
        createCheckoutFormInitializeRequest.setShippingAddress(shippingAddress);
        createCheckoutFormInitializeRequest.setBillingAddress(billingAddress);
        createCheckoutFormInitializeRequest.setBasketItems(basketItems);
        createCheckoutFormInitializeRequest.setCallbackUrl(callbackUrl);
        createCheckoutFormInitializeRequest.setForceThreeDS(forceThreeDS);
        createCheckoutFormInitializeRequest.setCardUserKey(cardUserKey);
        createCheckoutFormInitializeRequest.setPosOrderId(posOrderId);
        createCheckoutFormInitializeRequest.setEnabledInstallments(enabledInstallments);
        return createCheckoutFormInitializeRequest;
    }
}
