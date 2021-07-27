package com.iyzipay.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.ReportingPaymentDetail;
import com.iyzipay.model.Status;
import com.iyzipay.request.ReportingPaymentDetailRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReportingPaymentDetailSample extends Sample {

    @Test
    public void should_create_payment_detail_report_with_payment_conversation_id() {
        ReportingPaymentDetailRequest request = new ReportingPaymentDetailRequest();
        request.setPaymentConversationId("123456789");
        request.setConversationId("123456789");
        request.setLocale(Locale.TR.getValue());

        ReportingPaymentDetail reportingPaymentDetail = ReportingPaymentDetail.create(request, options);

        System.out.println(reportingPaymentDetail);

        assertEquals(Status.SUCCESS.getValue(), reportingPaymentDetail.getStatus());
        assertEquals(Locale.TR.getValue(), reportingPaymentDetail.getLocale());
        assertEquals("123456789", reportingPaymentDetail.getConversationId());
        assertNotEquals(0, reportingPaymentDetail.getSystemTime());
        assertNull(reportingPaymentDetail.getErrorCode());
        assertNull(reportingPaymentDetail.getErrorMessage());
        assertNull(reportingPaymentDetail.getErrorGroup());
    }

    @Test
    public void should_create_payment_detail_report_with_payment_id() {
        ReportingPaymentDetailRequest request = new ReportingPaymentDetailRequest();
        request.setPaymentId("13403912");
        request.setConversationId("123456789");
        request.setLocale(Locale.TR.getValue());

        ReportingPaymentDetail reportingPaymentDetail = ReportingPaymentDetail.create(request, options);

        System.out.println(reportingPaymentDetail);

        assertEquals(Status.SUCCESS.getValue(), reportingPaymentDetail.getStatus());
        assertEquals(Locale.TR.getValue(), reportingPaymentDetail.getLocale());
        assertEquals("123456789", reportingPaymentDetail.getConversationId());
        assertNotEquals(0, reportingPaymentDetail.getSystemTime());
        assertNull(reportingPaymentDetail.getErrorCode());
        assertNull(reportingPaymentDetail.getErrorMessage());
        assertNull(reportingPaymentDetail.getErrorGroup());
    }
}
