package com.iyzipay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveTransactionsRequest;

import java.util.List;

public class BouncedBankTransferList extends IyzipayResource {

    @JsonProperty("bouncedRows")
    private List<BankTransfer> bankTransfers;

    public static BouncedBankTransferList retrieve(RetrieveTransactionsRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/reporting/settlement/bounced",
                getHttpHeaders(request, options),
                request,
                BouncedBankTransferList.class)
                .getBody();
    }

    public List<BankTransfer> getBankTransfers() {
        return bankTransfers;
    }

    public void setBankTransfers(List<BankTransfer> bankTransfers) {
        this.bankTransfers = bankTransfers;
    }
}
