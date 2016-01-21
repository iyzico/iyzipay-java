package com.iyzipay.model.sample;

import com.iyzipay.model.BouncedBankTransferList;
import com.iyzipay.model.Locale;
import com.iyzipay.model.PayoutCompletedTransactionList;
import com.iyzipay.request.RetrieveTransactionsRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RetrieveTransactionsSample extends Sample {

    @Test
    public void should_retrieve_payout_completed_transactions(){
        RetrieveTransactionsRequest request = new RetrieveTransactionsRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setDate("2015-06-02 19:13:00");

        PayoutCompletedTransactionList payoutCompletedTransactionList = PayoutCompletedTransactionList.retrieve(request, options);

        System.out.println(payoutCompletedTransactionList);

        assertNotNull(payoutCompletedTransactionList.getConversationId());
        assertNotNull(payoutCompletedTransactionList.getLocale());
        assertEquals(Locale.TR.getValue(), payoutCompletedTransactionList.getLocale());
    }

    @Test
    public void should_retrieve_bounced_bank_transfers(){
        RetrieveTransactionsRequest request = new RetrieveTransactionsRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setDate("2015-06-02 19:13:00");

        BouncedBankTransferList bouncedBankTransferList = BouncedBankTransferList.retrieve(request, options);

        System.out.println(bouncedBankTransferList);

        assertNotNull(bouncedBankTransferList.getConversationId());
        assertNotNull(bouncedBankTransferList.getLocale());
        assertEquals(Locale.TR.getValue(), bouncedBankTransferList.getLocale());
    }
}
