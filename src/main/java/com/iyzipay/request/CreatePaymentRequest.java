package com.iyzipay.request;

import com.iyzipay.Constants;
import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.Address;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.Buyer;
import com.iyzipay.model.PaymentCard;
import com.iyzipay.model.loyalty.Loyalty;

import java.math.BigDecimal;
import java.util.List;

public class CreatePaymentRequest extends Request {

    private BigDecimal price;
    private BigDecimal paidPrice;
    private Integer installment;
    private String paymentChannel;
    private String basketId;
    private String paymentGroup;
    private PaymentCard paymentCard;
    private Buyer buyer;
    private Address shippingAddress;
    private Address billingAddress;
    private List<BasketItem> basketItems;
    private String paymentSource;
    private String currency;
    private String posOrderId;
    private String connectorName;
    private String callbackUrl;
    private String gsmNumber;
    private Loyalty reward;

    public CreatePaymentRequest() {
        setInstallment(Constants.SINGLE_INSTALLMENT);
    }

    public Loyalty getReward() {
        return reward;
    }

    public void setReward(Loyalty reward) {
        this.reward = reward;
    }

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

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
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

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
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

    public String getPosOrderId() {
        return posOrderId;
    }

    public void setPosOrderId(String posOrderId) {
        this.posOrderId = posOrderId;
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("price", price)
                .append("paidPrice", paidPrice)
                .append("installment", installment)
                .append("paymentChannel", paymentChannel)
                .append("basketId", basketId)
                .append("paymentGroup", paymentGroup)
                .append("paymentCard", paymentCard)
                .append("buyer", buyer)
                .append("shippingAddress", shippingAddress)
                .append("billingAddress", billingAddress)
                .append("basketItems", basketItems)
                .append("paymentSource", paymentSource)
                .append("currency", currency)
                .append("posOrderId", posOrderId)
                .append("connectorName", connectorName)
                .append("callbackUrl", callbackUrl)
                .append("gsmNumber", gsmNumber)
                .toString();
    }
}
