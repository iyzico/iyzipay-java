package com.iyzipay;

import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class OptionsTest {

    @Test
    public void should_default_ssl_socket_factory_to_null() {
        assertNull(new Options().getSslSocketFactory());
    }

    @Test
    public void should_set_and_get_ssl_socket_factory() {
        Options options = new Options();
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        options.setSslSocketFactory(sslSocketFactory);

        assertSame(sslSocketFactory, options.getSslSocketFactory());
    }

    @Test
    public void should_accept_factory_derived_from_ssl_context() throws Exception {
        Options options = new Options();

        options.setSslSocketFactory(SSLContext.getDefault().getSocketFactory());

        assertNotNull(options.getSslSocketFactory());
    }
}
