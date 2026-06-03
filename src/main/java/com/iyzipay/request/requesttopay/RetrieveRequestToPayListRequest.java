package com.iyzipay.request.requesttopay;

import com.iyzipay.PagingRequest;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayRole;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayStatus;

import java.time.LocalDateTime;
import java.util.List;

public class RetrieveRequestToPayListRequest extends PagingRequest {

    private RequestToPayRole requestToPayRole;
    private String startDate;
    private String endDate;
    private List<RequestToPayStatus> statuses;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public RequestToPayRole getRequestToPayRole() { return requestToPayRole; }
    public void setRequestToPayRole(RequestToPayRole requestToPayRole) { this.requestToPayRole = requestToPayRole; }

    public List<RequestToPayStatus> getStatuses() { return statuses; }
    public void setStatuses(List<RequestToPayStatus> statuses) { this.statuses = statuses; }
}