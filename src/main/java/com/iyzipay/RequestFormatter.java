package com.iyzipay;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class RequestFormatter {

    private static final String ZERO = "0";
    private static final String DOT = ".";

    public static String formatPrice(BigDecimal price) {
        String formattedPrice = price.toString();
        if (!StringUtils.contains(formattedPrice, DOT)) {
            return formattedPrice + ".0";
        }
        formattedPrice = StringUtils.stripEnd(formattedPrice, ZERO);
        if (StringUtils.endsWith(formattedPrice, DOT)) {
            return formattedPrice + ZERO;
        }
        return formattedPrice;
    }
}
