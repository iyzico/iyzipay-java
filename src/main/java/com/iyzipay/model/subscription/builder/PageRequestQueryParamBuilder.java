package com.iyzipay.model.subscription.builder;

import java.util.HashMap;
import java.util.Map;

public class PageRequestQueryParamBuilder {

    private Map<String, Object> subscriptionCustomerQueryParams;

    public PageRequestQueryParamBuilder() {
        subscriptionCustomerQueryParams = new HashMap<String, Object>();
    }

    public PageRequestQueryParamBuilder page(Integer page) {
        if (page != null) {
            subscriptionCustomerQueryParams.put("page", page);
        }
        return this;
    }

    public PageRequestQueryParamBuilder count(Integer count) {
        if (count != null) {
            subscriptionCustomerQueryParams.put("count", count);
        }
        return this;
    }

    public String build() {
        StringBuilder queryParams = new StringBuilder();
        if (subscriptionCustomerQueryParams.size() > 0) {
            queryParams.append("?");
        }
        for (Map.Entry<String, Object> entry : subscriptionCustomerQueryParams.entrySet()) {
            queryParams
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue().toString())
                    .append("&");
        }
        return queryParams.toString();
    }
}
