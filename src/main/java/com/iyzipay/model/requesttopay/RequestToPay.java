package com.iyzipay.model.requesttopay;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayStatus;
import com.iyzipay.model.requesttopay.resource.RequestToPayData;
import com.iyzipay.request.requesttopay.CreateRequestToPayRequest;
import com.iyzipay.request.requesttopay.DenyRequestToPayRequest;
import com.iyzipay.request.requesttopay.ReplyRequestToPayRequest;

public class RequestToPay extends IyzipayResource {

    private static final String BASE_PATH = "/v1/merchant/account/request-to-pay";

    @SerializedName("requestToPayStatus")
    private RequestToPayStatus requestToPayStatus;

    @SerializedName("referenceNumber")
    private String referenceNumber;

    @SerializedName("data")
    private RequestToPayData requestToPayData;

    public static RequestToPay create(CreateRequestToPayRequest request, Options options) {
        String path = BASE_PATH + "/create";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                RequestToPay.class);
    }

    public static RequestToPay reply(ReplyRequestToPayRequest request, Options options) {
        String path = BASE_PATH + "/reply";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                RequestToPay.class);
    }

    public static RequestToPay cancel(String referenceNumber, Options options) {
        String path = BASE_PATH + "/cancel/" + referenceNumber;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                RequestToPay.class);
    }

    public static RequestToPay retrieve(String referenceNumber, Options options) {
        String path = BASE_PATH + "/" + referenceNumber;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                RequestToPay.class);
    }

    public static RequestToPay deny(DenyRequestToPayRequest request, Options options) {
        String path = BASE_PATH + "/deny";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                RequestToPay.class);
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public RequestToPayStatus getRequestToPayStatus() {
        return requestToPayStatus;
    }

    public void setRequestToPayStatus(RequestToPayStatus requestToPayStatus) {
        this.requestToPayStatus = requestToPayStatus;
    }

    public RequestToPayData getRequestToPayData() {
        return requestToPayData;
    }

    public void setRequestToPayData(RequestToPayData requestToPayData) {
        this.requestToPayData = requestToPayData;
    }
}