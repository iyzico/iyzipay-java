package com.iyzipay.sample;

import com.iyzipay.Options;
import org.junit.Before;

public abstract class Sample {

    public Options options;

    @Before
    public void setUp() {
        options = new Options();
//        options.setApiKey(System.getProperty("apiKey"));
//        options.setSecretKey(System.getProperty("secretKey"));
//        options.setBaseUrl(System.getProperty("baseUrl"));
        options.setApiKey("mrI3mIMuNwGiIxanQslyJBRYa8nYrCU5");
        options.setSecretKey("9lkVluNHBABPw0LIvyn50oYZcrSJ8oNo");
        options.setBaseUrl("https://sandbox-api.iyzipay.com");
    }
}
