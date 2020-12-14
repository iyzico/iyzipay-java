# iyzipay-java

[![Build Status](https://travis-ci.org/iyzico/iyzipay-java.svg?branch=master)](https://travis-ci.org/iyzico/iyzipay-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.iyzipay/iyzipay-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.iyzipay/iyzipay-java/)

You can sign up for an iyzico account at https://iyzico.com

# Requirements

Java 1.7 or newer

# Installation

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.iyzipay</groupId>
  <artifactId>iyzipay-java</artifactId>
  <version>2.0.71</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.iyzipay:iyzipay-java:2.0.71"
```

### Others

You'll need to manually install the following JARs:

* The iyzipay JAR from https://github.com/iyzico/iyzipay-java/releases/latest
* Gson 2.5 from http://mvnrepository.com/artifact/com.google.code.gson/gson/2.5
* Commons lang 3.4 from http://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.4

If you want to run samples you'll need to manually install Junit JAR:

* JUnit 4.12 from http://mvnrepository.com/artifact/junit/junit/4.12

### Build

If you don't have Maven installed in your local environment, you can use Maven Wrapper script:

    ./mvnw clean install

# Usage

```java
Options options = new Options();
options.setApiKey("your api key");
options.setSecretKey("your secret key");
options.setBaseUrl("https://sandbox-api.iyzipay.com");

CreatePaymentRequest request = new CreatePaymentRequest();
request.setLocale(Locale.TR.getValue());
request.setConversationId("123456789");
request.setPrice(new BigDecimal("1"));
request.setPaidPrice(new BigDecimal("1.2"));
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
basketItems.add(firstBasketItem);

BasketItem secondBasketItem = new BasketItem();
secondBasketItem.setId("BI102");
secondBasketItem.setName("Game code");
secondBasketItem.setCategory1("Game");
secondBasketItem.setCategory2("Online Game Items");
secondBasketItem.setItemType(BasketItemType.VIRTUAL.name());
secondBasketItem.setPrice(new BigDecimal("0.5"));
basketItems.add(secondBasketItem);

BasketItem thirdBasketItem = new BasketItem();
thirdBasketItem.setId("BI103");
thirdBasketItem.setName("Usb");
thirdBasketItem.setCategory1("Electronics");
thirdBasketItem.setCategory2("Usb / Cable");
thirdBasketItem.setItemType(BasketItemType.PHYSICAL.name());
thirdBasketItem.setPrice(new BigDecimal("0.2"));
basketItems.add(thirdBasketItem);
request.setBasketItems(basketItems);

Payment payment = Payment.create(request, options);
```
See other samples under src/test/java/com/iyzipay/sample package.

### Mock test cards

Test cards that can be used to simulate a *successful* payment:

Card Number      | Bank                       | Card Type
-----------      | ----                       | ---------
5890040000000016 | Akbank                     | Master Card (Debit)
5526080000000006 | Akbank                     | Master Card (Credit)
4766620000000001 | Denizbank                  | Visa (Debit)
4603450000000000 | Denizbank                  | Visa (Credit)
4729150000000005 | Denizbank Bonus            | Visa (Credit)
4987490000000002 | Finansbank                 | Visa (Debit)
5311570000000005 | Finansbank                 | Master Card (Credit)
9792020000000001 | Finansbank                 | Troy (Debit)
9792030000000000 | Finansbank                 | Troy (Credit)
5170410000000004 | Garanti Bankası            | Master Card (Debit)
5400360000000003 | Garanti Bankası            | Master Card (Credit)
374427000000003  | Garanti Bankası            | American Express
4475050000000003 | Halkbank                   | Visa (Debit)
5528790000000008 | Halkbank                   | Master Card (Credit)
4059030000000009 | HSBC Bank                  | Visa (Debit)
5504720000000003 | HSBC Bank                  | Master Card (Credit)
5892830000000000 | Türkiye İş Bankası         | Master Card (Debit)
4543590000000006 | Türkiye İş Bankası         | Visa (Credit)
4910050000000006 | Vakıfbank                  | Visa (Debit)
4157920000000002 | Vakıfbank                  | Visa (Credit)
5168880000000002 | Yapı ve Kredi Bankası      | Master Card (Debit)
5451030000000000 | Yapı ve Kredi Bankası      | Master Card (Credit)

*Cross border* test cards:

Card Number      | Country
-----------      | -------
4054180000000007 | Non-Turkish (Debit)
5400010000000004 | Non-Turkish (Credit)

Test cards to get specific *error* codes:

Card Number       | Description
-----------       | -----------
5406670000000009  | Success but cannot be cancelled, refund or post auth
4111111111111129  | Not sufficient funds
4129111111111111  | Do not honour
4128111111111112  | Invalid transaction
4127111111111113  | Lost card
4126111111111114  | Stolen card
4125111111111115  | Expired card
4124111111111116  | Invalid cvc2
4123111111111117  | Not permitted to card holder
4122111111111118  | Not permitted to terminal
4121111111111119  | Fraud suspect
4130111111111118  | General error
4131111111111117  | Success but mdStatus is 0
4141111111111115  | Success but mdStatus is 4
4151111111111112  | 3dsecure initialize failed
4151111111111393  | Restricted for online transactions

# Testing

If you have Maven installed, you can run particular sample by passing `-Dtest=Class#method`. For example:

    mvn test -Dtest=PaymentSample -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey
    mvn test -Dtest=PaymentSample#should_create_payment -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey

If you don't have Maven installed, you can also run:

    ./mvnw test -Dtest=PaymentSample -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey
    ./mvnw test -Dtest=PaymentSample#should_create_payment -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey

### Mock APM Accounts

Mock APM Accounts that can be used to simulate a payment with alternative payment method:

Account Holder Name     | Description
-------------------     | -----------
success                 | Succeeded payment after succeeded initialize
fail-after-init         | Failed payment after succeeded initialize
error                   | Failed initialize

# Testing

If you have Maven installed, you can run particular sample by passing `-Dtest=Class#method`. For example:

    mvn test -Dtest=ApmSample -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey
    mvn test -Dtest=ApmSample#should_initialize_apm_payment -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey

If you don't have Maven installed, you can also run:

    ./mvnw test -Dtest=ApmSample -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey
    ./mvnw test -Dtest=ApmSample#should_initialize_apm_payment -DbaseUrl=https://sandbox-api.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey
