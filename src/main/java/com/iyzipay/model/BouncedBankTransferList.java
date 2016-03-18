package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveTransactionsRequest;

import java.util.List;

public class BouncedBankTransferList extends IyzipayResource {

    @SerializedName("bouncedRows")
    private List<BankTransfer> bankTransfers;

    public static BouncedBankTransferList retrieve(RetrieveTransactionsRequest request, Options options) {
        return options.getHttpClient().post(options.getBaseUrl() + "/reporting/settlement/bounced",
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
