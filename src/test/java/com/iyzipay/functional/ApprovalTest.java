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

public class ApprovalTest extends BaseTest {

    @Test
    public void should_approve_payment_item() {
        CreateSubMerchantRequest request = CreateSubMerchantRequestBuilder.create()
                .personalSubMerchantRequest()
                .build();

        String subMerchantKey = SubMerchant.create(request, options)
                .getSubMerchantKey();

        CreatePaymentRequest paymentRequest = CreatePaymentRequestBuilder.create()
                .marketplacePayment(subMerchantKey)
                .build();

        Payment payment = Payment.create(paymentRequest, options);
        String paymentTransactionId = payment.getPaymentItems().get(0).getPaymentTransactionId();

        CreateApprovalRequest approvalRequest = CreateApprovalRequestBuilder.create()
                .paymentTransactionId(paymentTransactionId)
                .build();

        Approval approval = Approval.create(approvalRequest, options);

        assertEquals(paymentTransactionId, approval.getPaymentTransactionId());
        assertEquals(Locale.TR.getValue(), payment.getLocale());
        assertEquals(Status.SUCCESS.getValue(), payment.getStatus());
        assertNotNull(payment.getSystemTime());
        assertNull(payment.getErrorCode());
        assertNull(payment.getErrorMessage());
        assertNull(payment.getErrorGroup());
    }
}