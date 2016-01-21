package com.iyzipay.model.sample;

import com.iyzipay.model.CrossBookingFromSubMerchant;
import com.iyzipay.model.CrossBookingToSubMerchant;
import com.iyzipay.model.Locale;
import com.iyzipay.request.CreateCrossBookingRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CrossBookingSample extends Sample {

    @Test
    public void should_send_money_to_sub_merchant(){
        CreateCrossBookingRequest request = new CreateCrossBookingRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantKey("sub merchant key");
        request.setPrice(new BigDecimal("1"));
        request.setReason("reason text");

        CrossBookingToSubMerchant crossBookingToSubMerchant = CrossBookingToSubMerchant.create(request, options);

        System.out.println(crossBookingToSubMerchant);

        assertNotNull(crossBookingToSubMerchant.getConversationId());
        assertNotNull(crossBookingToSubMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), crossBookingToSubMerchant.getLocale());
    }

    @Test
    public void should_receive_money_from_sub_merchant(){
        CreateCrossBookingRequest request = new CreateCrossBookingRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantKey("sub merchant key");
        request.setPrice(new BigDecimal("1"));
        request.setReason("reason text");

        CrossBookingFromSubMerchant crossBookingFromSubMerchant = CrossBookingFromSubMerchant.create(request, options);

        System.out.println(crossBookingFromSubMerchant);

        assertNotNull(crossBookingFromSubMerchant.getConversationId());
        assertNotNull(crossBookingFromSubMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), crossBookingFromSubMerchant.getLocale());
    }
}
