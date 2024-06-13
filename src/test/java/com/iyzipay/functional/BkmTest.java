package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CreateBkmInitializeRequestBuilder;
import com.iyzipay.model.BkmInitialize;
import com.iyzipay.request.CreateBkmInitializeRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BkmTest extends BaseTest {

    @Test
    public void should_initialize_bkm() {
        CreateBkmInitializeRequest request = CreateBkmInitializeRequestBuilder.create()
                .price(BigDecimal.ONE)
                .callbackUrl("https://www.merchant.com/callback")
                .build();

        BkmInitialize bkmInitialize = BkmInitialize.create(request, options);

        System.out.println(bkmInitialize);

        assertTrue(bkmInitialize.verifyChecksum(options.getSecretKey()));
        assertNotNull(bkmInitialize.getHtmlContent());
        assertNotNull(bkmInitialize.getToken());
        assertTrue(bkmInitialize.getHtmlContent().contains(bkmInitialize.getToken()));
    }
}