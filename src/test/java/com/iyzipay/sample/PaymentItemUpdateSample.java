package com.iyzipay.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.PaymentItem;
import com.iyzipay.model.Status;
import com.iyzipay.request.UpdatePaymentItemRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PaymentItemUpdateSample extends Sample {

    @Test
    public void should_update_payment_item() {
        UpdatePaymentItemRequest request = new UpdatePaymentItemRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId(9999999L);
        request.setSubMerchantPrice(new BigDecimal("sub-merchant-price"));
        request.setSubMerchantKey("sub-merchant-key");

        PaymentItem paymentItem = PaymentItem.update(request, options);

        System.out.println(paymentItem);

        assertEquals(Status.SUCCESS.getValue(), paymentItem.getStatus());
        assertEquals(Locale.TR.getValue(), paymentItem.getLocale());
        assertEquals("123456789", paymentItem.getConversationId());
        assertNull(paymentItem.getErrorCode());
        assertNull(paymentItem.getErrorMessage());
        assertNull(paymentItem.getErrorGroup());
    }
}