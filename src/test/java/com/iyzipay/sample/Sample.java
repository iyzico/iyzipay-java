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
        options.setApiKey("sandbox-SfCcI5omjZjxDxcX0FKNt9sOwwZ2rilc");
        options.setSecretKey("sandbox-lf2Wb2WVZvdBf2TW0252qBdpVHzaF8Xc");
        options.setBaseUrl("https://sandbox-api.iyzipay.com");
    }
}
