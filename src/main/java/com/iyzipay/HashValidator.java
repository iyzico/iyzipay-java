package com.iyzipay;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;

public class HashValidator {
    private HashValidator() {
    }

    public static boolean hashValid(String calculatedHash, String hash) {
        return Strings.CS.equals(calculatedHash, hash);
    }
}
