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
	private CreditCardPaymentStrategy creditCard = new CreditCardPaymentStrategy();

	@GetMapping("/")
	public List < ? > payment() {
		return List.of(creditCard.getClass().getSimpleName(),
			 payPal.getClass().getSimpleName());
	}

	@GetMapping("/paypal")
	public String paypal() {
		final double price1 = 40.0;
		return payPal.pay(price1);
	}

	@GetMapping("/creditcard")
	public String creditcard() {
		final double price2 = 40.0;
		return creditCard.pay(price2);
	}
}
// payment - page with listed payment methods
// payment/paypal - page of paypal payment
// payment/creditcard - page of creditcard payment
