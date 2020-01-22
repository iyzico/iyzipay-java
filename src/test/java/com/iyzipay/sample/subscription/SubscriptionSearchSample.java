package com.iyzipay.sample.subscription;

import com.iyzipay.PagingRequest;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionSearch;
import com.iyzipay.model.subscription.resource.SubscriptionStatus;
import com.iyzipay.request.subscription.SearchSubscriptionRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionSearchSample extends Sample {

    @Test
    public void should_subscription_search() {
        SearchSubscriptionRequest searchSubscriptionRequest = new SearchSubscriptionRequest();
        searchSubscriptionRequest.setCustomerReferenceCode("dfc1d5d2-1859-4582-9889-30f9c409d86f");
        searchSubscriptionRequest.setParentReferenceCode("9de61a3a-0bf5-4c7a-a3ae-a016cb899890");
        searchSubscriptionRequest.setSubscriptionReferenceCode("f0e49796-158e-47fb-9c26-f4e6e50721d9");
        searchSubscriptionRequest.setStartDate("2020-01-22 13:37:20");
        searchSubscriptionRequest.setEndDate("2020-04-04 13:37:20");
        searchSubscriptionRequest.setPricingPlanReferenceCode("23893e87-ef29-4b96-936f-e50ffce1f362");
        searchSubscriptionRequest.setSubscriptionStatus(SubscriptionStatus.ACTIVE.name());

        PagingRequest pagingRequest = new PagingRequest();
        pagingRequest.setCount(1);
        pagingRequest.setPage(2);
        pagingRequest.setConversationId("12345");
        pagingRequest.setLocale(Locale.TR.name());

        SubscriptionSearch response = SubscriptionSearch.search(searchSubscriptionRequest, pagingRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}
