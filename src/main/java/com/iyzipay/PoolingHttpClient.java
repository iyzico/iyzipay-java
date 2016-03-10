/*
 * The MIT License
 *
 * Copyright 2016 iyzico.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iyzipay;

import org.apache.http.Consts;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 *
 * @author bamasyali
 */
public class PoolingHttpClient extends AbstractHttpClient implements HttpClient {

    private final CloseableHttpClient httpClient;

    public PoolingHttpClient(int poolSize) {
        this.httpClient = createHttpClient(poolSize);
    }

    public PoolingHttpClient(int poolSize, int timeout) {
        super(timeout);
        this.httpClient = createHttpClient(poolSize);
    }

    private CloseableHttpClient createHttpClient(int poolSize) {
        PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
        poolingConnManager.setMaxTotal(poolSize);
        poolingConnManager.setDefaultMaxPerRoute(poolSize);

        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setCharset(Consts.UTF_8)
                .build();

        poolingConnManager.setDefaultConnectionConfig(connectionConfig);

        CloseableHttpClient client = HttpClients.custom().
                setConnectionManager(poolingConnManager).
                disableRedirectHandling().
                build();

        return client;

    }

    @Override
    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }
}
