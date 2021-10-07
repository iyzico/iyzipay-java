package com.iyzipay.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

public class RefundTxDetail {

    private Long refundTxId;
    private String refundConversationId;
    private BigDecimal refundPrice;
    private Integer refundStatus;
    private Boolean isAfterSettlement;
    private Date createdDate;
    private String currencyCode;
    private String authCode;
    private String hostReference;
    private String errorGroup;
    private String errorCode;
    private String errorMessage;

    public Long getRefundTxId() {
        return refundTxId;
    }

    public void setRefundTxId(Long refundTxId) {
        this.refundTxId = refundTxId;
    }

    public String getRefundConversationId() {
        return refundConversationId;
    }

    public void setRefundConversationId(String refundConversationId) {
        this.refundConversationId = refundConversationId;
    }

    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Boolean getAfterSettlement() {
        return isAfterSettlement;
    }

    public void setAfterSettlement(Boolean afterSettlement) {
        isAfterSettlement = afterSettlement;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getHostReference() {
        return hostReference;
    }

    public void setHostReference(String hostReference) {
        this.hostReference = hostReference;
    }

    public String getErrorGroup() {
        return errorGroup;
    }

    public void setErrorGroup(String errorGroup) {
        this.errorGroup = errorGroup;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
