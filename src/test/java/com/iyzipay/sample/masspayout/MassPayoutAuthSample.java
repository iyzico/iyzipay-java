package com.iyzipay.sample.masspayout;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.masspayout.resource.MassPayoutAuth;
import com.iyzipay.request.masspayout.MassPayoutAuthRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class MassPayoutAuthSample extends Sample {

    @Test
    public void should_auth_mass_payout() {
        MassPayoutAuthRequest request = new MassPayoutAuthRequest();
        request.setLocale(Locale.TR.name());
        request.setConversationId("ConversationId");
        request.setRequestId("requestId");

        MassPayoutAuth response = MassPayoutAuth.auth(request, options);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertTrue(response.getSystemTime() > 0L);
    }
}
