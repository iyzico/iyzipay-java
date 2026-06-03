package com.iyzipay.model.requesttopay.resource;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestToPayListData {

    private int currentPage;
    private int totalPageCount;
    @SerializedName("items")
    private List<RequestToPayData> items;

    public int getCurrentPage() { return currentPage; }
    public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }

    public int getTotalPageCount() { return totalPageCount; }
    public void setTotalPageCount(int totalPageCount) { this.totalPageCount = totalPageCount; }

    public List<RequestToPayData> getItems() { return items; }
    public void setItems(List<RequestToPayData> items) { this.items = items; }
}