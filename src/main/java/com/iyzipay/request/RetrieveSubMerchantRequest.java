package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class RetrieveSubMerchantRequest extends Request {

    private String subMerchantExternalId;

    public String getSubMerchantExternalId() {
        return subMerchantExternalId;
    }

    public void setSubMerchantExternalId(String subMerchantExternalId) {
        this.subMerchantExternalId = subMerchantExternalId;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("subMerchantExternalId", subMerchantExternalId)
                .toString();
    }
}
