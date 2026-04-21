package com.iyzipay.request.subscription;

import com.iyzipay.Request;

public class DeleteSubscriptionProductRequest extends Request {

    private String productReferenceCode;

    public String getProductReferenceCode() {
        return productReferenceCode;
    }

    public void setProductReferenceCode(String productReferenceCode) {
        this.productReferenceCode = productReferenceCode;
    }
}
