package com.iyzipay.model.sample;

import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrieveBinNumberRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BinNumberSample extends Sample {

    @Test
    public void should_retrieve_bin_number() {
        RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setBinNumber("454671");

        BinNumber binNumber = BinNumber.retrieve(request, options);

        System.out.println(binNumber);

        assertNotNull(binNumber.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), binNumber.getStatus());
        assertEquals(Locale.TR.getValue(), binNumber.getLocale());
        assertEquals("123456789", binNumber.getConversationId());
        assertEquals("454671", binNumber.getBinNumber());
        assertEquals("CREDIT_CARD", binNumber.getCardType());
        assertEquals("VISA", binNumber.getCardAssociation());
        assertEquals("Ziraat Bankası CC", binNumber.getCardFamily());
        assertEquals("Ziraat Bankası", binNumber.getBankName());
        assertEquals(new Long(10), binNumber.getBankCode());
    }
}
