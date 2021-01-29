package com.iyzipay.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.SubMerchantOnboardingApiCredentials;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.SubMerchantOnboardingInitialize;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.SubMerchantOnboardingSmsVerificationCodeEncrypter;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.SubMerchantOnboardingVerify;
import com.iyzipay.request.SubMerchantOnboardingInitializeRequest;
import com.iyzipay.request.SubMerchantOnboardingVerifyRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore // FIXME: remove @Ignore after Java8+ migration
public class SubMerchantOnboardingSample extends Sample {

    public SubMerchantOnboardingApiCredentials onboardingApiCredentials;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        onboardingApiCredentials = new SubMerchantOnboardingApiCredentials();
        onboardingApiCredentials.setSalt(System.getProperty("onboardingApiSalt"));
        onboardingApiCredentials.setSecretKey(System.getProperty("onboardingApiSecretKey"));
    }

    @Test
    public void should_create_sub_merchant_claim() {
        SubMerchantOnboardingInitializeRequest request = new SubMerchantOnboardingInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setName("Jane");
        request.setSurname("Doe");
        request.setEmail(randomizeEmail("email@submerchant.com")); // email+xxxxx@submerchant.com where x is alphanumeric character
        request.setGsmNumber(randomGsmNumber()); // +90555xxxxxxx where 0 <= x <= 9
        request.setTckNo("31300864726");
        request.setBirthDate("1996-10-07");
        request.setAddress("Besiktas / Istanbul");
        request.setExternalId("LG00001");

        SubMerchantOnboardingInitialize response = SubMerchantOnboardingInitialize.initialize(request, options);
        System.out.println(response);

        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotNull(response.getTxId());
        assertFalse(StringUtils.isBlank(response.getTxId()));
    }

    /**
     * Generates a random GSM number with TR (+90) country code.
     * <pre>
     *      Example: +905551231212
     * </pre>
     *
     * @return a random GSM number with fixed prefix of "+90555"
     */
    private static String randomGsmNumber() {
        return String.format(
                "+90555%s",
                RandomStringUtils.randomNumeric(7)
        );
    }

    /**
     * Adds "+xxxxx" to `local-part` of given  e-mail address, where `x` is a random alphanumeric character.
     * <pre>
     *      Example:
     *          john@doe.com -> john+nviJs@doe.com
     * </pre>
     *
     * @param email e-mail address to be randomized
     * @return randomized e-mail in "[local-part]+xxxxx@[domain]" format
     */
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
    public void should_verify_sub_merchant_claim() {
        // Create the Claim
        SubMerchantOnboardingInitializeRequest request = new SubMerchantOnboardingInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setName("Jane");
        request.setSurname("Doe");
        request.setEmail(randomizeEmail("email@submerchant.com")); // email+xxxxx@submerchant.com where x is alphanumeric character
        request.setGsmNumber(randomGsmNumber()); // +90555xxxxxxx where 0 <= x <= 9
        request.setTckNo("31300864726");
        request.setBirthDate("1996-10-07");
        request.setAddress("Besiktas / Istanbul");
        request.setExternalId("LG00002");

        SubMerchantOnboardingInitialize response = SubMerchantOnboardingInitialize.initialize(request, options);
        System.out.println(response);

        assertNotNull(response.getTxId());
        assertFalse(StringUtils.isBlank(response.getTxId()));

        /*
        Encrypt the verification code using AES using PBKDF2WithHmacSHA256 key derivation algorithm
        with your own secret key and salt (onboarding api credentials)
         */
        final String encryptedVerificationCode = SubMerchantOnboardingSmsVerificationCodeEncrypter.encrypt(onboardingApiCredentials, "123456");

        SubMerchantOnboardingVerifyRequest verifyRequest = new SubMerchantOnboardingVerifyRequest();
        verifyRequest.setLocale(Locale.TR.getValue());
        verifyRequest.setConversationId("123456789");
        verifyRequest.setTxId(response.getTxId());
        verifyRequest.setSmsVerificationCode(encryptedVerificationCode);
        SubMerchantOnboardingVerify verifyResponse = SubMerchantOnboardingVerify.verify(verifyRequest, options);
        System.out.println(verifyResponse);

        assertNotNull(verifyResponse.getSubMerchantKey());
        assertFalse(StringUtils.isBlank(verifyResponse.getSubMerchantKey()));
    }
}
