# iyzipay-java

You can sign up for an iyzico account at https://iyzico.com

# Requirements

Java 1.6 or newer

# Usage

```java
public static void main(String[] args) {
   Options options = new Options();
   options.setApiKey("your api key");
   options.setSecretKey("your secret key");
   options.setBaseUrl("https://stg.iyzipay.com");

   CreatePaymentRequest request = new CreatePaymentRequest();
   request.setLocale(Locale.TR.getValue());
   request.setConversationId("123456789");
   request.setPrice(new BigDecimal("1"));
   request.setPaidPrice(new BigDecimal("1.1"));
   request.setInstallment(1);
   request.setBasketId("B67832");
   request.setPaymentChannel(PaymentChannel.WEB.name());
   request.setPaymentGroup(PaymentGroup.PRODUCT.name());

   PaymentCard paymentCard = new PaymentCard();
   paymentCard.setCardHolderName("John Doe");
   paymentCard.setCardNumber("****************");
   paymentCard.setRegisterCard(0);
   paymentCard.setExpireMonth("12");
   paymentCard.setExpireYear("2019");
   paymentCard.setCvc("123");
   request.setPaymentCard(paymentCard);

   Buyer buyer = new Buyer();
   buyer.setId("BY789");
   buyer.setName("Sabri Onur");
   buyer.setSurname("Tüzün");
   buyer.setGsmNumber("+905350000000");
   buyer.setEmail("email@email.com");
   buyer.setIdentityNumber("74300864791");
   buyer.setLastLoginDate("2015-10-05 12:43:35");
   buyer.setRegistrationDate("2013-04-21 15:12:09");
   buyer.setRegistrationAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy");
   buyer.setIp("85.34.78.112");
   buyer.setCity("İstanbul");
   buyer.setCountry("Türkiye");
   buyer.setZipCode("34732");
   request.setBuyer(buyer);

   Address shippingAddress = new Address();
   shippingAddress.setContactName("Hakan Erdoğan");
   shippingAddress.setCity("İstanbul");
   shippingAddress.setCountry("Türkiye");
   shippingAddress.setAddress("19 Mayıs Mah. İnönü Cad. No:45 Kozyatağı");
   shippingAddress.setZipCode("34742");
   request.setShippingAddress(shippingAddress);

   Address billingAddress = new Address();
   billingAddress.setContactName("Hakan Erdoğan");
   billingAddress.setCity("İstanbul");
   billingAddress.setCountry("Türkiye");
   billingAddress.setAddress("19 Mayıs Mah. İnönü Cad. No:45 Kozyatağı");
   billingAddress.setZipCode("34742");
   request.setBillingAddress(billingAddress);

   List<BasketItem> basketItems = new ArrayList<BasketItem>();
   BasketItem basketItem1 = new BasketItem();
   basketItem1.setId("BI101");
   basketItem1.setName("ABC Marka Kolye");
   basketItem1.setCategory1("Giyim");
   basketItem1.setCategory2("Aksesuar");
   basketItem1.setItemType(BasketItemType.PHYSICAL.name());
   basketItem1.setPrice(new BigDecimal("0.3"));
   basketItem1.setSubMerchantKey("subMerchantKey");
   basketItem1.setSubMerchantPrice(new BigDecimal("0.27"));
   basketItems.add(basketItem1);

   PaymentAuth paymentAuth = PaymentAuth.create(request, options);
}
```
See other samples under src/test/java/com/iyzipay/model/sample package.