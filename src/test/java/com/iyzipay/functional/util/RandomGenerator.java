package com.iyzipay.functional.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

    private static final int ID_LENGTH = 11;

    public static String randomId() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }
}