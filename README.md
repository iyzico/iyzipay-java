# iyzipay-java

[![Build Status](https://travis-ci.org/iyzico/iyzipay-java.svg?branch=master)](https://travis-ci.org/iyzico/iyzipay-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.iyzipay/iyzipay-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.iyzipay/iyzipay-java/)

You can sign up for an iyzico account at https://iyzico.com

# Requirements

Java 1.6 or newer

# Installation

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.iyzipay</groupId>
  <artifactId>iyzipay-java</artifactId>
  <version>2.0.23</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.iyzipay:iyzipay-java:2.0.23"
```

### Others

You'll need to manually install the following JARs:

* The iyzipay JAR from https://github.com/iyzico/iyzipay-java/releases/latest
* Gson 2.5 from http://mvnrepository.com/artifact/com.google.code.gson/gson/2.5
* Commons codec 1.9 from http://mvnrepository.com/artifact/commons-codec/commons-codec/1.9
* Commons lang 3.4 from http://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.4

If you want to run samples you'll need to manually install Junit JAR:

* JUnit 4.12 from http://mvnrepository.com/artifact/junit/junit/4.12

# Usage

```java
public static void main(String[] args) {
   Options options = new Options();
   options.setApiKey("your api key");
   options.setSecretKey("your secret key");
   options.setBaseUrl("https://sandbox-api.iyzipay.com");

   CreatePaymentRequest request = new CreatePaymentRequest();
   request.setLocale(Locale.TR.getValue());
   request.setConversationId("123456789");
   request.setPrice(new BigDecimal("1"));
   request.setPaidPrice(new BigDecimal("1.1"));
   request.setCurrency(Currency.TRY.name());
   request.setInstallment(1);
   request.setBasketId("B67832");
   request.setPaymentChannel(PaymentChannel.WEB.name());
   request.setPaymentGroup(PaymentGroup.PRODUCT.name());
   
   PaymentCard paymentCard = new PaymentCard();
   paymentCard.setCardHolderName("John Doe");
   paymentCard.setCardNumber("5528790000000008");
   paymentCard.setExpireMonth("12");
   paymentCard.setExpireYear("2030");
   paymentCard.setCvc("123");
   paymentCard.setRegisterCard(0);
   request.setPaymentCard(paymentCard);
   
   Buyer buyer = new Buyer();
   buyer.setId("BY789");
   buyer.setName("John");
   buyer.setSurname("Doe");
   buyer.setGsmNumber("+905350000000");
   buyer.setEmail("email@email.com");
   buyer.setIdentityNumber("74300864791");
   buyer.setLastLoginDate("2015-10-05 12:43:35");
   buyer.setRegistrationDate("2013-04-21 15:12:09");
   buyer.setRegistrationAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
   buyer.setIp("85.34.78.112");
   buyer.setCity("Istanbul");
   buyer.setCountry("Turkey");
   buyer.setZipCode("34732");
   request.setBuyer(buyer);
   
   Address shippingAddress = new Address();
   shippingAddress.setContactName("Jane Doe");
   shippingAddress.setCity("Istanbul");
   shippingAddress.setCountry("Turkey");
   shippingAddress.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
   shippingAddress.setZipCode("34742");
   request.setShippingAddress(shippingAddress);
   
   Address billingAddress = new Address();
   billingAddress.setContactName("Jane Doe");
   billingAddress.setCity("Istanbul");
   billingAddress.setCountry("Turkey");
   billingAddress.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
   billingAddress.setZipCode("34742");
   request.setBillingAddress(billingAddress);
   
   List<BasketItem> basketItems = new ArrayList<BasketItem>();
   BasketItem firstBasketItem = new BasketItem();
   firstBasketItem.setId("BI101");
   firstBasketItem.setName("Binocular");
   firstBasketItem.setCategory1("Collectibles");
   firstBasketItem.setCategory2("Accessories");
   firstBasketItem.setItemType(BasketItemType.PHYSICAL.name());
   firstBasketItem.setPrice(new BigDecimal("0.3"));
   firstBasketItem.setSubMerchantKey("sub merchant key");
   firstBasketItem.setSubMerchantPrice(new BigDecimal("0.27"));
   basketItems.add(firstBasketItem);
   
   BasketItem secondBasketItem = new BasketItem();
   secondBasketItem.setId("BI102");
   secondBasketItem.setName("Game code");
   secondBasketItem.setCategory1("Game");
   secondBasketItem.setCategory2("Online Game Items");
   secondBasketItem.setItemType(BasketItemType.VIRTUAL.name());
   secondBasketItem.setPrice(new BigDecimal("0.5"));
   secondBasketItem.setSubMerchantKey("sub merchant key");
   secondBasketItem.setSubMerchantPrice(new BigDecimal("0.42"));
   basketItems.add(secondBasketItem);
   
   BasketItem thirdBasketItem = new BasketItem();
   thirdBasketItem.setId("BI103");
   thirdBasketItem.setName("Usb");
   thirdBasketItem.setCategory1("Electronics");
   thirdBasketItem.setCategory2("Usb / Cable");
   thirdBasketItem.setItemType(BasketItemType.PHYSICAL.name());
   thirdBasketItem.setPrice(new BigDecimal("0.2"));
   thirdBasketItem.setSubMerchantKey("sub merchant key");
   thirdBasketItem.setSubMerchantPrice(new BigDecimal("0.18"));
   basketItems.add(thirdBasketItem);
   request.setBasketItems(basketItems);
   
   Payment payment = Payment.create(request, options);
}
```
See other samples under src/test/java/com/iyzipay/model/sample package.

### Mock tests cards
Bank                       | Card Type         |  Card Number       | Card Association   | Status
-------------              | -------------     |  -----------       | ----------------   | -----------
Akbank                     | Debit             |  5890040000000016  | Master Card        | Success
Akbank                     | Credit            |  5526080000000006  | Master Card        | Success
Asya Katılım Bankası       | Debit             |  4073810000000006  | Visa               | Success
Asya Katılım Bankası       | Credit            |  5331490000000002  | Master Card        | Success
Denizbank                  | Debit             |  4766620000000001  | Visa               | Success
Denizbank                  | Credit            |  4603450000000000  | Visa               | Success
Finansbank                 | Debit             |  4987490000000002  | Visa               | Success
Finansbank                 | Credit            |  5311570000000005  | Master Card        | Success
Garanti Bankası            | Debit             |  5170410000000004  | Master Card        | Success
Garanti Bankası            | Credit            |  5400360000000003  | Master Card        | Success
Garanti Bankası            | Credit            |  374427000000003   | American Express   | Success
Halkbank                   | Debit             |  4475050000000003  | Visa               | Success
Halkbank                   | Credit            |  5528790000000008  | Master Card        | Success
HSBC Bank                  | Debit             |  4059030000000009  | Visa               | Success
HSBC Bank                  | Credit            |  5504720000000003  | Master Card        | Success
Vakıfbank                  | Debit             |  4910050000000006  | Visa               | Success
Vakıfbank                  | Credit            |  4157920000000002  | Visa               | Success
Yapı ve Kredi Bankası      | Debit             |  6390040000000001  | Master Card        | Success
Yapı ve Kredi Bankası      | Credit            |  5451030000000000  | Master Card        | Success
Parsian Bank (Shetab)      | Credit            |  6221060000000004  | Master Card        | Success
Cross Border Test          | Debit             |  5412750000000001  | Master Card        | Success
Türkiye İş Bankası         | Debit             |  5892830000000000  | Master Card        | Success
Türkiye İş Bankası         | Credit            |  4543590000000006  | Visa               | Success
Türkiye İş Bankası         | Credit            |  5406670000000009  | Master Card        | Success, but cannot be cancelled, refund or post auth
-                          | -                 |  4111111111111129  |                    | Failure, not sufficient funds
-                          | -                 |  4129111111111111  |                    | Failure, do not honour
-                          | -                 |  4128111111111112  |                    | Failure, invalid transaction
-                          | -                 |  4127111111111113  |                    | Failure, lost card
-                          | -                 |  4126111111111114  |                    | Failure, stolen card
-                          | -                 |  4125111111111115  |                    | Failure, expired card
-                          | -                 |  4124111111111116  |                    | Failure, invalid cvc2
-                          | -                 |  4123111111111117  |                    | Failure, not permitted to card holder
-                          | -                 |  4122111111111118  |                    | Failure, not permitted to terminal
-                          | -                 |  4121111111111119  |                    | Failure, fraud suspect
-                          | -                 |  4120111111111110  |                    | Failure, pickup card
-                          | -                 |  4130111111111118  |                    | Failure, general error

Testing
=======

You must have Maven installed. You can run particular sample by passing `-D test=Class#method`. For example:

    mvn test -Dtest=PaymentSample -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey
    mvn test -Dtest=PaymentSample#should_create_payment_with_physical_and_virtual_item_for_market_place -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey
