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
    private final double PRICE = 100.0;
    @Getter
    private final double ZEROPRICE = 0.0;

    @BeforeEach
    public void init() {
        creditCardPay = new CreditCardPaymentStrategy();
        payPal = new PayPalPaymentStrategy();
    }

    @Test
    public void testCreditCardPaymentNonZero() {
        String paidByCard = creditCardPay.pay(PRICE);
        Assertions.assertTrue(paidByCard.contains(
                        "Paying 100.0 via credit card..."
                        ));
    }

    @Test
    public void testPayPalPaymentNonZero() {
        String paidByPayPal = payPal.pay(PRICE);
        Assertions.assertTrue(paidByPayPal.contains(
                        "Paying 100.0 via PayPal..."
                        ));
    }

    @Test
    public void testPayPalPaymentZero() {
        String paidByPayPal = payPal.pay(ZEROPRICE);
        Assertions.assertFalse(paidByPayPal.contains(
                        "You have not purchased anything"
                        ));
    }

    @Test
    public void testCreditCardPaymentZero() {
        String paidByCard = creditCardPay.pay(ZEROPRICE);
        Assertions.assertFalse(paidByCard.contains(
                        "You have not purchased anything"
                        ));
    }
}