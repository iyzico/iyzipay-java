package com.iyzipay.model.iyzilink;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class IyziLinkPaging {

    @SerializedName("items")
    private List<IyziLinkItem> iyziLinkItems;
    private Long totalCount;
    private Integer currentPage;
    private Integer pageCount;

    public List<IyziLinkItem> getIyziLinkItems() {
        return iyziLinkItems;
    }

    public void setIyziLinkItems(List<IyziLinkItem> iyziLinkItems) {
        this.iyziLinkItems = iyziLinkItems;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}