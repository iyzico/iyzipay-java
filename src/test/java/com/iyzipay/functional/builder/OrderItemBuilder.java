package com.iyzipay.functional.builder;

import com.iyzipay.model.OrderItem;
import com.iyzipay.model.OrderItemType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class OrderItemBuilder {

    private String id = "BI101";
    private String name = "Binocular";
    private String category1 = "Collectibles";
    private String category2 = "Accessories";
    private String itemType = OrderItemType.PHYSICAL.name();
    private String itemUrl = "www.merchant.biz/itemUrl";
    private BigDecimal price;

    private OrderItemBuilder() {
    }

    public static OrderItemBuilder create() {
        return new OrderItemBuilder();
    }

    public OrderItemBuilder id(String id) {
        this.id = id;
        return this;
    }

    public OrderItemBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OrderItemBuilder name(String name) {
        this.name = name;
        return this;
    }

    public OrderItemBuilder category1(String category1) {
        this.category1 = category1;
        return this;
    }

    public OrderItemBuilder category2(String category2) {
        this.category2 = category2;
        return this;
    }

    public OrderItemBuilder itemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    public OrderItemBuilder itemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
        return this;
    }

    public OrderItem build() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(id);
        orderItem.setPrice(price);
        orderItem.setName(name);
        orderItem.setCategory1(category1);
        orderItem.setCategory2(category2);
        orderItem.setItemType(itemType);
        orderItem.setItemUrl(itemUrl);
        return orderItem;
    }

    public List<OrderItem> buildDefaultOrderItems() {
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(OrderItemBuilder.create().price(new BigDecimal("0.3")).category2(null).build());
        orderItems.add(OrderItemBuilder.create().price(new BigDecimal("0.5")).build());
        orderItems.add(OrderItemBuilder.create().price(new BigDecimal("0.2")).build());
        return orderItems;
    }
}
