package com.iyzipay.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateSubMerchantRequest;
import com.iyzipay.request.RetrieveSubMerchantRequest;
import com.iyzipay.request.UpdateSubMerchantRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubMerchantSample extends Sample {

    @Test
    public void should_create_personal_sub_merchant() {
        CreateSubMerchantRequest request = new CreateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantExternalId("B49224");
        request.setSubMerchantType(SubMerchantType.PERSONAL.name());
        request.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        request.setContactName("John");
        request.setContactSurname("Doe");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("John's market");
        request.setIban("TR180006200119000006672315");
        request.setIdentityNumber("1234567890");
        request.setCurrency(Currency.TRY.name());

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
    }

    @Test
    public void should_create_private_sub_merchant() {
        CreateSubMerchantRequest request = new CreateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantExternalId("S49222");
        request.setSubMerchantType(SubMerchantType.PRIVATE_COMPANY.name());
        request.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        request.setTaxOffice("Tax office");
        request.setLegalCompanyTitle("John Doe inc");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("John's market");
        request.setIban("TR180006200119000006672315");
        request.setIdentityNumber("31300864726");
        request.setCurrency(Currency.TRY.name());

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
    }

    @Test
    public void should_create_limited_company_sub_merchant() {
        CreateSubMerchantRequest request = new CreateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantExternalId("AS49224");
        request.setSubMerchantType(SubMerchantType.LIMITED_OR_JOINT_STOCK_COMPANY.name());
        request.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        request.setTaxOffice("Tax office");
        request.setTaxNumber("9261877");
        request.setLegalCompanyTitle("XYZ inc");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("John's market");
        request.setIban("TR180006200119000006672315");
        request.setCurrency(Currency.TRY.name());

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
    }

    @Test
    public void should_update_personal_sub_merchant() {
        UpdateSubMerchantRequest request = new UpdateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantKey("sub merchant key");
        request.setIban("TR630006200027700006678204");
        request.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        request.setContactName("Jane");
        request.setContactSurname("Doe");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Jane's market");
        request.setIdentityNumber("31300864726");
        request.setCurrency(Currency.TRY.name());

        SubMerchant subMerchant = SubMerchant.update(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
    }

    @Test
    public void should_update_private_sub_merchant() {
        UpdateSubMerchantRequest request = new UpdateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantKey("sub merchant key");
        request.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        request.setTaxOffice("Tax office");
        request.setLegalCompanyTitle("Jane Doe inc");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Jane's market");
        request.setIban("TR180006200119000006672315");
        request.setIdentityNumber("31300864726");
        request.setCurrency(Currency.TRY.name());

        SubMerchant subMerchant = SubMerchant.update(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
    }

    @Test
    public void should_update_limited_company_sub_merchant() {
        UpdateSubMerchantRequest request = new UpdateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantKey("sub merchant key");
        request.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        request.setTaxOffice("Tax office");
        request.setTaxNumber("9261877");
        request.setLegalCompanyTitle("ABC inc");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Jane's market");
        request.setIban("TR180006200119000006672315");
        request.setCurrency(Currency.TRY.name());

        SubMerchant subMerchant = SubMerchant.update(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
    }

    @Test
    public void should_retrieve_sub_merchant() {
        RetrieveSubMerchantRequest request = new RetrieveSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantExternalId("AS49224");

        SubMerchant subMerchant = SubMerchant.retrieve(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
    }
}
