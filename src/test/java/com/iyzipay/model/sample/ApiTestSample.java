package com.iyzipay.model.sample;

import com.iyzipay.IyzipayResource;
import com.iyzipay.model.ApiTest;
import org.junit.Test;

public class ApiTestSample extends Sample {

    @Test
    public void should_test_api(){
        IyzipayResource iyzipayResource = ApiTest.retrieve(options);
        System.out.println(iyzipayResource.getStatus());
        System.out.println(iyzipayResource.getSystemTime());
    }
}
