package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveInstallmentInfoRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class InstallmentInfo extends IyzipayResource {

    private List<InstallmentDetail> installmentDetails;

    public static InstallmentInfo retrieve(RetrieveInstallmentInfoRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/installment",
                getHttpHeaders(request, options),
                request,
                InstallmentInfo.class)
                .getBody();
    }

    public List<InstallmentDetail> getInstallmentDetails() {
        return installmentDetails;
    }

    public void setInstallmentDetails(List<InstallmentDetail> installmentDetails) {
        this.installmentDetails = installmentDetails;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
