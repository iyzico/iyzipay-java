package com.iyzipay.sample;

import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrieveBinNumberRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class BinNumberSample extends Sample {

    @Test
    public void should_retrieve_bin() {
        RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setBinNumber("554960");

        BinNumber binNumber = BinNumber.retrieve(request, options);

        System.out.println(binNumber);

        assertEquals(Status.SUCCESS.getValue(), binNumber.getStatus());
        assertEquals(Locale.TR.getValue(), binNumber.getLocale());
        assertEquals("123456789", binNumber.getConversationId());
        assertNotEquals(0, binNumber.getSystemTime());
        assertNull(binNumber.getErrorCode());
        assertNull(binNumber.getErrorMessage());
        assertNull(binNumber.getErrorGroup());
        assertEquals("554960", binNumber.getBinNumber());
        assertEquals("CREDIT_CARD", binNumber.getCardType());
        assertEquals("MASTER_CARD", binNumber.getCardAssociation());
        assertEquals("Bonus", binNumber.getCardFamily());
        assertEquals("Garanti Bankası", binNumber.getBankName());
        assertEquals(new Long(62), binNumber.getBankCode());
    }
}
