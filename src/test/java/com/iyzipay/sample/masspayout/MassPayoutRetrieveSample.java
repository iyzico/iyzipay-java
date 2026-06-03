package com.iyzipay.sample.masspayout;

import com.iyzipay.model.ItemType;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.masspayout.MassPayoutRetrieve;
import com.iyzipay.request.masspayout.MassPayoutRetrieveRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MassPayoutRetrieveSample extends Sample {

    @Test
    public void should_retrieve_mass_payout() {
        MassPayoutRetrieveRequest request = new MassPayoutRetrieveRequest();
        request.setRequestId("requestId");
        request.setLocale(Locale.TR.name());
        request.setConversationId("123456789");
        request.setSize(10);
        request.setPage(0);
        request.setItemType(ItemType.VALID);

        MassPayoutRetrieve response = MassPayoutRetrieve.retrieve(request, options);

        System.out.println("MassPayoutRetrieve Response: " + response);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}
