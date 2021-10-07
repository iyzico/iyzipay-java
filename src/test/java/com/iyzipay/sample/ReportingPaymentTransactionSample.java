package com.iyzipay.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.ReportingPaymentTransaction;
import com.iyzipay.model.Status;
import com.iyzipay.request.ReportingPaymentTransactionRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReportingPaymentTransactionSample extends Sample {

    @Test
    public void should_create_payment_transaction_report() {
        Integer page = 1;
        ReportingPaymentTransactionRequest request = new ReportingPaymentTransactionRequest();
        request.setTransactionDate("2021-07-26");
        request.setPage(page);
        request.setConversationId("123456789");
        request.setLocale(Locale.TR.getValue());

        ReportingPaymentTransaction reportingPaymentTransaction = ReportingPaymentTransaction.create(request, options);

        System.out.println(reportingPaymentTransaction);

        assertEquals(Status.SUCCESS.getValue(), reportingPaymentTransaction.getStatus());
        assertEquals(Locale.TR.getValue(), reportingPaymentTransaction.getLocale());
        assertEquals("123456789", reportingPaymentTransaction.getConversationId());
        assertNotEquals(0, reportingPaymentTransaction.getSystemTime());
        assertNull(reportingPaymentTransaction.getErrorCode());
        assertNull(reportingPaymentTransaction.getErrorMessage());
        assertNull(reportingPaymentTransaction.getErrorGroup());
    }
}
