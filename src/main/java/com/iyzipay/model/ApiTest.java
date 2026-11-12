package com.iyzipay.model ;

import com.iyzipay.HttpClient ;
import com.iyzipay.IyzipayResource ;
import com.iyzipay.Options ;

public class ApiTest extends IyzipayResource {

    public static IyzipayResource retrieve(Options options) {
        return HttpClient.create(options).get(options.getBaseUrl() + "/payment/test", getHttpProxy(options), IyzipayResource.class) ;
    }
}
