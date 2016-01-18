package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateRefundRequest;

public class RefundChargedFromMerchant extends Refund {

    public static RefundChargedFromMerchant create(CreateRefundRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/refund/merchant/charge",
                getHttpHeaders(request, options),
                request,
                RefundChargedFromMerchant.class)
                .getBody();
    }
}
