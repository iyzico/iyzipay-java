package com.iyzipay.model.sample;

import com.iyzipay.Options;
import org.junit.Before;

public abstract class Sample {

    Options options;

    @Before
    public void setUp() {
        options = new Options();
        options.setApiKey(System.getProperty("apiKey"));
        options.setSecretKey(System.getProperty("secretKey"));
        options.setBaseUrl(System.getProperty("baseUrl"));
    }

}
