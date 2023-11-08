package com.lab.flowerstore.payment;

public class CreditCardPaymentStrategy implements Payment {
    public String pay(double price) {
        if (price > 0.0) {
            return "Paying " + price + " via credit card...";
        }
        return "You have not purchased anything";
    }
}
