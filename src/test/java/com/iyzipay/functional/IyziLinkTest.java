package com.iyzipay.functional;

import com.iyzipay.FileBase64Encoder;
import com.iyzipay.PagingRequest;
import com.iyzipay.Request;
import com.iyzipay.model.Currency;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.iyzilink.IyziLink;
import com.iyzipay.model.iyzilink.IyziLinkPagingResource;
import com.iyzipay.model.iyzilink.IyziLinkResource;
import com.iyzipay.model.iyzilink.IyziLinkSaveResource;
import com.iyzipay.model.iyzilink.IyziLinkStatus;
import com.iyzipay.request.IyziLinkSaveRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class IyziLinkTest extends BaseTest {

    @Test
    public void should_create_iyziLink() {
        IyziLinkSaveRequest request = new IyziLinkSaveRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setName("ft-name");
        request.setDescription("ft-description");
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
        assertNotEquals(0, response.getSystemTime());
        assertNotNull(response.getData().getToken());
        assertNotNull(response.getData().getUrl());
        assertNotNull(response.getData().getImageUrl());
    }

    @Test
    public void should_update_iyziLink() {
        IyziLinkSaveRequest createRequest = new IyziLinkSaveRequest();
        createRequest.setLocale(Locale.TR.getValue());
        createRequest.setConversationId("123456789");
        createRequest.setName("ft-name");
        createRequest.setDescription("ft-description");
        String imagePath = getClass().getClassLoader().getResource("images/sample_image.jpg").getPath();
        createRequest.setBase64EncodedImage(FileBase64Encoder.encode(imagePath));
        createRequest.setPrice(BigDecimal.ONE);
        createRequest.setCurrency(Currency.TRY.name());
        createRequest.setAddressIgnorable(Boolean.FALSE);
        createRequest.setSoldLimit(1);
        createRequest.setInstallmentRequested(Boolean.FALSE);

        String token = IyziLink.create(createRequest, options).getData().getToken();

        IyziLinkSaveRequest request = new IyziLinkSaveRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setName("ft-name-updated");
        request.setDescription("ft-description-updated");
        request.setPrice(BigDecimal.TEN);
        request.setCurrency(Currency.TRY.name());

        IyziLinkSaveResource response = IyziLink.update(token, request, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotEquals(0, response.getSystemTime());
        assertNotNull(response.getData().getToken());
        assertNotNull(response.getData().getUrl());
        assertNotNull(response.getData().getImageUrl());
    }

    @Test
    public void should_retrieve_iyziLinks_with_pagination() {
        IyziLinkSaveRequest createRequest = new IyziLinkSaveRequest();
        createRequest.setLocale(Locale.TR.getValue());
        createRequest.setConversationId("123456789");
        createRequest.setName("ft-name");
        createRequest.setDescription("ft-description");
        String imagePath = getClass().getClassLoader().getResource("images/sample_image.jpg").getPath();
        createRequest.setBase64EncodedImage(FileBase64Encoder.encode(imagePath));
        createRequest.setPrice(BigDecimal.ONE);
        createRequest.setCurrency(Currency.TRY.name());
        createRequest.setAddressIgnorable(Boolean.FALSE);
        createRequest.setSoldLimit(1);
        createRequest.setInstallmentRequested(Boolean.FALSE);

        IyziLink.create(createRequest, options);

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
        assertNotEquals(0, response.getSystemTime());
        assertEquals(1, response.getData().getIyziLinkItems().size());
        assertEquals(new Integer(1), response.getData().getCurrentPage());
    }

    @Test
    public void should_retrieve_iyziLink_with_token() {
        IyziLinkSaveRequest createRequest = new IyziLinkSaveRequest();
        createRequest.setLocale(Locale.TR.getValue());
        createRequest.setConversationId("123456789");
        createRequest.setName("ft-name");
        createRequest.setDescription("ft-description");
        String imagePath = getClass().getClassLoader().getResource("images/sample_image.jpg").getPath();
        createRequest.setBase64EncodedImage(FileBase64Encoder.encode(imagePath));
        createRequest.setPrice(BigDecimal.ONE);
        createRequest.setCurrency(Currency.TRY.name());
        createRequest.setAddressIgnorable(Boolean.FALSE);
        createRequest.setSoldLimit(1);
        createRequest.setInstallmentRequested(Boolean.FALSE);

        String token = IyziLink.create(createRequest, options).getData().getToken();

        Request request = new Request();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");

        IyziLinkResource response = IyziLink.retrieve(token, request, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotEquals(0, response.getSystemTime());
        assertEquals("ft-name", response.getData().getName());
        assertEquals("ft-description", response.getData().getDescription());
        assertEquals(new BigDecimal("1.00000000"), response.getData().getPrice());
        assertEquals(Currency.TRY.name(), response.getData().getCurrency());
        assertEquals(token, response.getData().getToken());
        assertEquals(IyziLinkStatus.ACTIVE, response.getData().getIyziLinkStatus());
        assertNotNull(response.getData().getImageUrl());
        assertEquals(Boolean.FALSE, response.getData().getAddressIgnorable());
    }

    /*@Test
    public void should_delete_iyziLink() {
        IyziLinkSaveRequest createRequest = new IyziLinkSaveRequest();
        createRequest.setLocale(Locale.TR.getValue());
        createRequest.setConversationId("8123456789");
        createRequest.setName("ft-name");
        createRequest.setDescription("ft-description");
        String imagePath = getClass().getClassLoader().getResource("images/sample_image.jpg").getPath();
        createRequest.setBase64EncodedImage(FileBase64Encoder.encode(imagePath));
        createRequest.setPrice(BigDecimal.ONE);
        createRequest.setCurrency(Currency.TRY.name());
        createRequest.setAddressIgnorable(Boolean.FALSE);
        createRequest.setSoldLimit(1);
        createRequest.setInstallmentRequested(Boolean.FALSE);

        String token = IyziLink.create(createRequest, options).getData().getToken();

        Request deleteRequest = new Request();
        deleteRequest.setLocale(Locale.TR.getValue());
        deleteRequest.setConversationId("123456789");

        IyzipayResource response = IyziLink.delete(token, deleteRequest, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotEquals(0, response.getSystemTime());
    }*/
}
