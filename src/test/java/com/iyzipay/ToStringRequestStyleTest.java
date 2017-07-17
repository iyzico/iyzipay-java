package com.iyzipay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToStringRequestStyleTest {

    @Test
    public void should_append_when_value_is_not_null() {
        StringBuffer sb = new StringBuffer();
        new ToStringRequestStyle().append(sb, "conversationId", "123456", true);
        assertEquals("conversationId=123456,", sb.toString());
    }

    @Test
    public void should_append_nothing_when_value_is_not_null() {
        Object value = null;
        StringBuffer sb = new StringBuffer();
        new ToStringRequestStyle().append(sb, "conversationId", value, true);
        assertEquals("", sb.toString());
    }

    @Test
    public void should_append_when_value_is_empty() {
        StringBuffer sb = new StringBuffer();
        new ToStringRequestStyle().append(sb, "conversationId", "", true);
        assertEquals("conversationId=,", sb.toString());
    }
}
