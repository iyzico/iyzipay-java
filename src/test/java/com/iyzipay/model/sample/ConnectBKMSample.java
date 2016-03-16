package com.iyzipay.model.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateConnectBKMInitializeRequest;
import com.iyzipay.request.RetrieveBKMAuthRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectBKMSample extends Sample {

    @Test
    public void should_initialize_bkm_express() {
        CreateConnectBKMInitializeRequest request = new CreateConnectBKMInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setCallbackUrl("https://www.merchant.com/callback");

        // prepare buyer
        request.setBuyerId("100");
        request.setBuyerEmail("email@email.com");
        request.setBuyerIp("85.34.78.112");

        // default pos
        request.setConnectorName("connector name");
        request.setInstallmentDetails(prepareInstallmentDetails());

        ConnectBKMInitialize connectBKMInitialize = ConnectBKMInitialize.create(request, options);

        System.out.println(connectBKMInitialize);

        assertNotNull(connectBKMInitialize.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), connectBKMInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), connectBKMInitialize.getLocale());
        assertEquals("123456789", connectBKMInitialize.getConversationId());
    }

    @Test
    public void should_retrieve_bkm_auth() {
        RetrieveBKMAuthRequest request = new RetrieveBKMAuthRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setToken("token");

        ConnectBKMAuth connectBKMAuth = ConnectBKMAuth.retrieve(request, options);

        System.out.println(connectBKMAuth);

        assertNotNull(connectBKMAuth.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), connectBKMAuth.getStatus());
        assertEquals(Locale.TR.getValue(), connectBKMAuth.getLocale());
        assertEquals("123456789", connectBKMAuth.getConversationId());
    }

    private List<BKMInstallment> prepareInstallmentDetails() {
        List<BKMInstallment> installmentDetails = new ArrayList<BKMInstallment>();
        installmentDetails.add(isbankInstallmentDetails());
        installmentDetails.add(finansbankInstallmentDetails());
        installmentDetails.add(akbankInstallmentDetails());
        installmentDetails.add(ykbInstallmentDetails());
        installmentDetails.add(denizbankInstallmentDetails());
        installmentDetails.add(halkbankInstallmentDetails());
        return installmentDetails;
    }

    private BKMInstallment isbankInstallmentDetails() {
        BKMInstallment installmentDetail = new BKMInstallment();
        installmentDetail.setBankId(64L);

        List<BKMInstallmentPrice> installmentPrices = new ArrayList<BKMInstallmentPrice>();

        BKMInstallmentPrice singleInstallment = new BKMInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BKMInstallmentPrice twoInstallments = new BKMInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice threeInstallments = new BKMInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice sixInstallments = new BKMInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BKMInstallmentPrice nineInstallments = new BKMInstallmentPrice();
        nineInstallments.setInstallmentNumber(9);
        nineInstallments.setTotalPrice(new BigDecimal("1.4"));

        installmentPrices.add(singleInstallment);
        installmentPrices.add(twoInstallments);
        installmentPrices.add(threeInstallments);
        installmentPrices.add(sixInstallments);
        installmentPrices.add(nineInstallments);

        installmentDetail.setInstallmentPrices(installmentPrices);
        return installmentDetail;
    }

    private BKMInstallment finansbankInstallmentDetails() {
        BKMInstallment installmentDetail = new BKMInstallment();
        installmentDetail.setBankId(111L);

        List<BKMInstallmentPrice> installmentPrices = new ArrayList<BKMInstallmentPrice>();

        BKMInstallmentPrice singleInstallment = new BKMInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BKMInstallmentPrice twoInstallments = new BKMInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice threeInstallments = new BKMInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice sixInstallments = new BKMInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BKMInstallmentPrice nineInstallments = new BKMInstallmentPrice();
        nineInstallments.setInstallmentNumber(9);
        nineInstallments.setTotalPrice(new BigDecimal("1.4"));

        installmentPrices.add(singleInstallment);
        installmentPrices.add(twoInstallments);
        installmentPrices.add(threeInstallments);
        installmentPrices.add(sixInstallments);
        installmentPrices.add(nineInstallments);

        installmentDetail.setInstallmentPrices(installmentPrices);
        return installmentDetail;
    }

    private BKMInstallment akbankInstallmentDetails() {
        BKMInstallment installmentDetail = new BKMInstallment();
        installmentDetail.setBankId(46L);

        List<BKMInstallmentPrice> installmentPrices = new ArrayList<BKMInstallmentPrice>();

        BKMInstallmentPrice singleInstallment = new BKMInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BKMInstallmentPrice twoInstallments = new BKMInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice threeInstallments = new BKMInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice sixInstallments = new BKMInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BKMInstallmentPrice nineInstallments = new BKMInstallmentPrice();
        nineInstallments.setInstallmentNumber(9);
        nineInstallments.setTotalPrice(new BigDecimal("1.4"));

        installmentPrices.add(singleInstallment);
        installmentPrices.add(twoInstallments);
        installmentPrices.add(threeInstallments);
        installmentPrices.add(sixInstallments);
        installmentPrices.add(nineInstallments);

        installmentDetail.setInstallmentPrices(installmentPrices);
        return installmentDetail;
    }

    private BKMInstallment ykbInstallmentDetails() {
        BKMInstallment installmentDetail = new BKMInstallment();
        installmentDetail.setBankId(67L);

        List<BKMInstallmentPrice> installmentPrices = new ArrayList<BKMInstallmentPrice>();

        BKMInstallmentPrice singleInstallment = new BKMInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BKMInstallmentPrice twoInstallments = new BKMInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice threeInstallments = new BKMInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice sixInstallments = new BKMInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BKMInstallmentPrice nineInstallments = new BKMInstallmentPrice();
        nineInstallments.setInstallmentNumber(9);
        nineInstallments.setTotalPrice(new BigDecimal("1.4"));

        installmentPrices.add(singleInstallment);
        installmentPrices.add(twoInstallments);
        installmentPrices.add(threeInstallments);
        installmentPrices.add(sixInstallments);
        installmentPrices.add(nineInstallments);

        installmentDetail.setInstallmentPrices(installmentPrices);
        return installmentDetail;
    }

    private BKMInstallment denizbankInstallmentDetails() {
        BKMInstallment installmentDetail = new BKMInstallment();
        installmentDetail.setBankId(134L);

        List<BKMInstallmentPrice> installmentPrices = new ArrayList<BKMInstallmentPrice>();

        BKMInstallmentPrice singleInstallment = new BKMInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BKMInstallmentPrice twoInstallments = new BKMInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice threeInstallments = new BKMInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice sixInstallments = new BKMInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BKMInstallmentPrice nineInstallments = new BKMInstallmentPrice();
        nineInstallments.setInstallmentNumber(9);
        nineInstallments.setTotalPrice(new BigDecimal("1.4"));

        installmentPrices.add(singleInstallment);
        installmentPrices.add(twoInstallments);
        installmentPrices.add(threeInstallments);
        installmentPrices.add(sixInstallments);
        installmentPrices.add(nineInstallments);

        installmentDetail.setInstallmentPrices(installmentPrices);
        return installmentDetail;
    }

    private BKMInstallment halkbankInstallmentDetails() {
        BKMInstallment installmentDetail = new BKMInstallment();
        installmentDetail.setBankId(12L);

        List<BKMInstallmentPrice> installmentPrices = new ArrayList<BKMInstallmentPrice>();

        BKMInstallmentPrice singleInstallment = new BKMInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BKMInstallmentPrice twoInstallments = new BKMInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice threeInstallments = new BKMInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BKMInstallmentPrice sixInstallments = new BKMInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BKMInstallmentPrice nineInstallments = new BKMInstallmentPrice();
        nineInstallments.setInstallmentNumber(9);
        nineInstallments.setTotalPrice(new BigDecimal("1.4"));

        installmentPrices.add(singleInstallment);
        installmentPrices.add(twoInstallments);
        installmentPrices.add(threeInstallments);
        installmentPrices.add(sixInstallments);
        installmentPrices.add(nineInstallments);

        installmentDetail.setInstallmentPrices(installmentPrices);
        return installmentDetail;
    }
}
