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

import lombok.Getter;

@RestController
@RequestMapping
public class OrderController {
    @Getter
    private final int ID = 1;
    @Getter
    private final double SEPALLENGTH = 45.0;
    @Getter
    private final double PRICE = 40.0;

    private Order<Item> order = new Order<>(new PayPalPaymentStrategy(),
         new DHLDeliveryStrategy(),
         List.of(new Flower(ID, SEPALLENGTH, PRICE,
         FlowerColor.PINK, FlowerType.TULIP),
         new Flower(ID, SEPALLENGTH, PRICE,
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