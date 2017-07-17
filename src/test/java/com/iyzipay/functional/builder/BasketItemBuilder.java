package com.iyzipay.functional.builder;

import com.iyzipay.model.BasketItem;
import com.iyzipay.model.BasketItemType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class BasketItemBuilder {

    private String id = "BI101";
    private String name = "Binocular";
    private String category1 = "Collectibles";
    private String category2 = "Accessories";
    private String itemType = BasketItemType.PHYSICAL.name();
    private String subMerchantKey;
    private BigDecimal subMerchantPrice;
    private BigDecimal price;

    private BasketItemBuilder() {
    }

    public static BasketItemBuilder create() {
        return new BasketItemBuilder();
    }

    public BasketItemBuilder id(String id) {
        this.id = id;
        return this;
    }

    public BasketItemBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BasketItemBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BasketItemBuilder category1(String category1) {
        this.category1 = category1;
        return this;
    }

    public BasketItemBuilder category2(String category2) {
        this.category2 = category2;
        return this;
    }

    public BasketItemBuilder itemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    public BasketItemBuilder subMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
        return this;
    }

    public BasketItemBuilder subMerchantPrice(BigDecimal subMerchantPrice) {
        this.subMerchantPrice = subMerchantPrice;
        return this;
    }

    public BasketItem build() {
        BasketItem basketItem = new BasketItem();
        basketItem.setId(id);
        basketItem.setPrice(price);
        basketItem.setName(name);
        basketItem.setCategory1(category1);
        basketItem.setCategory2(category2);
        basketItem.setItemType(itemType);
        basketItem.setSubMerchantKey(subMerchantKey);
        basketItem.setSubMerchantPrice(subMerchantPrice);
        return basketItem;
    }

    public List<BasketItem> buildDefaultBasketItems() {
        List<BasketItem> basketItems = new ArrayList<BasketItem>();
        basketItems.add(BasketItemBuilder.create().price(new BigDecimal("0.3")).category2(null).build());
        basketItems.add(BasketItemBuilder.create().price(new BigDecimal("0.5")).build());
        basketItems.add(BasketItemBuilder.create().price(new BigDecimal("0.2")).build());
        return basketItems;
    }

    public List<BasketItem> buildBasketItemsWithSubMerchantKey(String subMerchantKey) {
        List<BasketItem> basketItems = new ArrayList<BasketItem>();
        basketItems.add(BasketItemBuilder.create()
                .price(new BigDecimal("0.3"))
                .category2(null).subMerchantKey(subMerchantKey)
                .subMerchantPrice(new BigDecimal("0.27"))
                .build());
        basketItems.add(BasketItemBuilder.create().price(new BigDecimal("0.5"))
                .category2(null).subMerchantKey(subMerchantKey)
                .subMerchantPrice(new BigDecimal("0.42"))
                .build());
        basketItems.add(BasketItemBuilder.create().price(new BigDecimal("0.2"))
                .category2(null).subMerchantKey(subMerchantKey)
                .subMerchantPrice(new BigDecimal("0.18"))
                .build());
        return basketItems;
    }
}
