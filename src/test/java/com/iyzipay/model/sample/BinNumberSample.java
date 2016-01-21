package com.iyzipay.model.sample;

import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.request.RetrieveBinNumberRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BinNumberSample extends Sample {

    @Test
    public void should_retrieve_bin_number(){
        RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
        request.setBinNumber("454671");
        request.setConversationId("123456");
        request.setLocale(Locale.TR.getValue());

        BinNumber binNumber = BinNumber.retrieve(request, options);

        System.out.println(binNumber);

        assertNotNull(binNumber.getSystemTime());
        assertEquals("success", binNumber.getStatus());
        assertEquals(Locale.TR.getValue(), binNumber.getLocale());
        assertEquals("123456", binNumber.getConversationId());

        assertEquals("454671", binNumber.getBinNumber());
        assertEquals("CREDIT_CARD", binNumber.getCardType());
        assertEquals("VISA", binNumber.getCardAssociation());
        assertEquals("Ziraat Bankası CC", binNumber.getCardFamily());
        assertEquals("Ziraat Bankası", binNumber.getBankName());
        assertEquals(new Long(10), binNumber.getBankCode());
    }
}
