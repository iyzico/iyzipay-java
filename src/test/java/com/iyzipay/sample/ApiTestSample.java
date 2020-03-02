package com.iyzipay.sample;

import com.iyzipay.IyzipayResource;
import com.iyzipay.model.ApiTest;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class ApiTestSample extends Sample {

    @Test
    public void should_test_api() {
        IyzipayResource iyzipayResource = ApiTest.retrieve(options);

        System.out.println(iyzipayResource);

        assertEquals(Status.SUCCESS.getValue(), iyzipayResource.getStatus());
        assertEquals(Locale.TR.getValue(), iyzipayResource.getLocale());
        assertNotEquals(0, iyzipayResource.getSystemTime());
        assertNull(iyzipayResource.getErrorCode());
        assertNull(iyzipayResource.getErrorMessage());
        assertNull(iyzipayResource.getErrorGroup());
    }
}
