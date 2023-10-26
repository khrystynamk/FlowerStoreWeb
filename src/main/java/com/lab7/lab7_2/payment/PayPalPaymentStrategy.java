package com.lab7.lab7_2.payment;

public class PayPalPaymentStrategy implements Payment {
    public String pay(double price) {
        return "Paying " + price + " via PayPal...";
    }
}
