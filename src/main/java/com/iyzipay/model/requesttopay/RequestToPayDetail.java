package com.iyzipay.model.requesttopay;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.requesttopay.resource.RequestToPayDetailData;
import com.iyzipay.request.requesttopay.RetrieveRequestToPayDetailRequest;

public class RequestToPayDetail extends IyzipayResource {

    private static final String BASE_PATH = "/v1/merchant/account/request-to-pay";

    @SerializedName("data")
    private RequestToPayDetailData requestToPayDetailData;

    public static RequestToPayDetail retrieve(RetrieveRequestToPayDetailRequest request, Options options) {
        String path = BASE_PATH + "/retrieve-detail";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                RequestToPayDetail.class);
    }

    public RequestToPayDetailData getRequestToPayDetailData() { return requestToPayDetailData; }
    public void setRequestToPayDetailData(RequestToPayDetailData requestToPayDetailData) { this.requestToPayDetailData = requestToPayDetailData; }
}