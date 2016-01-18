package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class UpdateSubMerchantRequest extends Request {

    private String subMerchantKey;
    private String identityNumber;
    private String taxNumber;

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("subMerchantKey", subMerchantKey)
                .append("identityNumber", identityNumber)
                .append("taxNumber", taxNumber)
                .toString();
    }
}
