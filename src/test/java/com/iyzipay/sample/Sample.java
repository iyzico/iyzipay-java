package com.iyzipay.sample;

import com.iyzipay.Options;
import org.junit.Before;

public abstract class Sample {

    Options options;

    @Before
    public void setUp() {
        options = new Options();
        options.setApiKey("1");
        options.setSecretKey("1");
        options.setBaseUrl("http://localhost:8080");
    }
}
