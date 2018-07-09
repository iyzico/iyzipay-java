package com.iyzipay.request;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.Request;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class IyziLinkSaveRequest extends Request {

    private String name;
    private String description;
    @SerializedName("encodedImageFile")
    private String base64EncodedImage;
    private BigDecimal price;
    @SerializedName("currencyCode")
    private String currency;
    private Boolean addressIgnorable;
    private Integer soldLimit;
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

    public String getBase64EncodedImage() {
        return base64EncodedImage;
    }

    public void setBase64EncodedImage(String base64EncodedImage) {
        this.base64EncodedImage = base64EncodedImage;
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

    public Boolean getAddressIgnorable() {
        return addressIgnorable;
    }

    public void setAddressIgnorable(Boolean addressIgnorable) {
        this.addressIgnorable = addressIgnorable;
    }

    public Integer getSoldLimit() {
        return soldLimit;
    }

    public void setSoldLimit(Integer soldLimit) {
        this.soldLimit = soldLimit;
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