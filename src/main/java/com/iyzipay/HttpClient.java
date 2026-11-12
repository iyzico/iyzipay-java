package com.iyzipay;

import com.google.gson.Gson;
import com.iyzipay.exception.HttpClientException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import static com.iyzipay.HttpMethod.*;

public class HttpClient {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCEPT = "Accept";
    private static final int TIMEOUT = 140000;
    private static final IyzipaySSLSocketFactory socketFactory = IyzipaySSLSocketFactory.getInstance();

    private final SSLSocketFactory sslSocketFactory;

    private HttpClient() {
        this(null);
    }

    private HttpClient(SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
    }

    public static HttpClient create() {
        return new HttpClient();
    }

    /**
     * Creates a client that uses the ssl socket factory configured on the given options,
     * or the JDK default when none is configured.
     *
     * @param options the options carrying the optional ssl socket factory.
     * @return a new http client.
     */
    public static HttpClient create(Options options) {
        if (options == null) {
            return new HttpClient();
        }
        return new HttpClient(options.getSslSocketFactory());
    }

    public <T> T get(String url, Proxy proxy, Class<T> responseType) {
        return exchange(url, proxy, GET, new HashMap<String, String>(), null, responseType);
    }

    public <T> T get(String url, Proxy proxy, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, proxy, GET, headers, request, responseType);
    }

    public <T> T post(String url, Proxy proxy, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, proxy, POST, headers, request, responseType);
    }

    public <T> T put(String url, Proxy proxy, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, proxy, PUT, headers, request, responseType);
    }

    public <T> T delete(String url, Proxy proxy, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, proxy, DELETE, headers, request, responseType);
    }

    private <T> T exchange(String url, Proxy proxy, HttpMethod httpMethod, Map<String, String> headers, Object request, Class<T> responseType) {
        Gson gson = new Gson();
        String body = gson.toJson(request);
        try {
            InputStream content = request == null ? null : new ByteArrayInputStream(body.getBytes(DEFAULT_CHARSET));
            String response = send(url, proxy, httpMethod, content, headers);
            return gson.fromJson(response, responseType);
        } catch (UnsupportedEncodingException e) {
            throw new HttpClientException(e.getMessage(), e);
        }
    }

    private String send(String url, Proxy proxy, HttpMethod httpMethod, InputStream content, Map<String, String> headers) {
        URLConnection raw;
        HttpsURLConnection conn = null;
        try {
            raw = (null != proxy) ? new URL(url).openConnection(proxy) : new URL(url).openConnection();
            conn = HttpsURLConnection.class.cast(raw);

            conn.setSSLSocketFactory(sslSocketFactory != null ? sslSocketFactory : socketFactory);
            conn.setRequestMethod(httpMethod.name());

            conn.setConnectTimeout(TIMEOUT);
            conn.setReadTimeout(TIMEOUT);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);

            prepareHeaders(headers, conn);
            if (content != null) {
                prepareRequestBody(httpMethod, content, conn);
            }

            return new String(body(conn), Charset.forName("UTF-8"));
        } catch (Exception e) {
            throw new HttpClientException(describeFailure(e), e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private String describeFailure(Throwable throwable) {
        StringBuilder description = new StringBuilder();
        Set<Throwable> visited = Collections.newSetFromMap(new IdentityHashMap<Throwable, Boolean>());
        int depth = 0;
        Throwable current = throwable;
        while (current != null && visited.add(current)) {
            if (depth > 0) {
                description.append(" (");
            }
            description.append(current.getClass().getSimpleName());
            if (current.getMessage() != null && !current.getMessage().isEmpty()) {
                description.append(": ").append(current.getMessage());
            }
            current = current.getCause();
            depth++;
        }
        for (depth--; depth > 0; depth--) {
            description.append(')');
        }
        return description.toString();
    }

    private void prepareHeaders(Map<String, String> headers, HttpURLConnection conn) {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            conn.addRequestProperty(header.getKey(), header.getValue());
        }

        conn.addRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
        conn.addRequestProperty(ACCEPT, APPLICATION_JSON);
    }

    private void prepareRequestBody(HttpMethod httpMethod, InputStream content, HttpURLConnection conn) throws IOException {
        if (HttpMethod.isValidRequestFor(httpMethod)) {
            conn.setDoOutput(true);
            final OutputStream output = conn.getOutputStream();
            try {
                prepareOutputStream(content, output);
            } finally {
                output.close();
                content.close();
            }
        }
    }

    private void prepareOutputStream(InputStream content, OutputStream output) throws IOException {
        final byte[] buffer = new byte[8192];
        for (int bytes = content.read(buffer); bytes != -1;
             bytes = content.read(buffer)) {
            output.write(buffer, 0, bytes);
        }
    }

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
