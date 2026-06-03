package com.iyzipay.model.masspayout;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;

import java.math.BigDecimal;

public class MassPayoutBalanceRetrieve extends IyzipayResource {
    private BigDecimal balance;

    public static MassPayoutBalanceRetrieve retrieve(Options options) {
        String path = "/v1/mass/payout/balance";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2("/v1/mass/payout/balance", null, options),
                null,
                MassPayoutBalanceRetrieve.class);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}