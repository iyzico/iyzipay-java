package com.iyzipay.functional;

import com.iyzipay.Options;
import org.junit.Before;

public abstract class StandardBaseTest {

    Options options;

    @Before
    public void setUp() {
        options = new Options();
        options.setApiKey("sandbox-qBDJ5ttcxbXNNzLZ02WmkiKtHH3ADONj");
        options.setSecretKey("sandbox-HfB5nGM5CRAGdtAijxZ8xHlqYkvN1B0p");
        options.setBaseUrl("https://sandbox-api.iyzipay.com");
    }
}