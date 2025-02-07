package com.iyzipay.request;


import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class BlockageInfoRequest extends Request {

    private String subMerchantKey;

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("subMerchantKey", subMerchantKey)
                .toString();
    }
}
