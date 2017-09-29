package com.iyzipay.functional.builder.request;

import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.Currency;
import com.iyzipay.model.OrderItem;
import com.iyzipay.model.PaymentGroup;
import com.iyzipay.request.CreateIyziupFormInitializeRequest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class CreateIyziupFormInitializeRequestBuilder extends BaseRequestBuilder {

    private String merchantOrderId = RandomGenerator.randomId();
    private String paymentGroup = PaymentGroup.LISTING.name();
    private String paymentSource;
    private String currency = Currency.TRY.name();
    private Integer forceThreeDS;
    private List<Integer> enabledInstallments = Arrays.asList(2, 3, 6, 9);
    private String enabledCardFamily;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal shippingPrice;
    private String callbackUrl;
    private String termsUrl;
    private String preSalesContractUrl;
    private List<OrderItem> orderItems;

    private CreateIyziupFormInitializeRequestBuilder() {
    }

    public static CreateIyziupFormInitializeRequestBuilder create() {
        return new CreateIyziupFormInitializeRequestBuilder();
    }

    public CreateIyziupFormInitializeRequestBuilder merchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder paymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder paymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder forceThreeDS(Integer forceThreeDS) {
        this.forceThreeDS = forceThreeDS;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder enabledInstallments(List<Integer> enabledInstallments) {
        this.enabledInstallments = enabledInstallments;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder enabledCardFamily(String enabledCardFamily) {
        this.enabledCardFamily = enabledCardFamily;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder currency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder paidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder shippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder termsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder preSalesContractUrl(String preSalesContractUrl) {
        this.preSalesContractUrl = preSalesContractUrl;
        return this;
    }

    public CreateIyziupFormInitializeRequestBuilder orderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public CreateIyziupFormInitializeRequest build() {
        CreateIyziupFormInitializeRequest createCheckoutFormInitializeRequest = new CreateIyziupFormInitializeRequest();
        createCheckoutFormInitializeRequest.setLocale(locale);
        createCheckoutFormInitializeRequest.setConversationId(conversationId);
        createCheckoutFormInitializeRequest.setMerchantOrderId(merchantOrderId);
        createCheckoutFormInitializeRequest.setPaymentGroup(paymentGroup);
        createCheckoutFormInitializeRequest.setPaymentSource(paymentSource);
        createCheckoutFormInitializeRequest.setForceThreeDS(forceThreeDS);
        createCheckoutFormInitializeRequest.setEnabledInstallments(enabledInstallments);
        createCheckoutFormInitializeRequest.setEnabledCardFamily(enabledCardFamily);
        createCheckoutFormInitializeRequest.setCurrency(currency);
        createCheckoutFormInitializeRequest.setPrice(price);
        createCheckoutFormInitializeRequest.setPaidPrice(paidPrice);
        createCheckoutFormInitializeRequest.setShippingPrice(shippingPrice);
        createCheckoutFormInitializeRequest.setCallbackUrl(callbackUrl);
        createCheckoutFormInitializeRequest.setTermsUrl(termsUrl);
        createCheckoutFormInitializeRequest.setPreSalesContractUrl(preSalesContractUrl);
        createCheckoutFormInitializeRequest.setOrderItems(orderItems);
        return createCheckoutFormInitializeRequest;
    }
}
