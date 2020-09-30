package com.iyzipay.model;

import java.util.List;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveTransactionsRequest;

public class PayoutCompletedTransactionList extends IyzipayResource {

    private List<PayoutCompletedTransaction> payoutCompletedTransactions;

    public static PayoutCompletedTransactionList retrieve(RetrieveTransactionsRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/reporting/settlement/payoutcompleted",
                getHttpProxy(options),
                getHttpHeaders(request, options),
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
