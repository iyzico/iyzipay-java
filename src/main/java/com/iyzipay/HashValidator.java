package com.iyzipay;


import org.apache.commons.lang3.StringUtils;

public class HashValidator {
    private HashValidator() {
    }

    public static boolean hashValid(String calculatedHash, String hash) {
        return StringUtils.equals(calculatedHash, hash);
    }
}
