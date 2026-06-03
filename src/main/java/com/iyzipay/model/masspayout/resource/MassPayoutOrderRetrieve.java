package com.iyzipay.model.masspayout.resource;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.masspayout.MassPayoutOrderRetrieveVo;

public class MassPayoutOrderRetrieve extends IyzipayResource {
    private MassPayoutOrderRetrieveVo item;

    public static MassPayoutOrderRetrieve retrieve(String referenceCode, Options options) {
        String path = "/v1/mass/payout/retrieve/items/" + referenceCode;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2("/v1/mass/payout/retrieve/items/" + referenceCode, null, options),
                null,
                MassPayoutOrderRetrieve.class);
    }

    public MassPayoutOrderRetrieveVo getItem() {
        return item;
    }

    public void setItem(MassPayoutOrderRetrieveVo item) {
        this.item = item;
    }
}

