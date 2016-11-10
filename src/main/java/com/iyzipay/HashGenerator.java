package com.iyzipay;

import com.iyzipay.exception.HttpClientException;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashGenerator {

    private HashGenerator() {
    }

    public static String generateHash(String apiKey, String secretKey, String randomString, Object request) {
        StringBuilder hash = new StringBuilder();
        byte[] result = null;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA1");
            String input = apiKey + randomString + secretKey + request;
            result = crypt.digest(input.getBytes());
            for (int i = 0; i < result.length; i++) {
                hash.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new HttpClientException("Hash cannot be generated", e);
        }
        return DatatypeConverter.printBase64Binary(result);
    }
}
