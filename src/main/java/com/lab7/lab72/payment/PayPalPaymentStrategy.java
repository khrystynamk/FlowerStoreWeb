package com.lab7.lab72.payment;

public class PayPalPaymentStrategy implements Payment {
    public String pay(double price) {
        return "Paying " + price + " via PayPal...";
    }
}
