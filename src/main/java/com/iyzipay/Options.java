package com.iyzipay ;

import javax.net.ssl.SSLSocketFactory ;

public class Options {

    private String apiKey;
    private String secretKey;
    private String baseUrl;
    private String proxyHost;
    private int proxyPort;
    private SSLSocketFactory sslSocketFactory;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * The http client will use a proxy when not blank (null or empty).
     *
     * @param proxyHost the hostname of the proxy.
     */
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    /**
     * The http client will use this port to connect to the proxy.
     *
     * @param proxyPort the hostname of the proxy.
     */
    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return sslSocketFactory;
    }

    /**
     * The http client will use this socket factory for its TLS connections when not null.
     * The factory is used as configured, for example
     * {@code options.setSslSocketFactory(sslContext.getSocketFactory())}.
     * When not set, the JDK default SSL socket factory is used with TLSv1.2 enabled.
     *
     * @param sslSocketFactory the socket factory to use, or null to use the JDK default.
     */
    public void setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
