package com.iyzipay;

import com.google.gson.Gson;
import com.iyzipay.exception.HttpClientException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.client.config.RequestConfig;

abstract class AbstractHttpClient implements HttpClient {

    public static final String DEFAULT_CHARSET = "UTF-8";
    private final RequestConfig config;

    public AbstractHttpClient() {
        this.config = null;
    }

    public AbstractHttpClient(int timeout) {
        config = RequestConfig.custom().
                setSocketTimeout(timeout).
                setConnectTimeout(timeout).
                setConnectionRequestTimeout(timeout).
                build();
    }

    public AbstractHttpClient(RequestConfig config) {
        this.config = config;
    }

    public abstract CloseableHttpClient getHttpClient();

    @Override
    public <T> T get(String url, Class<T> responseType) {

        CloseableHttpClient httpClient = getHttpClient();

        HttpGet httpGet = new HttpGet(url);
        if (config != null) {
            httpGet.setConfig(config);
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            T result = new Gson().fromJson(EntityUtils.toString(httpEntity, DEFAULT_CHARSET), responseType);
            EntityUtils.consume(httpEntity);
            return result;
        } catch (IOException e) {
            throw new HttpClientException(e.getMessage(), e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                //ignore
            }
        }
    }

    @Override
    public <T> T post(String url, List<Header> headers, Object request, Class<T> responseType) {
        HttpPost httpPost = new HttpPost(url);
        for (Header header : headers) {
            httpPost.addHeader(header);
        }
        return this.exchange(httpPost, request, responseType);
    }

    @Override
    public <T> T put(String url, List<Header> headers, Object request, Class<T> responseType) {
        HttpPut httpPut = new HttpPut(url);
        for (Header header : headers) {
            httpPut.addHeader(header);
        }
        return this.exchange(httpPut, request, responseType);
    }

    @Override
    public <T> T delete(String url, List<Header> headers, Object request, Class<T> responseType) {
        HttpDelete httpDelete = new HttpDelete(url);
        for (Header header : headers) {
            httpDelete.addHeader(header);
        }
        return this.exchange(httpDelete, request, responseType);
    }

    private <T> T exchange(HttpEntityEnclosingRequestBase httpMethod, Object request, Class<T> responseType) {
        CloseableHttpClient httpClient = getHttpClient();
        Gson gson = new Gson();
        CloseableHttpResponse response = null;
        String body = gson.toJson(request);
        try {
            StringEntity requestEntity = new StringEntity(body, ContentType.APPLICATION_JSON);
            requestEntity.setContentEncoding(DEFAULT_CHARSET);
            httpMethod.setEntity(requestEntity);
            if (config != null) {
                httpMethod.setConfig(config);
            }
            response = httpClient.execute(httpMethod);
            HttpEntity responseEntity = response.getEntity();
            T result = gson.fromJson(EntityUtils.toString(responseEntity, DEFAULT_CHARSET), responseType);
            EntityUtils.consume(responseEntity);
            return result;
        } catch (UnsupportedEncodingException e) {
            throw new HttpClientException(e.getMessage(), e);
        } catch (ClientProtocolException e) {
            throw new HttpClientException(e.getMessage(), e);
        } catch (IOException e) {
            throw new HttpClientException(e.getMessage(), e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                //ignore
            }
        }
    }
}
