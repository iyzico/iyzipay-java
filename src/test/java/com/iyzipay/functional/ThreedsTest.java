package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CreatePaymentRequestBuilder;
import com.iyzipay.functional.builder.request.CreateSubMerchantRequestBuilder;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.SubMerchant;
import com.iyzipay.model.ThreedsInitialize;
import com.iyzipay.model.ThreedsPayment;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.CreateSubMerchantRequest;
import com.iyzipay.request.CreateThreedsPaymentRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ThreedsTest extends BaseTest {

    @Test
    public void should_create_payment_with_physical_and_virtual_item_for_standard_merchant() {
        CreatePaymentRequest createPaymentRequest = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .callbackUrl("https://www.merchant.com/callback")
                .build();

        ThreedsInitialize threedsInitialize = ThreedsInitialize.create(createPaymentRequest, options);

        System.out.println(threedsInitialize);

        assertEquals(Locale.TR.getValue(), threedsInitialize.getLocale());
        assertEquals(Status.SUCCESS.getValue(), threedsInitialize.getStatus());
        assertTrue(threedsInitialize.verifySignature(options.getSecretKey()));
        assertNotEquals(0, threedsInitialize.getSystemTime());
        assertNotNull(threedsInitialize.getHtmlContent());
        assertNull(threedsInitialize.getErrorCode());
        assertNull(threedsInitialize.getErrorMessage());
        assertNull(threedsInitialize.getErrorGroup());
    }

    @Test
    public void should_create_threeds_payment_with_physical_and_virtual_item_for_marketplace_merchant() {
        CreateSubMerchantRequest createSubMerchantRequest = CreateSubMerchantRequestBuilder.create()
                .personalSubMerchantRequest()
                .build();

        SubMerchant subMerchant = SubMerchant.create(createSubMerchantRequest, options);

        CreatePaymentRequest createPaymentRequest = CreatePaymentRequestBuilder.create()
                .marketplacePayment(subMerchant.getSubMerchantKey())
                .callbackUrl("https://www.merchant.com/callback")
                .build();

        ThreedsInitialize threedsInitialize = ThreedsInitialize.create(createPaymentRequest, options);

        System.out.println(threedsInitialize);

        assertEquals(Locale.TR.getValue(), threedsInitialize.getLocale());
        assertEquals(Status.SUCCESS.getValue(), threedsInitialize.getStatus());
        assertTrue(threedsInitialize.verifySignature(options.getSecretKey()));
        assertNotEquals(0, threedsInitialize.getSystemTime());
        assertNotNull(threedsInitialize.getHtmlContent());
        assertNull(threedsInitialize.getErrorCode());
        assertNull(threedsInitialize.getErrorMessage());
        assertNull(threedsInitialize.getErrorGroup());
    }

    /*
        This test needs manual payment from Pecco on sandbox environment. So it does not contain any assertions.
    */
    @Test
    public void should_auth_threeds() {
        CreateThreedsPaymentRequest createThreedsPaymentRequest = new CreateThreedsPaymentRequest();
        createThreedsPaymentRequest.setConversationData("conversion data");
        createThreedsPaymentRequest.setPaymentId("1");
        createThreedsPaymentRequest.setLocale(Locale.TR.name());
        createThreedsPaymentRequest.setConversationId("123456789");

        ThreedsPayment threedsPayment = ThreedsPayment.create(createThreedsPaymentRequest, options);

        System.out.println(threedsPayment);
    }
}