package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.Address;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.Buyer;

import java.math.BigDecimal;
import java.util.List;

public class CreateApmInitializeRequest extends Request {

    private BigDecimal price;
    private BigDecimal paidPrice;
    private String paymentChannel;
    private String paymentGroup;
    private String paymentSource;
    private String currency;
    private String merchantOrderId;
    private String countryCode;
    private String accountHolderName;
    private String merchantCallbackUrl;
    private String merchantErrorUrl;
    private String merchantNotificationUrl;
    private String apmType;
    private String basketId;
    private Buyer buyer;
    private Address shippingAddress;
    private Address billingAddress;
    private List<BasketItem> basketItems;

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

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
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

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getMerchantCallbackUrl() {
        return merchantCallbackUrl;
    }

    public void setMerchantCallbackUrl(String merchantCallbackUrl) {
        this.merchantCallbackUrl = merchantCallbackUrl;
    }

    public String getMerchantErrorUrl() {
        return merchantErrorUrl;
    }

    public void setMerchantErrorUrl(String merchantErrorUrl) {
        this.merchantErrorUrl = merchantErrorUrl;
    }

    public String getMerchantNotificationUrl() {
        return merchantNotificationUrl;
    }

    public void setMerchantNotificationUrl(String merchantNotificationUrl) {
        this.merchantNotificationUrl = merchantNotificationUrl;
    }

    public String getApmType() {
        return apmType;
    }

    public void setApmType(String apmType) {
        this.apmType = apmType;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
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

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("price", price)
                .append("paidPrice", paidPrice)
                .append("paymentChannel", paymentChannel)
                .append("paymentGroup", paymentGroup)
                .append("paymentSource", paymentSource)
                .append("currency", currency)
                .append("merchantOrderId", merchantOrderId)
                .append("countryCode", countryCode)
                .append("accountHolderName", accountHolderName)
                .append("merchantCallbackUrl", merchantCallbackUrl)
                .append("merchantErrorUrl", merchantErrorUrl)
                .append("merchantNotificationUrl", merchantNotificationUrl)
                .append("apmType", apmType)
                .append("basketId", basketId)
                .append("buyer", buyer)
                .append("shippingAddress", shippingAddress)
                .append("billingAddress", billingAddress)
                .append("basketItems", basketItems)
                .toString();
    }
}
