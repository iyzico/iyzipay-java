package com.iyzipay;

public enum HttpMethod {
    GET,
    POST,
    DELETE,
    PUT;

    public static boolean isValidRequestFor(HttpMethod httpMethod) {
        return POST.equals(httpMethod) || PUT.equals(httpMethod) || DELETE.equals(httpMethod);
    }
}
