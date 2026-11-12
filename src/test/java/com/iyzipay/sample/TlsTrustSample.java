package com.iyzipay.sample;

import com.iyzipay.Options;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

public class TlsTrustSample {

    @Test
    public void should_configure_tls_trust_from_a_trust_store() throws Exception {
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try (InputStream in = new FileInputStream("/path/to/truststore.p12")) {
            trustStore.load(in, "changeit".toCharArray());
        }

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        Options options = new Options();
        options.setApiKey("your api key");
        options.setSecretKey("your secret key");
        options.setBaseUrl("https://sandbox-api.iyzipay.com");
        options.setSslSocketFactory(sslContext.getSocketFactory());
    }
}
