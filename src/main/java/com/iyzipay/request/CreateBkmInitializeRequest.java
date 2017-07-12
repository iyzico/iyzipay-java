package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.Address;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.Buyer;

import java.math.BigDecimal;
import java.util.List;

public class CreateBkmInitializeRequest extends Request {

    private BigDecimal price;
    private String basketId;
    private String paymentGroup;
    private Buyer buyer;
    private Address shippingAddress;
    private Address billingAddress;
    private List<BasketItem> basketItems;
    private String callbackUrl;
    private String paymentSource;
    private String currency;
    private List<Integer> enabledInstallments;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public String getPaymentGroup() {
        return paymentGroup;
    }

    public void setPaymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPaymentSource() {
        return paymentSource;
    }

    public void setPaymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Integer> getEnabledInstallments() {
        return enabledInstallments;
    }

    public void setEnabledInstallments(List<Integer> enabledInstallments) {
        this.enabledInstallments = enabledInstallments;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("price", price)
                .append("basketId", basketId)
                .append("paymentGroup", paymentGroup)
                .append("buyer", buyer)
                .append("shippingAddress", shippingAddress)
                .append("billingAddress", billingAddress)
                .append("basketItems", basketItems)
                .append("callbackUrl", callbackUrl)
                .append("paymentSource", paymentSource)
                .append("currency", currency)
                .append("enabledInstallments", enabledInstallments)
                .toString();
    }
}
