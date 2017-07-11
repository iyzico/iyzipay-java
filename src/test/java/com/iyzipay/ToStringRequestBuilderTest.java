package com.iyzipay;

import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.Locale;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ToStringRequestBuilderTest {

    @Test
    public void should_append_and_convert_object_to_string() {
        String toString = new ToStringRequestBuilder(new Object())
                .append("conversationId", "123456")
                .append("locale", Locale.TR.getValue())
                .append("price", new BigDecimal("1.0"))
                .toString();

        assertEquals("[conversationId=123456,locale=tr,price=1.0]", toString);
    }

    @Test
    public void should_convert_to_nothing() {
        String toString = new ToStringRequestBuilder(new Object()).toString();
        assertEquals("[]", toString);
    }
}
