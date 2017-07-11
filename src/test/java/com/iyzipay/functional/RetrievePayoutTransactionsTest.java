package com.iyzipay.functional;

import com.iyzipay.model.BouncedBankTransferList;
import com.iyzipay.model.Locale;
import com.iyzipay.model.PayoutCompletedTransactionList;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrieveTransactionsRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetrievePayoutTransactionsTest extends BaseTest {

    @Test
    public void should_retrieve_payout_completed_transactions() {
        RetrieveTransactionsRequest request = new RetrieveTransactionsRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setDate("2016-01-22 19:13:00");

        PayoutCompletedTransactionList payoutCompletedTransactionList = PayoutCompletedTransactionList.retrieve(request, options);

        System.out.println(payoutCompletedTransactionList);

        assertEquals(Status.SUCCESS.getValue(), payoutCompletedTransactionList.getStatus());
        assertEquals(Locale.TR.getValue(), payoutCompletedTransactionList.getLocale());
        assertEquals("123456789", payoutCompletedTransactionList.getConversationId());
        assertNotNull(payoutCompletedTransactionList.getSystemTime());
        assertNull(payoutCompletedTransactionList.getErrorCode());
        assertNull(payoutCompletedTransactionList.getErrorGroup());
        assertNull(payoutCompletedTransactionList.getErrorMessage());
    }

    @Test
    public void should_retrieve_bounced_bank_transfers() {
        RetrieveTransactionsRequest request = new RetrieveTransactionsRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setDate("2016-01-22 19:13:00");

        BouncedBankTransferList bouncedBankTransferList = BouncedBankTransferList.retrieve(request, options);

        System.out.println(bouncedBankTransferList);

        assertEquals(Status.SUCCESS.getValue(), bouncedBankTransferList.getStatus());
        assertEquals(Locale.TR.getValue(), bouncedBankTransferList.getLocale());
        assertEquals("123456789", bouncedBankTransferList.getConversationId());
        assertNotNull(bouncedBankTransferList.getSystemTime());
        assertNull(bouncedBankTransferList.getErrorCode());
        assertNull(bouncedBankTransferList.getErrorGroup());
        assertNull(bouncedBankTransferList.getErrorMessage());
    }
}
