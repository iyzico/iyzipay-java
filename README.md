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
  <version>1.1.18</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.iyzipay:iyzipay-java:1.1.18"
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
   
   PaymentAuth paymentAuth = PaymentAuth.create(request, options);
}
```
See other samples under src/test/java/com/iyzipay/model/sample package.

Testing
=======

You must have Maven installed. You can run particular sample by passing `-D test=Class#method`. For example:

    mvn test -Dtest=PaymentAuthSample -DbaseUrl=https://stg.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey
    mvn test -Dtest=PaymentAuthSample#should_create_payment_with_physical_and_virtual_item_for_market_place -DbaseUrl=https://stg.iyzipay.com -DapiKey=yourApiKey -DsecretKey=yourSecretKey