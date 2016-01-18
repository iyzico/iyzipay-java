package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveTransactionsRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class PayoutCompletedTransactionList extends IyzipayResource {

    private List<PayoutCompletedTransaction> payoutCompletedTransactions;

    public static PayoutCompletedTransactionList retrieve(RetrieveTransactionsRequest request, Options options){
        return HttpClient.create().post(options.getBaseUrl() + "/reporting/settlement/payoutcompleted",
                getHttpHeaders(request, options),
                request,
                PayoutCompletedTransactionList.class)
                .getBody();
    }

    public List<PayoutCompletedTransaction> getPayoutCompletedTransactions() {
        return payoutCompletedTransactions;
    }

    public void setPayoutCompletedTransactions(List<PayoutCompletedTransaction> payoutCompletedTransactions) {
        this.payoutCompletedTransactions = payoutCompletedTransactions;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
