package com.iyzipay.sample.masspayout;

import com.iyzipay.model.Status;
import com.iyzipay.model.masspayout.resource.MassPayoutBalanceRetrieve;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MassPayoutRetrieveBalanceSample extends Sample {

    @Test
    public void should_retrieve_mass_payout_balance() {
        MassPayoutBalanceRetrieve response = MassPayoutBalanceRetrieve.retrieve(options);

        System.out.println("MassPayoutBalanceRetrieve Response: " + response);

        assertNotNull(response);
        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
    }
}
