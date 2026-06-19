package com.iyzipay.sample.masspayout;

import com.iyzipay.model.masspayout.Amount;
import com.iyzipay.model.Locale;
import com.iyzipay.model.masspayout.MassPayoutItem;
import com.iyzipay.model.Status;
import com.iyzipay.model.masspayout.resource.MassPayoutInit;
import com.iyzipay.request.masspayout.MassPayoutInitRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MassPayoutInitSample extends Sample {

    @Test
    public void should_init_mass_payout() {
        MassPayoutItem item = new MassPayoutItem();
        item.setDescription("description");
        item.setRecipientInfo("TR1234567891212");
        item.setRecipientName("John Doe");
        item.setRecipientType("IBAN");
        item.setItemExternalId("itemExternalId");
        item.setAmount(createAmount("TRY", BigDecimal.ONE));

        List<MassPayoutItem> items = new ArrayList<>();
        items.add(item);

        MassPayoutInitRequest request = new MassPayoutInitRequest();
        request.setLocale(Locale.TR.name());
        request.setConversationId("123456789");
        request.setExternalId(UUID.randomUUID().toString());
        request.setPurpose("SALARY");
        request.setItems(items);

        MassPayoutInit response = MassPayoutInit.init(request, options);

        System.out.println("MassPayoutInit Response: " + response);

        assertNotNull(response);
        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals("123456789", response.getConversationId());
        assertNotNull(response.getRequestId());
        assertNotNull(response.getInvalidItems());
        assertTrue(response.getInvalidItems().isEmpty());
    }

    private Amount createAmount(String aTry, BigDecimal one) {
        Amount amount = new Amount();
        amount.setCurrency(aTry);
        amount.setValue(one);
        return amount;
    }
}
