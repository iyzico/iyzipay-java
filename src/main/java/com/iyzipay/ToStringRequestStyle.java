package com.iyzipay;

import org.apache.commons.lang3.builder.ToStringStyle;

public class ToStringRequestStyle extends ToStringStyle {

    public ToStringRequestStyle() {
        setUseClassName(false);
        setUseFieldNames(true);
        setUseIdentityHashCode(false);
    }

    @Override
    public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
        if (value != null) {
            super.append(buffer, fieldName, value, fullDetail);
        }
    }
}
