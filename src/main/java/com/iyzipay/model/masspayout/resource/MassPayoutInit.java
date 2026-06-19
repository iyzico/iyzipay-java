package com.iyzipay.model.masspayout.resource;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.masspayout.InvalidOrderVo;
import com.iyzipay.request.masspayout.MassPayoutInitRequest;

import java.util.List;

public class MassPayoutInit extends IyzipayResource {

    private String requestId;
    private List<InvalidOrderVo> invalidItems;

    public static MassPayoutInit init(MassPayoutInitRequest request, Options options) {
        String path = "/v1/mass/payout/init";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2("/v1/mass/payout/init", request, options),
                request,
                MassPayoutInit.class);
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<InvalidOrderVo> getInvalidItems() {
        return invalidItems;
    }

    public void setInvalidItems(List<InvalidOrderVo> invalidItems) {
        this.invalidItems = invalidItems;
    }
}

