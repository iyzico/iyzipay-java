package com.iyzipay.sample.requesttopay;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.requesttopay.RequestToPay;
import com.iyzipay.model.requesttopay.enumtype.PaymentPurpose;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayStatus;
import com.iyzipay.request.requesttopay.CreateRequestToPayRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestToPayCreateSample extends RequestToPaySample {

    @Test
    public void should_create_request_to_pay() {
        CreateRequestToPayRequest request = new CreateRequestToPayRequest();
        request.setLocale(Locale.EN.name());
        request.setConversationId("1234567");
        request.setAmount(new BigDecimal("7700"));
        request.setReceiverName("Opposite Bank");
        request.setReceiverIban("TR760800003287595873972203");
        request.setPaymentPurpose(PaymentPurpose.RESIDENTIAL_RENT);
        request.setExpirationDateTime("2026-05-29T18:49:00");
        request.setDescription("test");
        request.setPartialPayment(false);
        request.setEarlyPayment(true);
        request.setDeferredPayment(false);
        request.setChannelType("API");

        RequestToPay response = RequestToPay.create(request, receiverOptions);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertNotNull(response.getRequestToPayStatus());
        assertEquals(RequestToPayStatus.WAITING, response.getRequestToPayStatus());
        assertNotNull(response.getReferenceNumber());
    }
}