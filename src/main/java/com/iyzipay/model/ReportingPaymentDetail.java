package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.Request;
import com.iyzipay.request.ReportingPaymentDetailRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class ReportingPaymentDetail extends IyzipayResource {

    private List<PaymentDetail> payments;

    public static ReportingPaymentDetail create(ReportingPaymentDetailRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/reporting/payment/details" + getQueryParams(request);
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                ReportingPaymentDetail.class);
    }

    private static String getQueryParams(Request request) {
        if (request == null) {
            return "";
        }

        String queryParams = "?conversationId=" + request.getConversationId();

        if (StringUtils.isNotBlank(request.getLocale())) {
            queryParams += "&locale=" + request.getLocale();
        }

        if (request instanceof ReportingPaymentDetailRequest) {
            ReportingPaymentDetailRequest reportingPaymentDetailRequest = (ReportingPaymentDetailRequest) request;
            if (StringUtils.isNoneEmpty(reportingPaymentDetailRequest.getPaymentId())) {
                queryParams += "&paymentId=" + reportingPaymentDetailRequest.getPaymentId();
            }

            if (StringUtils.isNoneEmpty(reportingPaymentDetailRequest.getPaymentConversationId())) {
                queryParams += "&paymentConversationId=" + reportingPaymentDetailRequest.getPaymentConversationId();
            }
        }
        return queryParams;
    }

    public List<PaymentDetail> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDetail> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}

