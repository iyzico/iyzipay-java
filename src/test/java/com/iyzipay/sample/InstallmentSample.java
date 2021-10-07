package com.iyzipay.sample;

import com.iyzipay.model.InstallmentInfo;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrieveInstallmentInfoRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class InstallmentSample extends Sample {

    @Test
    public void should_retrieve_installments() {
        RetrieveInstallmentInfoRequest request = new RetrieveInstallmentInfoRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setBinNumber("554960");
        request.setPrice(new BigDecimal("100"));

        InstallmentInfo installmentInfo = InstallmentInfo.retrieve(request, options);

        System.out.println(installmentInfo);

        assertEquals(Status.SUCCESS.getValue(), installmentInfo.getStatus());
        assertEquals(Locale.TR.getValue(), installmentInfo.getLocale());
        assertEquals("123456789", installmentInfo.getConversationId());
        assertNotEquals(0, installmentInfo.getSystemTime());
        assertNull(installmentInfo.getErrorCode());
        assertNull(installmentInfo.getErrorMessage());
        assertNull(installmentInfo.getErrorGroup());
        assertNotNull(installmentInfo.getInstallmentDetails());
        assertFalse(installmentInfo.getInstallmentDetails().isEmpty());
    }
}
