package com.lab.flowerstore;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.lab.flowerstore.payment.
        CreditCardPaymentStrategy;
import com.lab.flowerstore.payment.
        PayPalPaymentStrategy;
import com.lab.flowerstore.payment.
        Payment;

public class PaymentTests {
    private Payment creditCardPay;
    private Payment payPal;
    private double price;
    private double zeroPrice;

    @BeforeEach
    public void init() {
        creditCardPay = new CreditCardPaymentStrategy();
        payPal = new PayPalPaymentStrategy();
        price = 100.0;
        zeroPrice = 0.0;
    }

    @Test
    public void testCreditCardPaymentNonZero() {
        String paidByCard = creditCardPay.pay(price);
        assertTrue(paidByCard.contains("Paying 100.0 via credit card..."));
    }

    @Test
    public void testPayPalPaymentNonZero() {
        String paidByPayPal = payPal.pay(price);
        assertTrue(paidByPayPal.contains("Paying 100.0 via PayPal..."));
    }

    @Test
    public void testPayPalPaymentZero() {
        String paidByPayPal = payPal.pay(zeroPrice);
        assertFalse(paidByPayPal.contains("You have not purchased anything"));
    }

    @Test
    public void testCreditCardPaymentZero() {
        String paidByCard = creditCardPay.pay(zeroPrice);
        assertFalse(paidByCard.contains("You have not purchased anything"));
    }
}