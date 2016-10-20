package com.iyzipay;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class ToStringRequestBuilder extends ToStringBuilder {

    public ToStringRequestBuilder(Object object) {
        super(object, new ToStringRequestStyle());
    }

    @Override
    public ToStringBuilder append(String fieldName, Object obj) {
        if (obj != null && obj instanceof BigDecimal) {
            return super.append(fieldName, RequestFormatter.formatPrice((BigDecimal) obj));
        } else {
            return super.append(fieldName, obj);
        }
    }
}
