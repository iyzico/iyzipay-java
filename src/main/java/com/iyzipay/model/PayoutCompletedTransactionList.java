package com.iyzipay.model;

import java.util.List;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveTransactionsRequest;

public class PayoutCompletedTransactionList extends IyzipayResource {

    private List<PayoutCompletedTransaction> payoutCompletedTransactions;

    public static PayoutCompletedTransactionList retrieve(RetrieveTransactionsRequest request, Options options) {
        String path = "/reporting/settlement/payoutcompleted";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PayoutCompletedTransactionList.class);
    }

    public List<PayoutCompletedTransaction> getPayoutCompletedTransactions() {
        return payoutCompletedTransactions;
    }

    public void setPayoutCompletedTransactions(List<PayoutCompletedTransaction> payoutCompletedTransactions) {
        this.payoutCompletedTransactions = payoutCompletedTransactions;
    }
}
