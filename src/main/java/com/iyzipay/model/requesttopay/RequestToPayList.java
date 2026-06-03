package com.iyzipay.model.requesttopay;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.requesttopay.resource.RequestToPayListData;
import com.iyzipay.request.requesttopay.RetrieveRequestToPayListRequest;

public class RequestToPayList extends IyzipayResource {

    private static final String BASE_PATH = "/v1/merchant/account/request-to-pay";

    @SerializedName("data")
    private RequestToPayListData requestToPayListData;

    public static RequestToPayList retrieve(RetrieveRequestToPayListRequest request, Options options) {
        String path = BASE_PATH + "/retrieve";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                RequestToPayList.class);
    }

    public RequestToPayListData getRequestToPayListData() { return requestToPayListData; }
    public void setRequestToPayListData(RequestToPayListData requestToPayListData) { this.requestToPayListData = requestToPayListData; }
}