package com.iyzipay.model.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.SubMerchant;
import com.iyzipay.model.SubMerchantType;
import com.iyzipay.request.CreateSubMerchantRequest;
import com.iyzipay.request.RetrieveSubMerchantRequest;
import com.iyzipay.request.UpdateSubMerchantRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubMerchantSample extends Sample {

    @Test
    public void should_create_personal_sub_merchant(){
        CreateSubMerchantRequest request = new CreateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantExternalId("B49227");
        request.setSubMerchantType(SubMerchantType.PERSONAL.name());
        request.setAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy 34732");
        request.setContactName("Sabri Onur");
        request.setContactSurname("Tüzün");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Sabri Onur'un mağazası");
        request.setIban("TR180006200119000006672315");
        request.setIdentityNumber("232");

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getConversationId());
        assertNotNull(subMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
    }

    @Test
    public void should_create_private_sub_merchant(){
        CreateSubMerchantRequest request = new CreateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantExternalId("S49221");
        request.setSubMerchantType(SubMerchantType.PRIVATE_COMPANY.name());
        request.setAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy 34732");
        request.setTaxOffice("Kadıköy V.D.");
        request.setLegalCompanyTitle("Sabri Onur Tüzün Bilişim Hizmetleri");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Sabri Onur'un mağazası");
        request.setIban("TR180006200119000006672315");
        request.setIdentityNumber("31300864726");

        SubMerchant subMerchant = SubMerchant.create(request, options);

        assertNotNull(subMerchant.getConversationId());
        assertNotNull(subMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
    }

    @Test
    public void should_create_limited_company_sub_merchant(){
        CreateSubMerchantRequest request = new CreateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantExternalId("AS49222");
        request.setSubMerchantType(SubMerchantType.LIMITED_OR_JOINT_STOCK_COMPANY.name());
        request.setAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy 34732");
        request.setTaxOffice("Kadıköy V.D.");
        request.setTaxNumber("9261877");
        request.setLegalCompanyTitle("XYZ Bilişim Hizmetleri A.Ş.");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Sabri Onur'un mağazası");
        request.setIban("TR180006200119000006672315");

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getConversationId());
        assertNotNull(subMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
    }

    @Test
    public void should_update_personal_sub_merchant(){
        UpdateSubMerchantRequest request = new UpdateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantKey("sub merchant key");
        request.setIban("TR630006200027700006678204");
        request.setAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy 34732");
        request.setContactName("Hakan");
        request.setContactSurname("Erdoğan");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Hakan Erdoğan'ın mağazası");
        request.setIdentityNumber("31300864726");

        SubMerchant subMerchant = SubMerchant.update(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getConversationId());
        assertNotNull(subMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
    }

    @Test
    public void should_update_private_sub_merchant(){
        UpdateSubMerchantRequest request = new UpdateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantKey("sub merchant key");
        request.setAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy 34732");
        request.setTaxOffice("Kadıköy V.D.");
        request.setLegalCompanyTitle("Hakan Erdoğan Bilişim Hizmetleri");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Hakan Erdoğan'ın mağazası");
        request.setIban("TR180006200119000006672315");
        request.setIdentityNumber("31300864726");

        SubMerchant subMerchant = SubMerchant.update(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getConversationId());
        assertNotNull(subMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
    }

    @Test
    public void should_update_limited_company_sub_merchant(){
        UpdateSubMerchantRequest request = new UpdateSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantKey("sub merchant key");
        request.setAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy 34732");
        request.setTaxOffice("Kadıköy V.D.");
        request.setTaxNumber("9261877");
        request.setLegalCompanyTitle("ABC Bilişim Hizmetleri A.Ş.");
        request.setEmail("email@submerchantemail.com");
        request.setGsmNumber("+905350000000");
        request.setName("Hakan Erdoğan'ın mağazası");
        request.setIban("TR180006200119000006672315");

        SubMerchant subMerchant = SubMerchant.update(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getConversationId());
        assertNotNull(subMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
    }

    @Test
    public void should_retrieve_sub_merchant(){
        RetrieveSubMerchantRequest request = new RetrieveSubMerchantRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setSubMerchantExternalId("B49227");

        SubMerchant subMerchant = SubMerchant.retrieve(request, options);

        System.out.println(subMerchant);

        assertNotNull(subMerchant.getConversationId());
        assertNotNull(subMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
    }

}
