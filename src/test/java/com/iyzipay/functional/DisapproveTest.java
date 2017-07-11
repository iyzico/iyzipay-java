package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CreateApprovalRequestBuilder;
import com.iyzipay.functional.builder.request.CreatePaymentRequestBuilder;
import com.iyzipay.functional.builder.request.CreateSubMerchantRequestBuilder;
import com.iyzipay.model.*;
import com.iyzipay.request.CreateApprovalRequest;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.CreateSubMerchantRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisapproveTest extends BaseTest {

    @Test
    public void should_disapprove_payment() {
        CreateSubMerchantRequest request = CreateSubMerchantRequestBuilder.create()
                .personalSubMerchantRequest()
                .build();
        String subMerchantKey = SubMerchant.create(request, options).getSubMerchantKey();

        CreatePaymentRequest paymentRequest = CreatePaymentRequestBuilder.create()
                .marketplacePayment(subMerchantKey)
                .build();

        Payment payment = Payment.create(paymentRequest, options);
        String paymentTransactionId = payment.getPaymentItems().get(0).getPaymentTransactionId();

        CreateApprovalRequest approvalRequest = CreateApprovalRequestBuilder.create()
                .paymentTransactionId(paymentTransactionId)
                .build();

        Approval.create(approvalRequest, options);

        Disapproval disapproval = Disapproval.create(approvalRequest, options);

        System.out.println(disapproval);

        assertEquals(paymentTransactionId, disapproval.getPaymentTransactionId());
        assertEquals(Status.SUCCESS.getValue(), disapproval.getStatus());
        assertEquals(Locale.TR.getValue(), disapproval.getLocale());
        assertNotNull(disapproval.getSystemTime());
        assertNull(disapproval.getErrorCode());
        assertNull(disapproval.getErrorMessage());
        assertNull(disapproval.getErrorGroup());
    }
}