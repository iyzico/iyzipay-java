package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveIyziupFormRequest;

public class IyziupForm extends IyzipayResource {

    private String orderResponseStatus;
    private String token;
    private String callbackUrl;
    private Consumer consumer;
    private Address shippingAddress;
    private Address billingAddress;
    private IyziupPayment paymentDetail;

    public static IyziupForm retrieve(RetrieveIyziupFormRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/v1/iyziup/form/order/retrieve",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                IyziupForm.class);
    }

    public String getOrderResponseStatus() {
        return orderResponseStatus;
    }

    public void setOrderResponseStatus(String orderResponseStatus) {
        this.orderResponseStatus = orderResponseStatus;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
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

    public IyziupPayment getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(IyziupPayment paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
