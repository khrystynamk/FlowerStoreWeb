package com.lab7.lab7_2.payment;

public class CreditCardPaymentStrategy implements Payment {
    public String pay(double price) {
        return "Paying " + price + " via credit card...";
    }
}
