package com.iyzipay.sample;

import com.iyzipay.model.Disapproval;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateApprovalRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisapproveSample extends Sample {

    @Test
    public void should_disapprove_payment_item() {
        CreateApprovalRequest request = new CreateApprovalRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("1");

        Disapproval disapproval = Disapproval.create(request, options);

        System.out.println(disapproval);

        assertEquals(Status.SUCCESS.getValue(), disapproval.getStatus());
        assertEquals(Locale.TR.getValue(), disapproval.getLocale());
        assertEquals("123456789", disapproval.getConversationId());
        assertNotNull(disapproval.getSystemTime());
        assertNull(disapproval.getErrorCode());
        assertNull(disapproval.getErrorMessage());
        assertNull(disapproval.getErrorGroup());
    }
}
