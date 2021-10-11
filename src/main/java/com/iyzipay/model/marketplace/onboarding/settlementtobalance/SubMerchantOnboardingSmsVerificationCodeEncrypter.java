package com.iyzipay.model.marketplace.onboarding.settlementtobalance;

import com.iyzipay.model.marketplace.onboarding.settlementtobalance.exception.SubMerchantOnboardingCryptoEncryptException;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.exception.SubMerchantOnboardingInvalidSaltException;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.exception.SubMerchantOnboardingInvalidSecretKeyException;
import com.iyzipay.model.marketplace.onboarding.settlementtobalance.exception.SubMerchantOnboardingInvalidSmsVerificationCode;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.spec.KeySpec;

public class SubMerchantOnboardingSmsVerificationCodeEncrypter {
    private static final int VERIFICATION_CODE_LENGTH = 6;

    private SubMerchantOnboardingSmsVerificationCodeEncrypter() {
    }

    public static String encrypt(SubMerchantOnboardingApiCredentials credentials, String plainTextSmsVerificationCode) {
        validateCredentials(credentials);
        validateSmsVerificationCode(plainTextSmsVerificationCode);

        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(credentials.getSecretKey().toCharArray(), credentials.getSalt().getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return DatatypeConverter.printBase64Binary(cipher.doFinal(plainTextSmsVerificationCode.getBytes()));
        } catch (Exception e) {
            throw new SubMerchantOnboardingCryptoEncryptException("Could not encrypt SMS verification code", e);
        }
    }

    private static void validateCredentials(SubMerchantOnboardingApiCredentials credentials) {
        validateSalt(credentials.getSalt());
        validateSecretKey(credentials.getSecretKey());
    }

    private static void validateSalt(String salt) {
        if (StringUtils.isBlank(salt)) {
            throw new SubMerchantOnboardingInvalidSaltException("Salt can not be empty or null");
        }
    }

    private static void validateSecretKey(String secretKey) {
        if (StringUtils.isBlank(secretKey)) {
            throw new SubMerchantOnboardingInvalidSecretKeyException("Secret key can not be empty or null");
        }
    }

    private static void validateSmsVerificationCode(String verificationCode) {
        if (StringUtils.isBlank(verificationCode)) {
            throw new SubMerchantOnboardingInvalidSmsVerificationCode("SMS verification code can not be empty or null");
        }

        if (StringUtils.length(verificationCode) != VERIFICATION_CODE_LENGTH) {
            throw new SubMerchantOnboardingInvalidSmsVerificationCode(
                    String.format("SMS verification code should be %d characters long", VERIFICATION_CODE_LENGTH)
            );
        }
    }
}
