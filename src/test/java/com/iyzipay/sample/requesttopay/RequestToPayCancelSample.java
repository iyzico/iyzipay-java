package com.iyzipay.sample.requesttopay;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.requesttopay.RequestToPay;
import com.iyzipay.model.requesttopay.enumtype.PaymentPurpose;
import com.iyzipay.request.requesttopay.CreateRequestToPayRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class RequestToPayCancelSample extends Sample {

    @Test
    public void should_cancel_request_to_pay() {
        String referenceNumber = createRequestToPay();
        RequestToPay response = RequestToPay.cancel(referenceNumber, options);
        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
    }

    private String createRequestToPay() {
        CreateRequestToPayRequest request = new CreateRequestToPayRequest();
        request.setLocale(Locale.EN.name());
        request.setConversationId(UUID.randomUUID().toString());
        request.setAmount(new BigDecimal("7700"));
        request.setReceiverName("Opposite Bank");
        request.setReceiverIban("TR760800003287595873972203");
        request.setPaymentPurpose(PaymentPurpose.RESIDENTIAL_RENT);
        request.setExpirationDateTime("2026-05-29T18:49:00");
        request.setDescription("test");
        request.setPartialPayment(false);
        request.setEarlyPayment(true);
        request.setDeferredPayment(false);

        RequestToPay response = RequestToPay.create(request, options);
        assertEquals(Status.SUCCESS.getValue(), response.getStatus());

        String referenceNumber = response.getReferenceNumber();
        System.out.println("Created reference number: " + referenceNumber);
        return referenceNumber;
    }
}