package com.iyzipay.sample.requesttopay;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.requesttopay.RequestToPayList;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayRole;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayStatus;
import com.iyzipay.request.requesttopay.RetrieveRequestToPayListRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestToPayRetrieveSample extends Sample {

    @Test
    public void should_retrieve_request_to_pay_list() {
        RetrieveRequestToPayListRequest request = new RetrieveRequestToPayListRequest();
        request.setLocale(Locale.TR.name());
        request.setConversationId("123456789");
        request.setRequestToPayRole(RequestToPayRole.DEBTOR);
        request.setStartDate(LocalDateTime.now().minusDays(30).toString());
        request.setEndDate(LocalDateTime.now().toString());
        request.setStatuses(Arrays.asList(RequestToPayStatus.WAITING, RequestToPayStatus.ACCEPTED));
        request.setPage(1);
        request.setCount(10);

        RequestToPayList response = RequestToPayList.retrieve(request, options);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertNotNull(response.getRequestToPayListData());
    }
}