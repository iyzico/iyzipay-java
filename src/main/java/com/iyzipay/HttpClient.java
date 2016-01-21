package com.iyzipay;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class HttpClient extends RestTemplate {

    private HttpClient() {
    }

    public static HttpClient create() {
        return new HttpClient();
    }

    public HttpClient(ResponseErrorHandler errorHandler) {
        setErrorHandler(errorHandler);
    }

    public <T> ResponseEntity<T> exchange(String url, HttpMethod httpMethod, HttpHeaders headers, Object request, Class<T> responseType, Object... urlVariables) {
        HttpEntity<?> requestEntity = new HttpEntity<Object>(request, headers);
        return exchange(url, httpMethod, requestEntity, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> get(String url, Class<T> responseType, Object... urlVariables) {
        return get(url, null, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> get(String url, HttpHeaders headers, Class<T> responseType, Object... urlVariables) {
        return exchange(url, HttpMethod.GET, headers, null, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> post(String url, Object request, Class<T> responseType, Object... urlVariables) {
        return post(url, null, request, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> post(String url, HttpHeaders headers, Object request, Class<T> responseType, Object... urlVariables) {
        return exchange(url, HttpMethod.POST, headers, request, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> put(String url, Object request, Class<T> responseType, Object... urlVariables) {
        return put(url, null, request, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> put(String url, HttpHeaders headers, Object request, Class<T> responseType, Object... urlVariables) {
        return exchange(url, HttpMethod.PUT, headers, request, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> delete(String url, Class<T> responseType, Object... urlVariables) {
        return delete(url, null, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> delete(String url, HttpHeaders headers, Object request, Class<T> responseType, Object... urlVariables) {
        return exchange(url, HttpMethod.DELETE, headers, request, responseType, urlVariables);
    }

    public <T> ResponseEntity<T> delete(String url, HttpHeaders headers, Class<T> responseType, Object... urlVariables) {
        return exchange(url, HttpMethod.DELETE, headers, null, responseType, urlVariables);
    }
}
