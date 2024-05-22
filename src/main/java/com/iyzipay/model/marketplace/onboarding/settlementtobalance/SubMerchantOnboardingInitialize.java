package com.iyzipay.model.marketplace.onboarding.settlementtobalance;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.SubMerchantOnboardingInitializeRequest;

public class SubMerchantOnboardingInitialize extends SubmerchantOnboardingInitializeResource {
    public static SubMerchantOnboardingInitialize initialize(SubMerchantOnboardingInitializeRequest request, Options options) {
        String path = "/onboarding/settlement-to-balance/submerchant";
        return HttpClient.create().post(
                options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                SubMerchantOnboardingInitialize.class
        );
    }
}
