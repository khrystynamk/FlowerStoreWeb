package com.lab.flowerstore;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.lab.flowerstore.payment.
        CreditCardPaymentStrategy;
import com.lab.flowerstore.payment.
        PayPalPaymentStrategy;
import com.lab.flowerstore.payment.
        Payment;

import lombok.Getter;

public class PaymentTests {
    private Payment creditCardPay;
    private Payment payPal;
    @Getter
    private final double price = 100.0;
    @Getter
    private final double zeroPrice = 0.0;

    @BeforeEach
    public void init() {
        creditCardPay = new CreditCardPaymentStrategy();
        payPal = new PayPalPaymentStrategy();
    }

    @Test
    public void testCreditCardPaymentNonZero() {
        String paidByCard = creditCardPay.pay(price);
        Assertions.assertTrue(paidByCard.contains(
                        "Paying 100.0 via credit card..."
                        ));
    }

    @Test
    public void testPayPalPaymentNonZero() {
        String paidByPayPal = payPal.pay(price);
        Assertions.assertTrue(paidByPayPal.contains(
                        "Paying 100.0 via PayPal..."
                        ));
    }

    @Test
    public void testPayPalPaymentZero() {
        String paidByPayPal = payPal.pay(zeroPrice);
        Assertions.assertTrue(paidByPayPal.contains(
                        "You have not purchased anything"
                        ));
    }

    @Test
    public void testCreditCardPaymentZero() {
        String paidByCard = creditCardPay.pay(zeroPrice);
        Assertions.assertTrue(paidByCard.contains(
                        "You have not purchased anything"
                        ));
    }
}