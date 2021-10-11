package com.iyzipay;

import jakarta.xml.bind.DatatypeConverter;
import org.apache.commons.lang3.StringUtils;


public final class DigestHelper {

    private DigestHelper() {
    }

    public static String decodeString(String content) {
        return (StringUtils.isNotBlank(content)) ? new String(DatatypeConverter.parseBase64Binary(content)) : null;
    }
}
