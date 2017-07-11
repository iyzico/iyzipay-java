package com.iyzipay.functional;

import com.iyzipay.model.InstallmentInfo;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrieveInstallmentInfoRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class InstallmentTest extends BaseTest {

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
        assertNotNull(installmentInfo.getInstallmentDetails().get(0));
        assertEquals("554960", installmentInfo.getInstallmentDetails().get(0).getBinNumber());
        assertEquals(new BigDecimal("100"), installmentInfo.getInstallmentDetails().get(0).getPrice());
        assertEquals("CREDIT_CARD", installmentInfo.getInstallmentDetails().get(0).getCardType());
        assertEquals("MASTER_CARD", installmentInfo.getInstallmentDetails().get(0).getCardAssociation());
        assertEquals("Bonus", installmentInfo.getInstallmentDetails().get(0).getCardFamilyName());
        assertNotNull(installmentInfo.getInstallmentDetails().get(0).getInstallmentPrices().get(0).getInstallmentNumber());
        assertNotNull(installmentInfo.getInstallmentDetails().get(0).getInstallmentPrices().get(0).getInstallmentPrice());
        assertNotNull(installmentInfo.getInstallmentDetails().get(0).getInstallmentPrices().get(0).getTotalPrice());
        assertNotNull(installmentInfo.getSystemTime());
        assertNull(installmentInfo.getErrorCode());
        assertNull(installmentInfo.getErrorMessage());
        assertNull(installmentInfo.getErrorGroup());
        assertNotNull(installmentInfo.getInstallmentDetails());
        assertFalse(installmentInfo.getInstallmentDetails().isEmpty());
    }
}