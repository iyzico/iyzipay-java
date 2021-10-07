package com.iyzipay.model.subscription;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.PagingRequest;
import com.iyzipay.request.subscription.SearchSubscriptionRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SubscriptionSearch extends IyzipayResource {

    public static SubscriptionSearch search(SearchSubscriptionRequest request, PagingRequest pagingRequest, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/subscriptions" + new SubscriptionSearchQueryParamBuilder().page(pagingRequest.getPage())
                .count(pagingRequest.getCount())
                .page(pagingRequest.getPage())
                .subscriptionReferenceCode(request.getSubscriptionReferenceCode())
                .parentReferenceCode(request.getParentReferenceCode())
                .customerReferenceCode(request.getCustomerReferenceCode())
                .pricingPlanReferenceCode(request.getPricingPlanReferenceCode())
                .subscriptionStatus(request.getSubscriptionStatus())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionSearch.class);
    }

    private static class SubscriptionSearchQueryParamBuilder {

        private Map<String, Object> subscriptionSearchQueryParams;

        public SubscriptionSearchQueryParamBuilder() {
            subscriptionSearchQueryParams = new HashMap<String, Object>();
        }

        public SubscriptionSearchQueryParamBuilder page(Integer page) {
            if (page != null) {
                subscriptionSearchQueryParams.put("page", page);
            }
            return this;
        }

        public SubscriptionSearchQueryParamBuilder count(Integer count) {
            if (count != null) {
                subscriptionSearchQueryParams.put("count", count);
            }
            return this;
        }

        public SubscriptionSearchQueryParamBuilder subscriptionReferenceCode(String subscriptionReferenceCode) {
            if (StringUtils.isNotBlank(subscriptionReferenceCode)) {
                subscriptionSearchQueryParams.put("subscriptionReferenceCode", subscriptionReferenceCode);
            }
            return this;
        }

        public SubscriptionSearchQueryParamBuilder parentReferenceCode(String parentReferenceCode) {
            if (StringUtils.isNotBlank(parentReferenceCode)) {
                subscriptionSearchQueryParams.put("parentReferenceCode", parentReferenceCode);
            }
            return this;
        }

        public SubscriptionSearchQueryParamBuilder customerReferenceCode(String customerReferenceCode) {
            if (StringUtils.isNotBlank(customerReferenceCode)) {
                subscriptionSearchQueryParams.put("customerReferenceCode", customerReferenceCode);
            }
            return this;
        }

        public SubscriptionSearchQueryParamBuilder pricingPlanReferenceCode(String pricingPlanReferenceCode) {
            if (StringUtils.isNotBlank(pricingPlanReferenceCode)) {
                subscriptionSearchQueryParams.put("pricingPlanReferenceCode", pricingPlanReferenceCode);
            }
            return this;
        }

        public SubscriptionSearchQueryParamBuilder subscriptionStatus(String subscriptionStatus) {
            if (subscriptionStatus != null) {
                subscriptionSearchQueryParams.put("subscriptionStatus", subscriptionStatus);
            }
            return this;
        }

        public SubscriptionSearchQueryParamBuilder startDate(String startDate) {
            if (startDate != null) {
                subscriptionSearchQueryParams.put("startDate", startDate);
            }
            return this;
        }

        public SubscriptionSearchQueryParamBuilder endDate(String endDate) {
            if (endDate != null) {
                subscriptionSearchQueryParams.put("endDate", endDate);
            }
            return this;
        }

        public String build() {
            StringBuilder queryParams = new StringBuilder();
            if (subscriptionSearchQueryParams.size() > 0) {
                queryParams.append("?");
            }
            for (Map.Entry<String, Object> entry : subscriptionSearchQueryParams.entrySet()) {
                queryParams
                        .append(entry.getKey())
                        .append("=")
                        .append(entry.getValue().toString())
                        .append("&");
            }
            return queryParams.toString();
        }

    }
}
