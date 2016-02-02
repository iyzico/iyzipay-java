package com.iyzipay.model.sample;

import com.iyzipay.model.ForeignExchangeRate;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.ConvertForeignExchangeRateRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ForeignExchangeRateSample extends Sample {

    @Test
    public void should_retrieve_bin_number() {
        ConvertForeignExchangeRateRequest request = new ConvertForeignExchangeRateRequest();
        request.setConversationId("123456789");
        request.setAmount(new BigDecimal(3));
        request.setSourceCurrencyCode("TRY");
        request.setDestinationCurrencyCode("IRR");
        request.setLocale(Locale.TR.getValue());

        ForeignExchangeRate foreignExchangeRate = ForeignExchangeRate.convert(request, options);

        System.out.println(foreignExchangeRate);

        assertNotNull(foreignExchangeRate.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), foreignExchangeRate.getStatus());
        assertEquals(Locale.TR.getValue(), foreignExchangeRate.getLocale());
        assertEquals("123456789", foreignExchangeRate.getConversationId());
    }
}
