package com.iyzipay.model.sample;

import com.iyzipay.model.InstallmentInfo;
import com.iyzipay.model.Locale;
import com.iyzipay.request.RetrieveInstallmentInfoRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InstallmentSample extends Sample {

    @Test
    public void should_retrieve_installment_info() {
        RetrieveInstallmentInfoRequest request = new RetrieveInstallmentInfoRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setBinNumber("554960");
        request.setPrice(new BigDecimal("1"));

        InstallmentInfo installmentInfo = InstallmentInfo.retrieve(request, options);

        System.out.println(installmentInfo);

        assertNotNull(installmentInfo.getConversationId());
        assertNotNull(installmentInfo.getLocale());
        assertEquals(Locale.TR.getValue(), installmentInfo.getLocale());
    }
}
