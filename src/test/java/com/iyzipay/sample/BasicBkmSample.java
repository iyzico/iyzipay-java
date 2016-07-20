package com.iyzipay.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateBasicBkmInitializeRequest;
import com.iyzipay.request.RetrieveBkmRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasicBkmSample extends Sample {

    @Test
    public void should_initialize_bkm_express() {
        CreateBasicBkmInitializeRequest request = new CreateBasicBkmInitializeRequest();
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

        BasicBkmInitialize basicBkmInitialize = BasicBkmInitialize.create(request, options);

        System.out.println(basicBkmInitialize);

        assertNotNull(basicBkmInitialize.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), basicBkmInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), basicBkmInitialize.getLocale());
        assertEquals("123456789", basicBkmInitialize.getConversationId());
    }

    @Test
    public void should_retrieve_bkm_auth() {
        RetrieveBkmRequest request = new RetrieveBkmRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setToken("token");

        BasicBkm basicBkm = BasicBkm.retrieve(request, options);

        System.out.println(basicBkm);

        assertNotNull(basicBkm.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), basicBkm.getStatus());
        assertEquals(Locale.TR.getValue(), basicBkm.getLocale());
        assertEquals("123456789", basicBkm.getConversationId());
    }

    private List<BkmInstallment> prepareInstallmentDetails() {
        List<BkmInstallment> installmentDetails = new ArrayList<BkmInstallment>();
        installmentDetails.add(isbankInstallmentDetails());
        installmentDetails.add(finansbankInstallmentDetails());
        installmentDetails.add(akbankInstallmentDetails());
        installmentDetails.add(ykbInstallmentDetails());
        installmentDetails.add(denizbankInstallmentDetails());
        installmentDetails.add(halkbankInstallmentDetails());
        return installmentDetails;
    }

    private BkmInstallment isbankInstallmentDetails() {
        BkmInstallment installmentDetail = new BkmInstallment();
        installmentDetail.setBankId(64L);

        List<BkmInstallmentPrice> installmentPrices = new ArrayList<BkmInstallmentPrice>();

        BkmInstallmentPrice singleInstallment = new BkmInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BkmInstallmentPrice twoInstallments = new BkmInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice threeInstallments = new BkmInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice sixInstallments = new BkmInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BkmInstallmentPrice nineInstallments = new BkmInstallmentPrice();
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

    private BkmInstallment finansbankInstallmentDetails() {
        BkmInstallment installmentDetail = new BkmInstallment();
        installmentDetail.setBankId(111L);

        List<BkmInstallmentPrice> installmentPrices = new ArrayList<BkmInstallmentPrice>();

        BkmInstallmentPrice singleInstallment = new BkmInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BkmInstallmentPrice twoInstallments = new BkmInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice threeInstallments = new BkmInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice sixInstallments = new BkmInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BkmInstallmentPrice nineInstallments = new BkmInstallmentPrice();
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

    private BkmInstallment akbankInstallmentDetails() {
        BkmInstallment installmentDetail = new BkmInstallment();
        installmentDetail.setBankId(46L);

        List<BkmInstallmentPrice> installmentPrices = new ArrayList<BkmInstallmentPrice>();

        BkmInstallmentPrice singleInstallment = new BkmInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BkmInstallmentPrice twoInstallments = new BkmInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice threeInstallments = new BkmInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice sixInstallments = new BkmInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BkmInstallmentPrice nineInstallments = new BkmInstallmentPrice();
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

    private BkmInstallment ykbInstallmentDetails() {
        BkmInstallment installmentDetail = new BkmInstallment();
        installmentDetail.setBankId(67L);

        List<BkmInstallmentPrice> installmentPrices = new ArrayList<BkmInstallmentPrice>();

        BkmInstallmentPrice singleInstallment = new BkmInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BkmInstallmentPrice twoInstallments = new BkmInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice threeInstallments = new BkmInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice sixInstallments = new BkmInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BkmInstallmentPrice nineInstallments = new BkmInstallmentPrice();
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

    private BkmInstallment denizbankInstallmentDetails() {
        BkmInstallment installmentDetail = new BkmInstallment();
        installmentDetail.setBankId(134L);

        List<BkmInstallmentPrice> installmentPrices = new ArrayList<BkmInstallmentPrice>();

        BkmInstallmentPrice singleInstallment = new BkmInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BkmInstallmentPrice twoInstallments = new BkmInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice threeInstallments = new BkmInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice sixInstallments = new BkmInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BkmInstallmentPrice nineInstallments = new BkmInstallmentPrice();
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

    private BkmInstallment halkbankInstallmentDetails() {
        BkmInstallment installmentDetail = new BkmInstallment();
        installmentDetail.setBankId(12L);

        List<BkmInstallmentPrice> installmentPrices = new ArrayList<BkmInstallmentPrice>();

        BkmInstallmentPrice singleInstallment = new BkmInstallmentPrice();
        singleInstallment.setInstallmentNumber(1);
        singleInstallment.setTotalPrice(new BigDecimal("1"));

        BkmInstallmentPrice twoInstallments = new BkmInstallmentPrice();
        twoInstallments.setInstallmentNumber(2);
        twoInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice threeInstallments = new BkmInstallmentPrice();
        threeInstallments.setInstallmentNumber(3);
        threeInstallments.setTotalPrice(new BigDecimal("1.1"));

        BkmInstallmentPrice sixInstallments = new BkmInstallmentPrice();
        sixInstallments.setInstallmentNumber(6);
        sixInstallments.setTotalPrice(new BigDecimal("1.2"));

        BkmInstallmentPrice nineInstallments = new BkmInstallmentPrice();
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
