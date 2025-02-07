package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CreateSubMerchantRequestBuilder;
import com.iyzipay.functional.builder.request.RetrieveSubMerchantRequestBuilder;
import com.iyzipay.functional.builder.request.UpdateSubMerchantRequestBuilder;
import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.SubMerchant;
import com.iyzipay.model.SubMerchantType;
import com.iyzipay.request.BlockageInfoRequest;
import com.iyzipay.request.CreateSubMerchantRequest;
import com.iyzipay.request.RetrieveSubMerchantRequest;
import com.iyzipay.request.UpdateSubMerchantRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class SubMerchantTest extends BaseTest {

    @Test
    public void should_create_personal_sub_merchant() {
        String subMerchantExternalId = RandomGenerator.randomId();
        CreateSubMerchantRequest request = CreateSubMerchantRequestBuilder.create()
                .subMerchantType(SubMerchantType.PERSONAL.name())
                .contactName("John")
                .contactSurname("Doe")
                .identityNumber("123456789")
                .subMerchantExternalId(subMerchantExternalId)
                .build();

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
        assertNotEquals(0, subMerchant.getSystemTime());
        assertNull(subMerchant.getErrorCode());
        assertNull(subMerchant.getErrorMessage());
        assertNull(subMerchant.getErrorGroup());
    }

    @Test
    public void should_create_private_sub_merchant() {
        String subMerchantExternalId = RandomGenerator.randomId();
        CreateSubMerchantRequest request = CreateSubMerchantRequestBuilder.create()
                .subMerchantType(SubMerchantType.PRIVATE_COMPANY.name())
                .legalCompanyTitle("John Doe inc")
                .taxOffice("Tax office")
                .identityNumber("31300864726")
                .subMerchantExternalId(subMerchantExternalId)
                .build();

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
        assertNotEquals(0, subMerchant.getSystemTime());
        assertNull(subMerchant.getErrorCode());
        assertNull(subMerchant.getErrorMessage());
        assertNull(subMerchant.getErrorGroup());
    }

    @Test
    public void should_create_limited_company_sub_merchant() {
        String subMerchantExternalId = RandomGenerator.randomId();
        CreateSubMerchantRequest request = CreateSubMerchantRequestBuilder.create()
                .subMerchantExternalId(subMerchantExternalId)
                .subMerchantType(SubMerchantType.LIMITED_OR_JOINT_STOCK_COMPANY.name())
                .taxOffice("Tax office")
                .taxNumber("9261877")
                .legalCompanyTitle("XYZ inc")
                .build();

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
        assertNotEquals(0, subMerchant.getSystemTime());
        assertNull(subMerchant.getErrorCode());
        assertNull(subMerchant.getErrorMessage());
        assertNull(subMerchant.getErrorGroup());
    }

    @Test
    public void should_update_personal_sub_merchant() {
        CreateSubMerchantRequest createPersonalSubMerchantRequest = CreateSubMerchantRequestBuilder.create()
                .personalSubMerchantRequest()
                .build();

        String subMerchantKey = SubMerchant.create(createPersonalSubMerchantRequest, options).getSubMerchantKey();

        UpdateSubMerchantRequest updateSubMerchantRequest = UpdateSubMerchantRequestBuilder.create()
                .subMerchantKey(subMerchantKey)
                .contactName("Jane")
                .contactSurname("Doe")
                .identityNumber("31300864726")
                .name("Jane's market")
                .build();

        SubMerchant subMerchant = SubMerchant.update(updateSubMerchantRequest, options);

        System.out.println(subMerchant);

        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
        assertNotEquals(0, subMerchant.getSystemTime());
        assertNull(subMerchant.getErrorCode());
        assertNull(subMerchant.getErrorMessage());
        assertNull(subMerchant.getErrorGroup());
    }

    @Test
    public void should_update_private_sub_merchant() {
        CreateSubMerchantRequest createPrivateSubMerchantRequest = CreateSubMerchantRequestBuilder.create()
                .privateSubMerchantRequest()
                .build();

        String subMerchantKey = SubMerchant.create(createPrivateSubMerchantRequest, options).getSubMerchantKey();

        UpdateSubMerchantRequest updateSubMerchantRequest = UpdateSubMerchantRequestBuilder.create()
                .subMerchantKey(subMerchantKey)
                .identityNumber("31300864726")
                .taxOffice("Tax office")
                .legalCompanyTitle("Jane Doe inc")
                .build();

        SubMerchant subMerchant = SubMerchant.update(updateSubMerchantRequest, options);

        System.out.println(subMerchant);

        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
        assertNotEquals(0, subMerchant.getSystemTime());
        assertNull(subMerchant.getErrorCode());
        assertNull(subMerchant.getErrorMessage());
        assertNull(subMerchant.getErrorGroup());
    }

    @Test
    public void should_update_limited_company_sub_merchant() {
        CreateSubMerchantRequest createLimitedCompanySubMerchantRequest = CreateSubMerchantRequestBuilder.create()
                .limitedCompanySubMerchantRequest()
                .build();

        String subMerchantKey = SubMerchant.create(createLimitedCompanySubMerchantRequest, options).getSubMerchantKey();

        UpdateSubMerchantRequest updateSubMerchantRequest = UpdateSubMerchantRequestBuilder.create()
                .subMerchantKey(subMerchantKey)
                .name("Jane's market")
                .identityNumber("31300864726")
                .taxOffice("Tax office")
                .legalCompanyTitle("ABC inc")
                .build();

        SubMerchant subMerchant = SubMerchant.update(updateSubMerchantRequest, options);

        System.out.println(subMerchant);

        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
        assertNotEquals(0, subMerchant.getSystemTime());
        assertNull(subMerchant.getErrorCode());
        assertNull(subMerchant.getErrorMessage());
        assertNull(subMerchant.getErrorGroup());
    }

    @Test
    public void should_retrieve_sub_merchant() {
        String subMerchantExternalId = RandomGenerator.randomId();
        CreateSubMerchantRequest createLimitedCompanySubMerchantRequest = CreateSubMerchantRequestBuilder.create()
                .limitedCompanySubMerchantRequest()
                .subMerchantExternalId(subMerchantExternalId)
                .build();

        SubMerchant.create(createLimitedCompanySubMerchantRequest, options);

        RetrieveSubMerchantRequest request = RetrieveSubMerchantRequestBuilder.create()
                .subMerchantExternalId(subMerchantExternalId)
                .build();

        SubMerchant subMerchant = SubMerchant.retrieve(request, options);

        System.out.println(subMerchant);

        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
        assertEquals("9261877", subMerchant.getTaxNumber());
        assertEquals("TR180006200119000006672315", subMerchant.getIban());
        assertEquals("Tax office", subMerchant.getTaxOffice());
        assertEquals(subMerchantExternalId, subMerchant.getSubMerchantExternalId());
        assertNotEquals(0, subMerchant.getSystemTime());
        assertNull(subMerchant.getErrorCode());
        assertNull(subMerchant.getErrorMessage());
        assertNull(subMerchant.getErrorGroup());
    }

    @Test
    public void should_create_personal_sub_merchant_with_blockage() {
        String subMerchantExternalId = RandomGenerator.randomId();
        CreateSubMerchantRequest request = CreateSubMerchantRequestBuilder.create()
                .subMerchantType(SubMerchantType.PERSONAL.name())
                .contactName("John")
                .contactSurname("Doe")
                .identityNumber("123456789")
                .subMerchantExternalId(subMerchantExternalId)
                .blockageAmount("100.00")
                .build();

        SubMerchant subMerchant = SubMerchant.create(request, options);

        System.out.println(subMerchant);

        assertEquals(Status.SUCCESS.getValue(), subMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), subMerchant.getLocale());
        assertEquals("123456789", subMerchant.getConversationId());
        assertNotEquals(0, subMerchant.getSystemTime());
        assertNull(subMerchant.getErrorCode());
        assertNull(subMerchant.getErrorMessage());
        assertNull(subMerchant.getErrorGroup());
    }

    @Test
    public void should_retrieve_blockage_info() {

        BlockageInfoRequest request = new BlockageInfoRequest();
        request.setSubMerchantKey("+SBpNqAV+HmUd5GYG5+CzebDcmA=");
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456");

        SubMerchant subMerchant = SubMerchant.retrieveBlockageInfo(request, options);

        System.out.println(subMerchant);
        assertEquals("100.00000000", subMerchant.getTotalBlockage());

    }
}