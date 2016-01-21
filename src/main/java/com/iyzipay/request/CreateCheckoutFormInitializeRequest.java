package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.BillingAddress;
import com.iyzipay.model.Buyer;
import com.iyzipay.model.ShippingAddress;

import java.math.BigDecimal;
import java.util.List;

public class CreateCheckoutFormInitializeRequest extends Request {

    private BigDecimal price;
    private BigDecimal paidPrice;
    private String basketId;
    private String paymentGroup;
    private String paymentSource;
    private Buyer buyer;
    private ShippingAddress shippingAddress;
    private BillingAddress billingAddress;
    private List<BasketItem> basketItems;
    private String callbackUrl;
    private Integer forceThreeDS;
    private String cardUserKey;
    private String posOrderId;

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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
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
                .append("posOrderId", posOrderId)
                .append("paidPrice", paidPrice)
                .append("forceThreeDS", forceThreeDS)
                .append("cardUserKey", cardUserKey)
                .toString();
    }
}
