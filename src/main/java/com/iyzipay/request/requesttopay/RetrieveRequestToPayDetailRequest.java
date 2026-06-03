package com.iyzipay.request.requesttopay;

import com.iyzipay.Request;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayRole;

public class RetrieveRequestToPayDetailRequest extends Request {

    private String requestToPayReferenceNumber;
    private RequestToPayRole requestToPayRole;

    public String getRequestToPayReferenceNumber() { return requestToPayReferenceNumber; }
    public void setRequestToPayReferenceNumber(String requestToPayReferenceNumber) { this.requestToPayReferenceNumber = requestToPayReferenceNumber; }

    public RequestToPayRole getRequestToPayRole() { return requestToPayRole; }
    public void setRequestToPayRole(RequestToPayRole requestToPayRole) { this.requestToPayRole = requestToPayRole; }
}