package com.iyzipay.request.masspayout;

import com.iyzipay.Request;
import com.iyzipay.model.masspayout.MassPayoutItem;

import java.util.List;

public class MassPayoutInitRequest extends Request {

    private String externalId;
    private String purpose;
    private List<MassPayoutItem> items;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<MassPayoutItem> getItems() {
        return items;
    }

    public void setItems(List<MassPayoutItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "MassPayoutInitRequest{" +
                "externalId='" + externalId + '\'' +
                ", purpose='" + purpose + '\'' +
                ", items=" + items +
                '}';
    }
}
