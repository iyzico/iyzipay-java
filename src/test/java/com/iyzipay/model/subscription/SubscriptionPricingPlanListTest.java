package com.iyzipay.model.subscription;

import com.iyzipay.PagingRequest;
import com.iyzipay.model.Status;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SubscriptionPricingPlanListTest extends Sample {

    @Test
    public void should_retrieve() {
        //given
        PagingRequest pagingRequest = new PagingRequest();
        pagingRequest.setPage(1);
        pagingRequest.setCount(10);
        pagingRequest.setLocale("Tr");
        pagingRequest.setConversationId("123456");

        //when
        SubscriptionPricingPlanList response = SubscriptionPricingPlanList.retrieve("553d006c-da91-46d3-81a4-8297881d6b9e", pagingRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getSubscriptionPricingPlanListResource().getSubscriptionPricingPlansResource());
    }
}