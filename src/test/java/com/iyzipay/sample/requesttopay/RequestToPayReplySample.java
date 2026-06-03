package com.iyzipay.sample.requesttopay;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.requesttopay.RequestToPay;
import com.iyzipay.model.requesttopay.enumtype.PaymentPurpose;
import com.iyzipay.request.requesttopay.CreateRequestToPayRequest;
import com.iyzipay.request.requesttopay.ReplyRequestToPayRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestToPayReplySample extends RequestToPaySample {

    @Test
    public void should_reply_request_to_pay() {
        String referenceNumber = createRequestToPay();

        ReplyRequestToPayRequest request = new ReplyRequestToPayRequest();
        request.setLocale(Locale.EN.name());
        request.setConversationId(UUID.randomUUID().toString());
        request.setReferenceNumber(referenceNumber);
        request.setAmount(new BigDecimal("7700"));
        request.setPaymentDateTime(LocalDateTime.now().plusDays(1).toString());

        RequestToPay response = RequestToPay.reply(request, receiverOptions);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
    }

    private String createRequestToPay() {
        CreateRequestToPayRequest request = new CreateRequestToPayRequest();
        request.setLocale(Locale.EN.name());
        request.setConversationId(UUID.randomUUID().toString());
        request.setAmount(new BigDecimal("7700"));
        request.setReceiverName("John Stone");
        request.setReceiverIban("TR950086401100004979103567");
        request.setPaymentPurpose(PaymentPurpose.RESIDENTIAL_RENT);
        request.setExpirationDateTime(LocalDateTime.now().plusDays(19).toString());
        request.setDescription("test description");
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