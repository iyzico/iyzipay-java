package com.iyzipay.sample.subscription;

import com.iyzipay.PagingRequest;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionProductList;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionProductListSample extends Sample {

    @Test
    public void should_retrieve_product_list() {
        //given
        PagingRequest request = new PagingRequest();
        request.setCount(4);
        request.setPage(1);
        request.setConversationId("12345");
        request.setLocale(Locale.TR.name());

        //when
        SubscriptionProductList response = SubscriptionProductList.retrieve(request, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getSubscriptionProductListResource());
    }
}