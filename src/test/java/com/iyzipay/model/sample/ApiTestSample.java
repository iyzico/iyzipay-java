package com.iyzipay.model.sample;

import com.iyzipay.IyzipayResource;
import com.iyzipay.model.ApiTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiTestSample extends Sample {

    @Test
    public void should_test_api(){
        IyzipayResource iyzipayResource = ApiTest.retrieve(options);

        assertNotNull(iyzipayResource.getSystemTime());
        assertEquals("success", iyzipayResource.getStatus());

        System.out.println(iyzipayResource);
    }
}
