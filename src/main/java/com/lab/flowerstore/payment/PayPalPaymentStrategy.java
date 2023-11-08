package com.lab.flowerstore.payment;

public class PayPalPaymentStrategy implements Payment {
    public String pay(double price) {
        if (price > 0.0) {
            return "Paying " + price + " via PayPal...";
        }
        return "You have not purchased anything";
    }
}
