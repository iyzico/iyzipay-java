package com.iyzipay.model.iyzilink;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class IyziLinkItem {

    private String name;
    private String description;
    private BigDecimal price;
    @SerializedName("currencyCode")
    private String currency;
    private String token;
    @SerializedName("productStatus")
    private IyziLinkStatus iyziLinkStatus;
    private String url;
    private String imageUrl;
    private Boolean addressIgnorable;
    private Integer soldCount;
    private Integer soldLimit;
    private Integer remainingSoldLimit;
    private Boolean installmentRequested;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public IyziLinkStatus getIyziLinkStatus() {
        return iyziLinkStatus;
    }

    public void setIyziLinkStatus(IyziLinkStatus iyziLinkStatus) {
        this.iyziLinkStatus = iyziLinkStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getAddressIgnorable() {
        return addressIgnorable;
    }

    public void setAddressIgnorable(Boolean addressIgnorable) {
        this.addressIgnorable = addressIgnorable;
    }

    public Integer getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Integer soldCount) {
        this.soldCount = soldCount;
    }

    public Integer getSoldLimit() {
        return soldLimit;
    }

    public void setSoldLimit(Integer soldLimit) {
        this.soldLimit = soldLimit;
    }

    public Integer getRemainingSoldLimit() {
        return remainingSoldLimit;
    }

    public void setRemainingSoldLimit(Integer remainingSoldLimit) {
        this.remainingSoldLimit = remainingSoldLimit;
    }

    public Boolean getInstallmentRequested() {
        return installmentRequested;
    }

    public void setInstallmentRequested(Boolean installmentRequested) {
        this.installmentRequested = installmentRequested;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}