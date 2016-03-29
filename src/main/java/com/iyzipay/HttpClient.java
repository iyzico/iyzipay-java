package com.iyzipay;

import com.google.gson.Gson;
import com.iyzipay.exception.HttpClientException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static com.iyzipay.HttpMethod.*;

public class HttpClient {

    public static final String DEFAULT_CHARSET = "UTF-8";
    private static final int TIMEOUT = 30000;

    private HttpClient() {
    }

    public static HttpClient create() {
        return new HttpClient();
    }

    public <T> T get(String url, Class<T> responseType) {
        return exchange(url, GET, new HashMap<String, String>(), null, responseType);

    }

    public <T> T post(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, POST, headers, request, responseType);
    }


    public <T> T put(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, PUT, headers, request, responseType);
    }

    public <T> T delete(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, DELETE, headers, request, responseType);
    }


    private <T> T exchange(String url, HttpMethod httpMethod, Map<String, String> headers, Object request, Class<T> responseType) {
        Gson gson = new Gson();
        String body = gson.toJson(request);

        try {
            String response = send(url, httpMethod, new ByteArrayInputStream(body.getBytes(DEFAULT_CHARSET)), headers);
            return gson.fromJson(response, responseType);
        } catch (UnsupportedEncodingException e) {
            throw new HttpClientException(e.getMessage(), e);
        }
    }

    /**
     * Return HttpResponse Body of String
     *
     * @param url
     * @param httpMethod
     * @param content
     * @param headers
     * @return String
     */
    private String send(String url, HttpMethod httpMethod, InputStream content, Map<String, String> headers) {
        URLConnection raw;
        HttpURLConnection conn = null;
        try {
            raw = new URL(url).openConnection();
            conn = HttpURLConnection.class.cast(raw);

            conn.setRequestMethod(httpMethod.name());

            conn.setConnectTimeout(TIMEOUT);
            conn.setReadTimeout(TIMEOUT);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);

            prepareHeaders(headers, conn);
            prepareRequestBody(httpMethod, content, conn);

            return new String(body(conn), Charset.forName("UTF-8"));
        } catch (Exception e) {
            throw new HttpClientException(e.getMessage(), e);
        } finally {
            conn.disconnect();
        }
    }


    /**
     * Add Header Parameters In HttpURLConnection
     *
     * @param headers
     * @param conn
     */
    private void prepareHeaders(Map<String, String> headers, HttpURLConnection conn) {

        for (Map.Entry<String, String> header : headers.entrySet()) {
            conn.addRequestProperty(header.getKey(), header.getValue());
        }

        conn.addRequestProperty("Content-Type", "application/json");
        conn.addRequestProperty("Accept", "application/json");
    }

    /**
     * @param httpMethod
     * @param content
     * @param conn
     * @throws IOException
     */
    private void prepareRequestBody(HttpMethod httpMethod, InputStream content, HttpURLConnection conn) throws IOException {
        if (HttpMethod.isValidRequestFor(httpMethod)) {
            conn.setDoOutput(true);
            final OutputStream output = conn.getOutputStream();
            try {
                this.prepareOutputStream(content, output);
            } finally {
                output.close();
                content.close();
            }
        }
    }

    /**
     * Convert InputStream content to OutputStream
     *
     * @param content
     * @param output
     * @throws IOException
     */
    private void prepareOutputStream(InputStream content, OutputStream output) throws IOException {
        final byte[] buffer = new byte[8192];
        for (int bytes = content.read(buffer); bytes != -1;
             bytes = content.read(buffer)) {
            output.write(buffer, 0, bytes);
        }
    }


    /**
     * Convert HttpURLConnection Stream to ByteArrayOutputStream
     *
     * @param conn
     * @return byte[]
     * @throws IOException
     */
    private byte[] body(HttpURLConnection conn) throws IOException {
        final InputStream input;
        if (conn.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
            input = conn.getErrorStream();
        } else {
            input = conn.getInputStream();
        }
        final byte[] body;
        if (input == null) {
            body = new byte[0];
        } else {
            try {

                final byte[] buffer = new byte[8192];
                final ByteArrayOutputStream output = new ByteArrayOutputStream();
                for (int bytes = input.read(buffer); bytes != -1;
                     bytes = input.read(buffer)) {
                    output.write(buffer, 0, bytes);
                }
                body = output.toByteArray();
            } finally {
                input.close();
            }
        }

        return body;
    }

}
