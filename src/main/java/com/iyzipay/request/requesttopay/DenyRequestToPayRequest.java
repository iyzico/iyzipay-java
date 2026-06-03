package com.iyzipay.request.requesttopay;

import com.iyzipay.Request;

public class DenyRequestToPayRequest extends Request {

    private String referenceNumber;
    private String description;

    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}