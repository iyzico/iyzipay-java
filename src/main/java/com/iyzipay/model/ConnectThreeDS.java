package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectThreeDSRequest;

public class ConnectThreeDS extends ThreeDS {

    public static ConnectThreeDS create(CreateConnectThreeDSRequest request, Options options) {
        ConnectThreeDS response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/initialize3ds",
                getHttpHeaders(request, options),
                request,
                ConnectThreeDS.class)
                .getBody();
        if (response != null) {
            response.setHtmlContent(DigestHelper.decodeString(response.getHtmlContent()));
        }
        return response;
    }
}
