package com.iyzipay.sample.masspayout;

import com.iyzipay.model.masspayout.enumtype.OrderStatus;
import com.iyzipay.model.Status;
import com.iyzipay.model.masspayout.resource.MassPayoutOrderRetrieve;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MassPayoutOrderRetrieveSample extends Sample {

    @Test
    public void should_retrieve_mass_payout_order() {
        MassPayoutOrderRetrieve response = MassPayoutOrderRetrieve
                .retrieve("orderReferenceCode", options);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals("ext-93993493", response.getItem().getItemExternalId());
        assertEquals("a5a8ab5e-771f-4edb-9370-695f77559308", response.getItem().getReferenceCode());
        assertEquals("IBAN", response.getItem().getRecipientType());
        assertEquals("Payment for services", response.getItem().getDescription());
        assertEquals(OrderStatus.INIT, response.getItem().getItemStatus());
        assertEquals("TRY", response.getItem().getCurrencyCode());
        assertEquals("4ac393f3-e917-4805-be90-f504a0e5c9a2", response.getItem().getMassPayoutRequestId());
    }
}
