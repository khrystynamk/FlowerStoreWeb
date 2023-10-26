package com.lab.flowerstore.payment;

public class PayPalPaymentStrategy implements Payment {
    public String pay(double price) {
        return "Paying " + price + " via PayPal...";
    }
}
