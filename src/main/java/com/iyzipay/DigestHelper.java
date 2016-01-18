package com.iyzipay;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public final class DigestHelper {

    public static String decodeString(String content) {
        return (StringUtils.isNotBlank(content)) ? new String(Base64.decodeBase64(content)) : null;
    }
}
