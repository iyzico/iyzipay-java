package com.iyzipay.model.marketplace.onboarding.settlementtobalance;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.SubMerchantOnboardingInitializeRequest;

public class SubMerchantOnboardingInitialize extends SubmerchantOnboardingInitializeResource {
    public static SubMerchantOnboardingInitialize initialize(SubMerchantOnboardingInitializeRequest request, Options options) {
        return HttpClient.create().post(
                options.getBaseUrl() + "/onboarding/settlement-to-balance/submerchant",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                SubMerchantOnboardingInitialize.class
        );
    }
}
