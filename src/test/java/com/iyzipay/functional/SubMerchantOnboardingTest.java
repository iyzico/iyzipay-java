package com.iyzipay.functional;

import com.iyzipay.model.Locale;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.SubMerchantOnboardingApiCredentials;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.SubMerchantOnboardingInitialize;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.SubMerchantOnboardingSmsVerificationCodeEncrypter;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.SubMerchantOnboardingVerify;
import com.iyzipay.request.SubMerchantOnboardingInitializeRequest;
import com.iyzipay.request.SubMerchantOnboardingVerifyRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class SubMerchantOnboardingTest extends BaseTest {
    @Test
    public void should_create_claim() {
        final String conversationId = RandomStringUtils.randomNumeric(9);
        final String email = randomizeEmail("john@doe.com");
        final String gsmNumber = randomGsmNumber();
        final String externalId = UUID.randomUUID().toString();

        SubMerchantOnboardingInitializeRequest request = new SubMerchantOnboardingInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId(conversationId);
        request.setName("John");
        request.setSurname("Doe");
        request.setEmail(email);
        request.setGsmNumber(gsmNumber);
        request.setTckNo("55555555555");
        request.setBirthDate("1996-10-07");
        request.setAddress("Besiktas / Istanbul");
        request.setExternalId(externalId);

        SubMerchantOnboardingInitialize response = SubMerchantOnboardingInitialize.initialize(request, options);

        System.out.println(response);

        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals(conversationId, response.getConversationId());
        assertNotNull(response.getTxId());
        assertFalse(StringUtils.isBlank(response.getTxId()));
    }

    private static String randomGsmNumber() {
        return String.format(
                "+90555%s",
                RandomStringUtils.randomNumeric(7)
        );
    }

    private static String randomizeEmail(String email) {
        return email.replace(
                "@",
                String.format(
                        "+%s@",
                        RandomStringUtils.randomAlphanumeric(5)
                )
        );
    }

    @Test
    public void should_verify_claim() {
        final String conversationId = RandomStringUtils.randomNumeric(9);
        final String email = randomizeEmail("john@doe.com");
        final String gsmNumber = randomGsmNumber();
        final String externalId = UUID.randomUUID().toString();

        final SubMerchantOnboardingApiCredentials apiCredentials = new SubMerchantOnboardingApiCredentials();
        apiCredentials.setSalt("D75CD3813ED14079");
        apiCredentials.setSecretKey("myKey");

        final String encryptedVerificationCode = SubMerchantOnboardingSmsVerificationCodeEncrypter.encrypt(apiCredentials, "123456");

        SubMerchantOnboardingInitializeRequest request = new SubMerchantOnboardingInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId(conversationId);
        request.setName("John");
        request.setSurname("Doe");
        request.setEmail(email);
        request.setGsmNumber(gsmNumber);
        request.setTckNo("55555555555");
        request.setBirthDate("1996-10-07");
        request.setAddress("Besiktas / Istanbul");
        request.setExternalId(externalId);

        SubMerchantOnboardingInitialize response = SubMerchantOnboardingInitialize.initialize(request, options);
        System.out.println(response);

        SubMerchantOnboardingVerifyRequest verifyRequest = new SubMerchantOnboardingVerifyRequest();
        verifyRequest.setLocale(Locale.TR.getValue());
        verifyRequest.setConversationId(conversationId);
        verifyRequest.setTxId(response.getTxId());
        verifyRequest.setSmsVerificationCode(encryptedVerificationCode);
        SubMerchantOnboardingVerify verifyResponse = SubMerchantOnboardingVerify.verify(verifyRequest, options);
        System.out.println(verifyResponse);

        assertNotNull(verifyResponse.getSubMerchantKey());
        assertFalse(StringUtils.isBlank(verifyResponse.getSubMerchantKey()));
    }
}
