package com.iyzipay.sample;

import com.iyzipay.model.InstallmentInfo;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrieveInstallmentInfoRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class InstallmentSample extends Sample {

    @Test
    public void should_retrieve_installment_info() {
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
        assertNotNull(installmentInfo.getSystemTime());
        assertNull(installmentInfo.getErrorCode());
        assertNull(installmentInfo.getErrorMessage());
        assertNull(installmentInfo.getErrorGroup());
        assertNotNull(installmentInfo.getInstallmentDetails());
        assertFalse(installmentInfo.getInstallmentDetails().isEmpty());
    }
}
