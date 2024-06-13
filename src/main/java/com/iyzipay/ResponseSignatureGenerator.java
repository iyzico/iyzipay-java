package com.iyzipay;

import com.iyzipay.exception.HttpClientException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public interface ResponseSignatureGenerator {

    String SEPARATOR = ":";
    String HMAC_SHA_256 = "HmacSHA256";
    DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00000000");
    int DECIMAL_SCALE = 8;
    String EMPTY_PARAM = "";


    default String generateSignature(String secretKey, List<Object> params) {
        try {
            String dataToSign = appendSignatureParams(params);
            Mac mac = Mac.getInstance(HMAC_SHA_256);
            mac.init(new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA_256));
            return DatatypeConverter.printHexBinary(mac.doFinal(dataToSign.getBytes(StandardCharsets.UTF_8))).toLowerCase(Locale.ENGLISH);
        } catch (NoSuchAlgorithmException e) {
            throw new HttpClientException("HMAC couldn't be generated", e);
        } catch (InvalidKeyException e) {
            throw new HttpClientException("Authentication content couldn't be generated", e);
        }
    }

    default String appendSignatureParams(List<Object> signatureParameters) {
        return signatureParameters.stream()
                .map(parameter -> {
                    if (Objects.isNull(parameter)) {
                        return EMPTY_PARAM;
                    } else if (parameter instanceof BigDecimal) {
                        return DECIMAL_FORMAT.format(((BigDecimal) parameter).setScale(DECIMAL_SCALE, RoundingMode.DOWN));
                    } else {
                        return parameter.toString();
                    }
                })
                .collect(Collectors.joining(SEPARATOR));
    }
}
