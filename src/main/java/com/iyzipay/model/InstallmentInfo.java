package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveInstallmentInfoRequest;

import java.util.List;

public class InstallmentInfo extends IyzipayResource {

    private List<InstallmentDetail> installmentDetails;

    public static InstallmentInfo retrieve(RetrieveInstallmentInfoRequest request, Options options) {
        return httpClient.post(options.getBaseUrl() + "/payment/iyzipos/installment",
                getHttpHeaders(request, options),
                request,
                InstallmentInfo.class);
    }

    public List<InstallmentDetail> getInstallmentDetails() {
        return installmentDetails;
    }

    public void setInstallmentDetails(List<InstallmentDetail> installmentDetails) {
        this.installmentDetails = installmentDetails;
    }
}
