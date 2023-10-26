package com.lab7.lab7_2.payment;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    PayPalPaymentStrategy payPal = new PayPalPaymentStrategy();
    CreditCardPaymentStrategy creditCard = new CreditCardPaymentStrategy();

    @GetMapping("/")
	public List<?> payment() {
		return List.of(creditCard.getClass().getSimpleName(), payPal.getClass().getSimpleName());
	}

	@GetMapping("/paypal")
	public String paypal() {
		return payPal.pay(40.0);
	}

	@GetMapping("/creditcard")
	public String creditcard() {
		return creditCard.pay(40.0);
	}
}
// payment - page with listed payment methods
// payment/paypal - page of paypal payment
// payment/creditcard - page of creditcard payment
