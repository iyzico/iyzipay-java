package com.iyzipay.model.sample;

import com.iyzipay.model.Approval;
import com.iyzipay.model.Disapproval;
import com.iyzipay.model.Locale;
import com.iyzipay.request.CreateApprovalRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApprovalSample extends Sample {

    @Test
    public void should_approve_payment_item(){
        CreateApprovalRequest request = new CreateApprovalRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("2");

        Approval approval = Approval.create(request, options);

        System.out.println(approval);

        assertNotNull(approval.getSystemTime());
        assertEquals("success", approval.getStatus());
        assertEquals(Locale.TR.getValue(), approval.getLocale());
        assertEquals("123456789", approval.getConversationId());

        assertEquals("2", approval.getPaymentTransactionId());
    }

    @Test
    public void should_disapprove_payment_item(){
        CreateApprovalRequest request = new CreateApprovalRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("2");

        Disapproval disapproval = Disapproval.create(request, options);

        System.out.println(disapproval);

        assertNotNull(disapproval.getSystemTime());
        assertEquals("success", disapproval.getStatus());
        assertEquals(Locale.TR.getValue(), disapproval.getLocale());
        assertEquals("123456789", disapproval.getConversationId());

        assertEquals("2", disapproval.getPaymentTransactionId());
    }
}
