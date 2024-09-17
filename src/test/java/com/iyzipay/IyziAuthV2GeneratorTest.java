package com.iyzipay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IyziAuthV2GeneratorTest {

    @Test
    public void should_generate_hash() {
        assertEquals("YXBpS2V5OmFwaUtleSZyYW5kb21LZXk6cmFuZG9tJnNpZ25hdHVyZToxYzQwNGY3MjgyN2MyNTQxMjM0MzNlYmYxM2Y1Nzc5NzVkODA1YjYxMDMzMTM5ZjIwZjVmMTNjYWI3ZWFiYjYx", IyziAuthV2Generator.generateAuthContent("/v2/uri?test=true", "apiKey", "secretKey", "random", "[data=value]"));
    }

    @Test
    public void should_generate_same_hash_when_uri_do_not_have_query_parameters() {
        assertEquals("YXBpS2V5OmFwaUtleSZyYW5kb21LZXk6cmFuZG9tJnNpZ25hdHVyZTphOTBlYzFhZWNkNjhlMzdjYzMwOTQyZjg1Y2U2YjBkNTM0MzVhNGNhNDVlMDQ3NjliNDZlM2MzNWQ4MWJmNmZl", IyziAuthV2Generator.generateAuthContent("/v2/uri", "apiKey", "secretKey", "random", "[data=value]"));
    }

    @Test
    public void should_generate_hash_when_given_request_body_is_null_request() {
        assertEquals("YXBpS2V5OmFwaUtleSZyYW5kb21LZXk6cmFuZG9tJnNpZ25hdHVyZTpiN2EyZjYzNGRlOWNkNTkzYWNjZDlhNTNhZjI4Zjc4YjgyZWM3NmRjMjYyN2Y2NTdmNjY0M2NmNjYyYzI2Njdh", IyziAuthV2Generator.generateAuthContent("/v2/uri?test=true", "apiKey", "secretKey", "random", null));
    }
}