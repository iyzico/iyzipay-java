package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class BasketItem {

    private String id;
    private BigDecimal price;
    private String name;
    private String category1;
    private String category2;
    private String itemType;
    private String subMerchantKey;
    private BigDecimal subMerchantPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public BigDecimal getSubMerchantPrice() {
        return subMerchantPrice;
    }

    public void setSubMerchantPrice(BigDecimal subMerchantPrice) {
        this.subMerchantPrice = subMerchantPrice;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("id", id)
                .append("price", price)
                .append("name", name)
                .append("category1", category1)
                .append("category2", category2)
                .append("itemType", itemType)
                .append("subMerchantKey", subMerchantKey)
                .append("subMerchantPrice", subMerchantPrice)
                .toString();
    }
}