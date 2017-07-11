package com.iyzipay.functional;

import com.iyzipay.Options;
import org.junit.Before;

public abstract class BaseTest {

    Options options;

    @Before
    public void setUp() {
        options = new Options();
        options.setApiKey("sandbox-afXhZPW0MQlE4dCUUlHcEopnMBgXnAZI");
        options.setSecretKey("sandbox-wbwpzKIiplZxI3hh5ALI4FJyAcZKL6kq");
        options.setBaseUrl("https://sandbox-api.iyzipay.com");
    }
}