package com.iyzipay.functional;

import com.iyzipay.IyzipayResource;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class ApiTest extends BaseTest {

    @Test
    public void should_test_api() {
        IyzipayResource iyzipayResource = com.iyzipay.model.ApiTest.retrieve(options);

        System.out.println(iyzipayResource);

        assertEquals(Status.SUCCESS.getValue(), iyzipayResource.getStatus());
        assertEquals(Locale.TR.getValue(), iyzipayResource.getLocale());
        assertNotEquals(0, iyzipayResource.getSystemTime());
        assertNull(iyzipayResource.getErrorCode());
        assertNull(iyzipayResource.getErrorMessage());
        assertNull(iyzipayResource.getErrorGroup());
    }
}
