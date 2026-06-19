package com.iyzipay.sample.masspayout;

import com.iyzipay.model.Status;
import com.iyzipay.model.masspayout.resource.MassPayoutCancel;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MassPayoutCancelSample extends Sample {

    @Test
    public void should_cancel_mass_payout() {
        MassPayoutCancel response = MassPayoutCancel.cancel("requestId", options);

        assertNotNull(response);
        System.out.println("MassPayoutInit Response: " + response);
        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
    }
}