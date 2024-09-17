package com.iyzipay.model;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.RetrieveCheckoutFormRequest;

import java.util.Arrays;

public class CheckoutForm extends PaymentResource implements ResponseSignatureGenerator {

    private String token;
    private String callbackUrl;

    public boolean verifySignature(String secretKey) {
        String calculated = generateSignature(secretKey,
                Arrays.asList(getPaymentStatus(), getPaymentId(),
                        getCurrency(), getBasketId(), getConversationId(),
                        getPaidPrice(), getPrice(), getToken()));
        return HashValidator.hashValid(getSignature(), calculated);
    }

    public static CheckoutForm retrieve(RetrieveCheckoutFormRequest request, Options options) {
        String path = "/payment/iyzipos/checkoutform/auth/ecom/detail";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                CheckoutForm.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
