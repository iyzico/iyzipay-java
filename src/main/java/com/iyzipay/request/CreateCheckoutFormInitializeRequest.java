package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.Address;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.Buyer;

import java.math.BigDecimal;
import java.util.List;

public class CreateCheckoutFormInitializeRequest extends Request {

    private BigDecimal price;
    private BigDecimal paidPrice;
    private String basketId;
    private String paymentGroup;
    private String paymentSource;
    private String currency;
    private Buyer buyer;
    private Address shippingAddress;
    private Address billingAddress;
    private List<BasketItem> basketItems;
    private String callbackUrl;
    private Integer forceThreeDS;
    private String cardUserKey;
    private String posOrderId;
    private List<Integer> enabledInstallments;
    private Boolean paymentWithNewCardEnabled;
    private Boolean debitCardAllowed;
    private Boolean subscriptionPaymentEnabled;
    private Boolean payWithIyzico;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
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

    public Integer getForceThreeDS() {
        return forceThreeDS;
    }

    public void setForceThreeDS(Integer forceThreeDS) {
        this.forceThreeDS = forceThreeDS;
    }

    public String getCardUserKey() {
        return cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    public String getPosOrderId() {
        return posOrderId;
    }

    public void setPosOrderId(String posOrderId) {
        this.posOrderId = posOrderId;
    }

    public List<Integer> getEnabledInstallments() {
        return enabledInstallments;
    }

    public void setEnabledInstallments(List<Integer> enabledInstallments) {
        this.enabledInstallments = enabledInstallments;
    }

    public Boolean getPaymentWithNewCardEnabled() {
        return paymentWithNewCardEnabled;
    }

    public void setPaymentWithNewCardEnabled(Boolean paymentWithNewCardEnabled) {
        this.paymentWithNewCardEnabled = paymentWithNewCardEnabled;
    }

    public Boolean getDebitCardAllowed() {
        return debitCardAllowed;
    }

    public void setDebitCardAllowed(Boolean debitCardAllowed) {
        this.debitCardAllowed = debitCardAllowed;
    }

    public Boolean getSubscriptionPaymentEnabled() {
        return subscriptionPaymentEnabled;
    }

    public void setSubscriptionPaymentEnabled(Boolean subscriptionPaymentEnabled) {
        this.subscriptionPaymentEnabled = subscriptionPaymentEnabled;
    }

    public Boolean getPayWithIyzico() {
        return payWithIyzico;
    }

    public void setPayWithIyzico(Boolean payWithIyzico) {
        this.payWithIyzico = payWithIyzico;
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
                .append("posOrderId", posOrderId)
                .append("paidPrice", paidPrice)
                .append("forceThreeDS", forceThreeDS)
                .append("cardUserKey", cardUserKey)
                .append("enabledInstallments", enabledInstallments)
                .append("paymentWithNewCardEnabled", paymentWithNewCardEnabled)
                .append("debitCardAllowed", debitCardAllowed)
                .append("subscriptionPaymentEnabled", subscriptionPaymentEnabled)
                .append("payWithIyzico", payWithIyzico)
                .toString();
    }
}
