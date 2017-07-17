package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.RetrieveBinNumberRequestBuilder;
import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrieveBinNumberRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinNumberTest extends BaseTest {

    @Test
    public void should_retrieve_bin() {
        RetrieveBinNumberRequest request = RetrieveBinNumberRequestBuilder.create()
                .binNumber("554960")
                .build();

        BinNumber binNumber = BinNumber.retrieve(request, options);

        System.out.println(binNumber);

        assertEquals(Status.SUCCESS.getValue(), binNumber.getStatus());
        assertEquals(Locale.TR.getValue(), binNumber.getLocale());
        assertEquals("123456789", binNumber.getConversationId());
        assertNotNull(binNumber.getSystemTime());
        assertNull(binNumber.getErrorCode());
        assertNull(binNumber.getErrorMessage());
        assertNull(binNumber.getErrorGroup());
        assertEquals("554960", binNumber.getBinNumber());
        assertEquals("CREDIT_CARD", binNumber.getCardType());
        assertEquals("MASTER_CARD", binNumber.getCardAssociation());
        assertEquals("Bonus", binNumber.getCardFamily());
        assertEquals("Garanti Bankası", binNumber.getBankName());
        assertEquals(new Long(62), binNumber.getBankCode());
        assertEquals(new Integer(0), binNumber.getCommercial());
    }
}