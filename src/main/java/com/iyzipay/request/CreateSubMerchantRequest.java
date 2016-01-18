package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class CreateSubMerchantRequest extends Request {

    private String subMerchantExternalId;
    private String identityNumber;
    private String taxNumber;
    private String subMerchantType;

    public String getSubMerchantExternalId() {
        return subMerchantExternalId;
    }

    public void setSubMerchantExternalId(String subMerchantExternalId) {
        this.subMerchantExternalId = subMerchantExternalId;
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

    public String getSubMerchantType() {
        return subMerchantType;
    }

    public void setSubMerchantType(String subMerchantType) {
        this.subMerchantType = subMerchantType;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("subMerchantExternalId", subMerchantExternalId)
                .append("identityNumber", identityNumber)
                .append("taxNumber", taxNumber)
                .append("subMerchantType", subMerchantType)
                .toString();
    }
}
