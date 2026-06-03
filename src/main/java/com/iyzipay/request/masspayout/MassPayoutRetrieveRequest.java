package com.iyzipay.request.masspayout;

import com.iyzipay.Request;
import com.iyzipay.model.ItemType;

public class MassPayoutRetrieveRequest extends Request {

    private String externalMassPayoutId;
    private String requestId;
    private ItemType itemType;
    private Integer page;
    private Integer size;

    public String getExternalMassPayoutId() {
        return externalMassPayoutId;
    }

    public void setExternalMassPayoutId(String externalMassPayoutId) {
        this.externalMassPayoutId = externalMassPayoutId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "MassPayoutRetrieveRequest{" +
                "externalMassPayoutId='" + externalMassPayoutId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", itemType=" + itemType +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}
