package com.iyzipay.functional.builder.request;

import com.iyzipay.functional.builder.AddressBuilder;
import com.iyzipay.functional.builder.BasketItemBuilder;
import com.iyzipay.functional.builder.BuyerBuilder;
import com.iyzipay.functional.builder.PaymentCardBuilder;
import com.iyzipay.model.*;
import com.iyzipay.request.CreatePaymentRequest;

import java.math.BigDecimal;
import java.util.List;

public final class CreatePaymentRequestBuilder extends BaseRequestBuilder {

    private BigDecimal price = BigDecimal.ONE;
    private BigDecimal paidPrice = BigDecimal.valueOf(1.1);
    private Integer installment = 1;
    private String paymentChannel = PaymentChannel.WEB.name();
    private String basketId = "B67832";
    private String paymentGroup;
    private Buyer buyer = BuyerBuilder.create().build();
    private Address shippingAddress = AddressBuilder.create().build();
    private Address billingAddress = AddressBuilder.create().build();
    private List<BasketItem> basketItems;
    private String currency = Currency.TRY.name();
    private PaymentCard paymentCard = PaymentCardBuilder.create().buildWithCardCredentials().build();
    private String paymentSource;
    private String callbackUrl;
    private String posOrderId;
    private String connectorName;
    private String gsmNumber;

    private CreatePaymentRequestBuilder() {
    }

    public static CreatePaymentRequestBuilder create() {
        return new CreatePaymentRequestBuilder();
    }

    public CreatePaymentRequestBuilder locale(String locale) {
        this.locale = locale;
        return this;
    }

    public CreatePaymentRequestBuilder conversationId(String conversationId) {
        this.conversationId = conversationId;
        return this;
    }

    public CreatePaymentRequestBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CreatePaymentRequestBuilder paidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
        return this;
    }

    public CreatePaymentRequestBuilder installment(Integer installment) {
        this.installment = installment;
        return this;
    }

    public CreatePaymentRequestBuilder paymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
        return this;
    }

    public CreatePaymentRequestBuilder basketId(String basketId) {
        this.basketId = basketId;
        return this;
    }

    public CreatePaymentRequestBuilder paymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
        return this;
    }

    public CreatePaymentRequestBuilder paymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
        return this;
    }

    public CreatePaymentRequestBuilder buyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public CreatePaymentRequestBuilder shippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public CreatePaymentRequestBuilder billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public CreatePaymentRequestBuilder basketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        return this;
    }

    public CreatePaymentRequestBuilder paymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
        return this;
    }

    public CreatePaymentRequestBuilder callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public CreatePaymentRequestBuilder posOrderId(String posOrderId) {
        this.posOrderId = posOrderId;
        return this;
    }

    public CreatePaymentRequestBuilder connectorName(String connectorName) {
        this.connectorName = connectorName;
        return this;
    }

    public CreatePaymentRequestBuilder currency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreatePaymentRequestBuilder gsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
        return this;
    }

    public CreatePaymentRequest build() {
        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
        createPaymentRequest.setLocale(locale);
        createPaymentRequest.setConversationId(conversationId);
        createPaymentRequest.setPrice(price);
        createPaymentRequest.setPaidPrice(paidPrice);
        createPaymentRequest.setInstallment(installment);
        createPaymentRequest.setPaymentChannel(paymentChannel);
        createPaymentRequest.setBasketId(basketId);
        createPaymentRequest.setPaymentGroup(paymentGroup);
        createPaymentRequest.setPaymentCard(paymentCard);
        createPaymentRequest.setBuyer(buyer);
        createPaymentRequest.setShippingAddress(shippingAddress);
        createPaymentRequest.setBillingAddress(billingAddress);
        createPaymentRequest.setBasketItems(basketItems);
        createPaymentRequest.setPaymentSource(paymentSource);
        createPaymentRequest.setCallbackUrl(callbackUrl);
        createPaymentRequest.setPosOrderId(posOrderId);
        createPaymentRequest.setConnectorName(connectorName);
        createPaymentRequest.setCurrency(currency);
        createPaymentRequest.setGsmNumber(gsmNumber);
        return createPaymentRequest;
    }

    public CreatePaymentRequestBuilder marketplacePayment(String subMerchantKey) {
        this.basketItems = BasketItemBuilder.create().buildBasketItemsWithSubMerchantKey(subMerchantKey);
        this.paymentGroup = PaymentGroup.PRODUCT.name();
        return this;
    }

    public CreatePaymentRequestBuilder standardListingPayment() {
        this.basketItems = BasketItemBuilder.create().buildDefaultBasketItems();
        this.paymentGroup = PaymentGroup.LISTING.name();
        return this;
    }
}
