package com.lab7.lab72.payment;

public class CreditCardPaymentStrategy implements Payment {
    public String pay(double price) {
        return "Paying " + price + " via credit card...";
    }
}
