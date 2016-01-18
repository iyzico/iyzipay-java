package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveTransactionsRequest;

import java.util.List;

public class BouncedBankTransferList extends IyzipayResource {

    private List<BankTransfer> bouncedRows;

    public static BouncedBankTransferList retrieve(RetrieveTransactionsRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/reporting/settlement/bounced",
                getHttpHeaders(request, options),
                request,
                BouncedBankTransferList.class)
                .getBody();
    }


    public List<BankTransfer> getBouncedRows() {
        return bouncedRows;
    }

    public void setBouncedRows(List<BankTransfer> bouncedRows) {
        this.bouncedRows = bouncedRows;
    }
}
