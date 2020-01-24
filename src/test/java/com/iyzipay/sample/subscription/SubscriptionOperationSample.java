package com.iyzipay.sample.subscription;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionOperation;
import com.iyzipay.model.subscription.enumtype.SubscriptionUpgradePeriod;
import com.iyzipay.request.subscription.SubscriptionOrderOperationRequest;
import com.iyzipay.request.subscription.UpgradeSubscriptionRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionOperationSample extends Sample {

    @Test
    public void should_cancel_subscription() {
        SubscriptionOperation response = SubscriptionOperation.cancel("6081cea6-fae5-45f0-9f9e-2c979259f0a7", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }

    @Test
    public void should_activate_subscription() {
        SubscriptionOperation response = SubscriptionOperation.activate("6f65af3c-030f-45cc-bc7f-4d05be7f066c", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }

    @Test
    public void should_upgrade_subscription() {
        UpgradeSubscriptionRequest upgradeSubscriptionRequest = new UpgradeSubscriptionRequest();
        upgradeSubscriptionRequest.setNewPricingPlanReferenceCode("23893e87-ef29-4b96-936f-e50ffce1f362");
        upgradeSubscriptionRequest.setResetRecurrenceCount(true);
        upgradeSubscriptionRequest.setUpgradePeriod(SubscriptionUpgradePeriod.NOW.name());
        upgradeSubscriptionRequest.setUseTrial(true);
        upgradeSubscriptionRequest.setConversationId("1234356");
        upgradeSubscriptionRequest.setLocale(Locale.TR.name());

        SubscriptionOperation response = SubscriptionOperation.upgrade("6f65af3c-030f-45cc-bc7f-4d05be7f066c", upgradeSubscriptionRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }

    @Test
    public void should_retry_payment() {
        SubscriptionOrderOperationRequest subscriptionOrderOperationRequest = new SubscriptionOrderOperationRequest();
        subscriptionOrderOperationRequest.setReferenceCode("cd6fa908-42af-47e6-9eef-5311fd2b9b32");
        subscriptionOrderOperationRequest.setConversationId("123456");
        subscriptionOrderOperationRequest.setLocale(Locale.TR.name());

        SubscriptionOperation response = SubscriptionOperation.retryPayment(subscriptionOrderOperationRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}