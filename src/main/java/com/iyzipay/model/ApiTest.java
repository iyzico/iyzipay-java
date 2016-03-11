package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;

public class ApiTest extends IyzipayResource {

    public static IyzipayResource retrieve(Options options) {
        return options.getHttpClient().get(options.getBaseUrl() + "/payment/test", IyzipayResource.class);
    }
}
