package com.lab.flowerstore.payment;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Getter
    private PayPalPaymentStrategy payPal = new PayPalPaymentStrategy();
    @Getter
    private CreditCardPaymentStrategy creditCard = 
                        new CreditCardPaymentStrategy();

    @GetMapping("/")
    public List<String> payment() {
        return List.of(creditCard.getClass().getSimpleName(),
                    payPal.getClass().getSimpleName());
    }

    @GetMapping("/paypal")
    public String paypal() {
        final double PRICE = 40.0;
        return payPal.pay(PRICE);
    }

    @GetMapping("/creditcard")
    public String creditcard() {
        final double PRICE = 40.0;
        return creditCard.pay(PRICE);
    }
}
// payment - page with listed payment methods
// payment/paypal - page of paypal payment
// payment/creditcard - page of creditcard payment
