package com.iyzipay.model.masspayout;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.MassPayoutOrderRetrieveVo;
import com.iyzipay.model.MassPayoutRetrieveVo;
import com.iyzipay.model.PageDto;
import com.iyzipay.request.masspayout.MassPayoutRetrieveRequest;

public class MassPayoutRetrieve extends IyzipayResource {

    private MassPayoutRetrieveVo massPayout;
    private PageDto<MassPayoutOrderRetrieveVo> massPayoutItems;

    public static MassPayoutRetrieve retrieve(MassPayoutRetrieveRequest request, Options options) {
        String path = "/v1/mass/payout/retrieve";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2("/v1/mass/payout/retrieve", request, options),
                request,
                MassPayoutRetrieve.class);
    }

    public MassPayoutRetrieveVo getMassPayout() {
        return massPayout;
    }

    public void setMassPayout(MassPayoutRetrieveVo massPayout) {
        this.massPayout = massPayout;
    }

    public PageDto<MassPayoutOrderRetrieveVo> getMassPayoutItems() {
        return massPayoutItems;
    }

    public void setMassPayoutItems(PageDto<MassPayoutOrderRetrieveVo> massPayoutItems) {
        this.massPayoutItems = massPayoutItems;
    }
}
