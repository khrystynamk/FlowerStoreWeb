package com.lab.flowerstore.payment;

public class CreditCardPaymentStrategy implements Payment {
    public String pay(double price) {
        return "Paying " + price + " via credit card...";
    }
}
