package com.iyzipay.sample;

import com.iyzipay.FileBase64Encoder;
import com.iyzipay.IyzipayResource;
import com.iyzipay.PagingRequest;
import com.iyzipay.Request;
import com.iyzipay.model.Currency;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.iyzilink.IyziLink;
import com.iyzipay.model.iyzilink.IyziLinkPagingResource;
import com.iyzipay.model.iyzilink.IyziLinkResource;
import com.iyzipay.model.iyzilink.IyziLinkSaveResource;
import com.iyzipay.request.IyziLinkSaveRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IyziLinkSample extends Sample {

    @Test
    public void should_create_iyziLink() {
        IyziLinkSaveRequest request = new IyziLinkSaveRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setName("sample-name");
        request.setDescription("sample-description");
        String imagePath = getClass().getClassLoader().getResource("images/sample_image.jpg").getPath();
        request.setBase64EncodedImage(FileBase64Encoder.encode(imagePath));
        request.setPrice(BigDecimal.ONE);
        request.setCurrency(Currency.TRY.name());
        request.setAddressIgnorable(Boolean.FALSE);
        request.setSoldLimit(1);
        request.setInstallmentRequested(Boolean.FALSE);

        IyziLinkSaveResource response = IyziLink.create(request, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotNull(response.getSystemTime());
        assertNotNull(response.getData().getToken());
        assertNotNull(response.getData().getUrl());
        assertNotNull(response.getData().getImageUrl());
    }

    @Test
    public void should_update_iyziLink() {
        IyziLinkSaveRequest request = new IyziLinkSaveRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setName("ft-name-updated");
        request.setDescription("ft-description-updated");
        request.setPrice(BigDecimal.TEN);
        request.setCurrency(Currency.TRY.name());

        IyziLinkSaveResource response = IyziLink.update("TOKEN", request, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotNull(response.getSystemTime());
        assertNotNull(response.getData().getToken());
        assertNotNull(response.getData().getUrl());
        assertNotNull(response.getData().getImageUrl());
    }

    @Test
    public void should_retrieve_iyziLinks_with_pagination() {
        PagingRequest pagingRequest = new PagingRequest();
        pagingRequest.setPage(1);
        pagingRequest.setCount(1);
        pagingRequest.setLocale(Locale.TR.getValue());
        pagingRequest.setConversationId("123456789");

        IyziLinkPagingResource response = IyziLink.retrieveAll(pagingRequest, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotNull(response.getSystemTime());
        assertEquals(new Integer(1), response.getData().getCurrentPage());
        assertEquals(1, response.getData().getIyziLinkItems().size());
        assertNotNull(response.getData().getIyziLinkItems().get(0).getToken());
    }

    @Test
    public void should_retrieve_iyziLink_with_token() {
        Request request = new Request();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");

        IyziLinkResource response = IyziLink.retrieve("TOKEN", request, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotNull(response.getSystemTime());
        assertNotNull(response.getData().getName());
        assertNotNull(response.getData().getDescription());
        assertNotNull(response.getData().getPrice());
        assertNotNull(response.getData().getCurrency());
        assertNotNull(response.getData().getToken());
    }

    @Test
    public void should_delete_iyziLink() {
        Request deleteRequest = new Request();
        deleteRequest.setLocale(Locale.TR.getValue());
        deleteRequest.setConversationId("123456789");

        IyzipayResource response = IyziLink.delete("TOKEN", deleteRequest, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotNull(response.getSystemTime());
    }
}