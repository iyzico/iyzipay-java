package com.iyzipay.sample.requesttopay;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.requesttopay.RequestToPayDetail;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayRole;
import com.iyzipay.request.requesttopay.RetrieveRequestToPayDetailRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestToPayRetrieveDetailSample extends Sample {

    @Test
    public void should_retrieve_request_to_pay_detail() {
        RetrieveRequestToPayDetailRequest request = new RetrieveRequestToPayDetailRequest();
        request.setLocale(Locale.TR.name());
        request.setConversationId("123456789");
        request.setRequestToPayReferenceNumber("0864-7496e82e-7051-4e8e-89e6-6b1b3948abd1");
        request.setRequestToPayRole(RequestToPayRole.CREDITOR);

        RequestToPayDetail response = RequestToPayDetail.retrieve(request, options);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertNotNull(response.getRequestToPayDetailData());
    }
}