package com.iyzipay.model.universalcardstorage;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.InitUcsRequest;

public class UcsInitResource extends IyzipayResource {

    private String ucsToken;
    private String gsmNumber;
    private String maskedGsmNumber;
    private String merchantName;
    private String script;
    private String scriptType;

    public static UcsInitResource create(InitUcsRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/ucs/init";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                UcsInitResource.class);
    }

    public String getUcsToken() {
        return ucsToken;
    }

    public void setUcsToken(String ucsToken) {
        this.ucsToken = ucsToken;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
    }

    public String getMaskedGsmNumber() {
        return maskedGsmNumber;
    }

    public void setMaskedGsmNumber(String maskedGsmNumber) {
        this.maskedGsmNumber = maskedGsmNumber;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getScriptType() {
        return scriptType;
    }

    public void setScriptType(String scriptType) {
        this.scriptType = scriptType;
    }
}
