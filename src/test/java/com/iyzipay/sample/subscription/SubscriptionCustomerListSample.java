package com.iyzipay.sample.subscription;

import com.iyzipay.PagingRequest;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionCustomerList;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionCustomerListSample extends Sample {

    @Test
    public void should_retrieve_customer_list() {
        //given
        PagingRequest pagingRequest = new PagingRequest();
        pagingRequest.setCount(10);
        pagingRequest.setPage(2);

        //when
        SubscriptionCustomerList response = SubscriptionCustomerList.retrieve(pagingRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}