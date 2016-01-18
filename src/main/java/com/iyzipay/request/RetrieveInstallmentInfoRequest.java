package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class RetrieveInstallmentInfoRequest extends Request {

    private String binNumber;
    private BigDecimal price;

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("binNumber", binNumber)
                .append("price", price)
                .toString();
    }
}
