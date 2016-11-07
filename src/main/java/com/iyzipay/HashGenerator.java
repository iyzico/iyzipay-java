package com.iyzipay;

import com.iyzipay.exception.HttpClientException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public final class HashGenerator {

    private HashGenerator() {
    }

    public static String generateHash(String apiKey, String secretKey, String randomString, Object request) throws HttpClientException, NoSuchAlgorithmException {
        String input = apiKey + randomString + secretKey + request;
        StringBuilder sb = new StringBuilder();
        MessageDigest crypt = MessageDigest.getInstance("SHA1");
        byte[] result = crypt.digest(input.getBytes());
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return DatatypeConverter.printBase64Binary(result);
    }

}
