package com.iyzipay;

import com.iyzipay.HashGenerator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashGeneratorTest {

    @Test
    public void should_generate_hash() {
        Assert.assertEquals("Cy84UuLZpfGhI7oaPD0Ckx1M0mo=", HashGenerator.generateHash("apiKey", "secretKey", "random", "[data=value]"));
    }

    @Test
    public void should_generate_hash_given_null_request() {
        assertEquals("cAbftoEp6S6eAJjNwFUmY87IdkQ=", HashGenerator.generateHash("apiKey", "secretKey", "random", null));
    }
}
