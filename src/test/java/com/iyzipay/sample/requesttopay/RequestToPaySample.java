package com.iyzipay.sample.requesttopay;

import com.iyzipay.Options;
import com.iyzipay.sample.Sample;
import org.junit.Before;

public class RequestToPaySample extends Sample {

    public Options receiverOptions;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        receiverOptions = new Options();
        receiverOptions.setApiKey(System.getProperty("receiverApiKey"));
        receiverOptions.setSecretKey(System.getProperty("receiverSecretKey"));
        receiverOptions.setBaseUrl(System.getProperty("baseUrl"));
    }

}