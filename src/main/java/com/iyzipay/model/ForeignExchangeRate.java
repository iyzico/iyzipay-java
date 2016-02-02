package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.ConvertForeignExchangeRateRequest;

import java.math.BigDecimal;

public class ForeignExchangeRate extends IyzipayResource {

    private BigDecimal convertedAmount;

    public static ForeignExchangeRate retrieve(ConvertForeignExchangeRateRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/foreign-exchange-rate/convert",
                getHttpHeaders(request, options),
                request,
                ForeignExchangeRate.class);
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
