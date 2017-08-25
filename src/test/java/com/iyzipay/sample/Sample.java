package com.iyzipay.sample;

import com.iyzipay.Options;
import org.junit.Before;

public abstract class Sample {

    Options options;

    @Before
    public void setUp() {
        options = new Options();
        options.setApiKey("mrI3mIMuNwGiIxanQslyJBRYa8nYrCU5");
        options.setSecretKey("9lkVluNHBABPw0LIvyn50oYZcrSJ8oNo");
        options.setBaseUrl("http://localhost:8080");
    }
}
