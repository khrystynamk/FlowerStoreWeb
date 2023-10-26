package com.lab.flowerstore.order;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.flowerstore.delivery.DHLDeliveryStrategy;
import com.lab.flowerstore.delivery.Delivery;
import com.lab.flowerstore.flower.Flower;
import com.lab.flowerstore.flower.FlowerColor;
import com.lab.flowerstore.flower.FlowerType;
import com.lab.flowerstore.flower.Item;
import com.lab.flowerstore.payment.PayPalPaymentStrategy;
import com.lab.flowerstore.payment.Payment;

@RestController
@RequestMapping
public class OrderController {
    final int id1 = 1;
    final double sepalLength1 = 45.0;
    final double price1 = 40.0;

    private Order<Item> order = new Order<>(new PayPalPaymentStrategy(),
         new DHLDeliveryStrategy(),
         List.of(new Flower(id1, sepalLength1, price1,
         FlowerColor.PINK, FlowerType.TULIP),
         new Flower(id1, sepalLength1, price1,
         FlowerColor.RED, FlowerType.ROSE)));

    @GetMapping("api/order/show-order")
    public String showOrder() {
        return order.processOrder();
    }

    @PostMapping("/api/order/pay")
    public void choosePayment(@RequestBody Payment payment) {
        order.setPaymentStrategy(payment);
    }

    @PostMapping("/api/order/deliver")
    public void chooseDelivery(@RequestBody Delivery delivery) {
        order.setDeliveryStrategy(delivery);
    }
}