package com.iyzipay.model.marketplace.onboarding.settlementtobalance;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.SubMerchantOnboardingVerifyRequest;

public class SubMerchantOnboardingVerify extends SubMerchantOnboardingVerifyResource {
    public static SubMerchantOnboardingVerify verify(SubMerchantOnboardingVerifyRequest request, Options options) {
        String path = "/onboarding/settlement-to-balance/submerchant/verify";
        return HttpClient.create().post(
                options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                SubMerchantOnboardingVerify.class
        );
    }
}
