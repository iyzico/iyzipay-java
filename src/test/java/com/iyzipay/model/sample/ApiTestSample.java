package com.iyzipay.model.sample;

import com.iyzipay.IyzipayResource;
import com.iyzipay.model.ApiTest;
import com.iyzipay.model.Status;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiTestSample extends Sample {

    @Test
    public void should_test_api() {
        IyzipayResource iyzipayResource = ApiTest.retrieve(options);

        System.out.println(iyzipayResource);

        assertNotNull(iyzipayResource.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), iyzipayResource.getStatus());
    }
}
