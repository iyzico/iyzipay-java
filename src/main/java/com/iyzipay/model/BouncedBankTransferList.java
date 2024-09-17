package com.iyzipay.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveTransactionsRequest;

public class BouncedBankTransferList extends IyzipayResource {

    @SerializedName("bouncedRows")
    private List<BankTransfer> bankTransfers;

    public static BouncedBankTransferList retrieve(RetrieveTransactionsRequest request, Options options) {
        String path = "/reporting/settlement/bounced";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                BouncedBankTransferList.class);
    }

    public List<BankTransfer> getBankTransfers() {
        return bankTransfers;
    }

    public void setBankTransfers(List<BankTransfer> bankTransfers) {
        this.bankTransfers = bankTransfers;
    }
}
