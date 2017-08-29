package com.iyzipay.request;


import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class RetrieveCardManagementPageCardRequest extends Request {

    private String pageToken;

    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("token", pageToken).toString();
    }
}
