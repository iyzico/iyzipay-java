package com.iyzipay;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.DatatypeConverter;


public final class DigestHelper {

    private DigestHelper() {
    }

    public static String decodeString(String content) {
        return (StringUtils.isNotBlank(content)) ? new String(DatatypeConverter.parseBase64Binary(content)) : null;
    }
}
