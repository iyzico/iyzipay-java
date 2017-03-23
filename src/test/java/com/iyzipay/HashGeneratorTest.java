package com.iyzipay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashGeneratorTest {

    @Test
    public void should_generate_hash() {
        assertEquals("Cy84UuLZpfGhI7oaPD0Ckx1M0mo=", HashGenerator.generateHash("apiKey", "secretKey", "random", "[data=value]"));
    }
}
