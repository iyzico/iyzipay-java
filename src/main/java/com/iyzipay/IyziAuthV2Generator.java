package com.iyzipay;

import com.google.gson.Gson;
import com.iyzipay.exception.HttpClientException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public final class IyziAuthV2Generator {

    private IyziAuthV2Generator() {
    }

    public static String generateAuthContent(String path, String apiKey, String secretKey, String randomString, Object request) {
        try {
            String input = "apiKey:" + apiKey + "&randomKey:" + randomString + "&signature:" + getHmacSHA256Signature(path, secretKey, randomString, request);
            return DatatypeConverter.printBase64Binary(input.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new HttpClientException("Authentication content couldn't be generated", e);
        }
    }

    private static String getHmacSHA256Signature(String path, String secretKey, String randomString, Object request) {
        try {
            String dataToSign = randomString + getPayload(path, request);
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256"));
            return DatatypeConverter.printHexBinary(mac.doFinal(dataToSign.getBytes("UTF-8"))).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw new HttpClientException("HMAC couldn't be generated", e);
        } catch (UnsupportedEncodingException e) {
            throw new HttpClientException("Authentication content couldn't be generated", e);
        } catch (InvalidKeyException e) {
            throw new HttpClientException("Authentication content couldn't be generated", e);
        }
    }

    private static String getPayload(String path, Object request) {
        return request == null ? path : path + new Gson().toJson(request);
    }
}
