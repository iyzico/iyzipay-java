package com.iyzipay;

import com.iyzipay.RequestFormatter;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class RequestFormatterTest {

    @Test
    public void should_format_price_given_string_value() {
        Assert.assertEquals("0.0", RequestFormatter.formatPrice(new BigDecimal("0")));
        assertEquals("0.0", RequestFormatter.formatPrice(new BigDecimal("00000")));
        assertEquals("0.0", RequestFormatter.formatPrice(new BigDecimal("0.0")));
        assertEquals("0.0", RequestFormatter.formatPrice(new BigDecimal("00000.0000")));
        assertEquals("1.0", RequestFormatter.formatPrice(new BigDecimal("1")));
        assertEquals("1.0", RequestFormatter.formatPrice(new BigDecimal("1.0")));
        assertEquals("1.0", RequestFormatter.formatPrice(new BigDecimal("1.000")));
        assertEquals("1.0", RequestFormatter.formatPrice(new BigDecimal("00001.000")));
        assertEquals("-1.0", RequestFormatter.formatPrice(new BigDecimal("-1")));
        assertEquals("-1.0", RequestFormatter.formatPrice(new BigDecimal("-1.0")));
        assertEquals("-1.0", RequestFormatter.formatPrice(new BigDecimal("-1.000")));
        assertEquals("0.3", RequestFormatter.formatPrice(new BigDecimal("0.3")));
        assertEquals("-0.3", RequestFormatter.formatPrice(new BigDecimal("-0.3")));
        assertEquals("1100000.3", RequestFormatter.formatPrice(new BigDecimal("00001100000.3000000")));
        assertEquals("-1.0", RequestFormatter.formatPrice(new BigDecimal("-00001.000")));
        assertEquals("10000.0", RequestFormatter.formatPrice(new BigDecimal("10000")));
        assertEquals("-10000.0", RequestFormatter.formatPrice(new BigDecimal("-10000")));
        assertEquals("33001.00044", RequestFormatter.formatPrice(new BigDecimal("0033001.0004400")));
        assertEquals("-33001.00044", RequestFormatter.formatPrice(new BigDecimal("-0033001.0004400")));
        assertEquals("99999999999999999999999999.99999999999999999999999", RequestFormatter.formatPrice(new BigDecimal("99999999999999999999999999.99999999999999999999999")));
        assertEquals("-99999999999999999999999999.99999999999999999999999", RequestFormatter.formatPrice(new BigDecimal("-99999999999999999999999999.99999999999999999999999")));
        assertEquals("99999999999999999999999999.99999999999999999999999", RequestFormatter.formatPrice(new BigDecimal("0099999999999999999999999999.9999999999999999999999900")));
        assertEquals("-99999999999999999999999999.99999999999999999999999", RequestFormatter.formatPrice(new BigDecimal("-0099999999999999999999999999.9999999999999999999999900")));
    }
}
