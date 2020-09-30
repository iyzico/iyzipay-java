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
        return HttpClient.create().post(options.getBaseUrl() + "/reporting/settlement/bounced",
                getHttpProxy(options),
                getHttpHeaders(request, options),
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
