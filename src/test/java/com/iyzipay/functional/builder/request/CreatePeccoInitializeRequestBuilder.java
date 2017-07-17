package com.iyzipay.functional.builder.request;

import com.iyzipay.functional.builder.AddressBuilder;
import com.iyzipay.functional.builder.BasketItemBuilder;
import com.iyzipay.functional.builder.BuyerBuilder;
import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.Address;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.Buyer;
import com.iyzipay.model.Currency;
import com.iyzipay.request.CreatePeccoInitializeRequest;

import java.math.BigDecimal;
import java.util.List;

public final class CreatePeccoInitializeRequestBuilder extends BaseRequestBuilder {

    private String currency = Currency.IRR.name();
    private String basketId = RandomGenerator.randomId();
    private String paymentGroup;
    private Buyer buyer = BuyerBuilder.create().build();
    private Address shippingAddress = AddressBuilder.create().build();
    private Address billingAddress = AddressBuilder.create().build();
    private String paymentSource;
    private List<BasketItem> basketItems = BasketItemBuilder.create().buildDefaultBasketItems();
    private String callbackUrl;
    private BigDecimal paidPrice;
    private BigDecimal price;

    private CreatePeccoInitializeRequestBuilder() {
    }

    public static CreatePeccoInitializeRequestBuilder create() {
        return new CreatePeccoInitializeRequestBuilder();
    }

    public CreatePeccoInitializeRequestBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder paidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder currency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder basketId(String basketId) {
        this.basketId = basketId;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder paymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder paymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder buyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder shippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder basketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        return this;
    }

    public CreatePeccoInitializeRequestBuilder callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public CreatePeccoInitializeRequest build() {
        CreatePeccoInitializeRequest createPeccoInitializeRequest = new CreatePeccoInitializeRequest();
        createPeccoInitializeRequest.setLocale(locale);
        createPeccoInitializeRequest.setConversationId(conversationId);
        createPeccoInitializeRequest.setPrice(price);
        createPeccoInitializeRequest.setPaidPrice(paidPrice);
        createPeccoInitializeRequest.setCurrency(currency);
        createPeccoInitializeRequest.setBasketId(basketId);
        createPeccoInitializeRequest.setPaymentGroup(paymentGroup);
        createPeccoInitializeRequest.setPaymentSource(paymentSource);
        createPeccoInitializeRequest.setBuyer(buyer);
        createPeccoInitializeRequest.setShippingAddress(shippingAddress);
        createPeccoInitializeRequest.setBillingAddress(billingAddress);
        createPeccoInitializeRequest.setBasketItems(basketItems);
        createPeccoInitializeRequest.setCallbackUrl(callbackUrl);
        return createPeccoInitializeRequest;
    }
}
