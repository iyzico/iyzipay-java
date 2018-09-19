package com.iyzipay.model.iyzilink;

import com.iyzipay.IyzipayResource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IyziLinkSaveResource extends IyzipayResource {

    private IyziLinkSave data;

    public IyziLinkSave getData() {
        return data;
    }

    public void setData(IyziLinkSave data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}