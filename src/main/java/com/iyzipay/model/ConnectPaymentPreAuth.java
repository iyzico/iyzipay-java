package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectPaymentAuthRequest;
import com.iyzipay.request.CreateConnectPaymentPreAuthRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ConnectPaymentPreAuth extends ConnectPayment {

    public static ConnectPaymentPreAuth create(CreateConnectPaymentPreAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/preauth",
                getHttpHeaders(request, options),
                request,
                ConnectPaymentPreAuth.class)
                .getBody();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
