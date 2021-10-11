package com.iyzipay;

import com.iyzipay.exception.HttpClientException;


import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashGenerator {

    private HashGenerator() {
    }

    public static String generateHash(String apiKey, String secretKey, String randomString, Object request) {
        byte[] result = null;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA1");
            String input = apiKey + randomString + secretKey + request;
            result = crypt.digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new HttpClientException("Hash cannot be generated", e);
        }
        return DatatypeConverter.printBase64Binary(result);
    }
}