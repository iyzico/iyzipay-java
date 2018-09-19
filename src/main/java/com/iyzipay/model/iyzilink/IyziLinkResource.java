package com.iyzipay.model.iyzilink;

import com.iyzipay.IyzipayResource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IyziLinkResource extends IyzipayResource {

    private IyziLinkItem data;

    public IyziLinkItem getData() {
        return data;
    }

    public void setData(IyziLinkItem data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}