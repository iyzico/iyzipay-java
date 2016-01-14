package com.iyzipay;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {

    private static final int RANDOM_STRING_SIZE = 8;

    private RandomStringGenerator() {
    }

    public static String generateRandomString() {
        return System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(RANDOM_STRING_SIZE);
    }
}
