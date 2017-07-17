package com.iyzipay.functional.builder.request;

import com.iyzipay.functional.builder.AddressBuilder;
import com.iyzipay.functional.builder.BasketItemBuilder;
import com.iyzipay.functional.builder.BuyerBuilder;
import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.Address;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.Buyer;
import com.iyzipay.model.PaymentGroup;
import com.iyzipay.request.CreateBkmInitializeRequest;

import java.math.BigDecimal;
import java.util.List;

public final class CreateBkmInitializeRequestBuilder extends BaseRequestBuilder {

    private String basketId = RandomGenerator.randomId();
    private String paymentGroup = PaymentGroup.LISTING.name();
    private Buyer buyer = BuyerBuilder.create().build();
    private Address shippingAddress = AddressBuilder.create().build();
    private Address billingAddress = AddressBuilder.create().build();
    private List<BasketItem> basketItems = BasketItemBuilder.create().buildDefaultBasketItems();
    private String callbackUrl;
    private String paymentSource;
    private BigDecimal price;

    private CreateBkmInitializeRequestBuilder() {
    }

    public static CreateBkmInitializeRequestBuilder create() {
        return new CreateBkmInitializeRequestBuilder();
    }

    public CreateBkmInitializeRequestBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CreateBkmInitializeRequestBuilder basketId(String basketId) {
        this.basketId = basketId;
        return this;
    }

    public CreateBkmInitializeRequestBuilder paymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
        return this;
    }

    public CreateBkmInitializeRequestBuilder paymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
        return this;
    }

    public CreateBkmInitializeRequestBuilder buyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public CreateBkmInitializeRequestBuilder shippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public CreateBkmInitializeRequestBuilder billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public CreateBkmInitializeRequestBuilder basketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        return this;
    }

    public CreateBkmInitializeRequestBuilder callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public CreateBkmInitializeRequest build() {
        CreateBkmInitializeRequest createBkmInitializeRequest = new CreateBkmInitializeRequest();
        createBkmInitializeRequest.setLocale(locale);
        createBkmInitializeRequest.setConversationId(conversationId);
        createBkmInitializeRequest.setPrice(price);
        createBkmInitializeRequest.setBasketId(basketId);
        createBkmInitializeRequest.setPaymentGroup(paymentGroup);
        createBkmInitializeRequest.setPaymentSource(paymentSource);
        createBkmInitializeRequest.setBuyer(buyer);
        createBkmInitializeRequest.setShippingAddress(shippingAddress);
        createBkmInitializeRequest.setBillingAddress(billingAddress);
        createBkmInitializeRequest.setBasketItems(basketItems);
        createBkmInitializeRequest.setCallbackUrl(callbackUrl);
        return createBkmInitializeRequest;
    }
}
