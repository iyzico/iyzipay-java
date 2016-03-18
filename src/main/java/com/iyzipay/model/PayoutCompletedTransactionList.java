package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveTransactionsRequest;

import java.util.List;

public class PayoutCompletedTransactionList extends IyzipayResource {

    private List<PayoutCompletedTransaction> payoutCompletedTransactions;

    public static PayoutCompletedTransactionList retrieve(RetrieveTransactionsRequest request, Options options) {
        return options.getHttpClient().post(options.getBaseUrl() + "/reporting/settlement/payoutcompleted",
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
