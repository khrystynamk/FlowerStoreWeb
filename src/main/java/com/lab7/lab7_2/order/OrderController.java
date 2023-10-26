package com.lab7.lab7_2.order;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab7.lab7_2.payment.PayPalPaymentStrategy;
import com.lab7.lab7_2.payment.Payment;
import com.lab7.lab7_2.delivery.Delivery;
import com.lab7.lab7_2.delivery.DHLDeliveryStrategy;
import com.lab7.lab7_2.flower.Item;
import com.lab7.lab7_2.flower.Flower;
import com.lab7.lab7_2.flower.FlowerColor;
import com.lab7.lab7_2.flower.FlowerType;

@RestController
@RequestMapping
public class OrderController {
    private Order<Item> order = new Order<>(new PayPalPaymentStrategy(), new DHLDeliveryStrategy(), List.of(new Flower(1, 45.0, 40.0, FlowerColor.PINK, FlowerType.TULIP), new Flower(2, 60.0, 70.0, FlowerColor.RED, FlowerType.ROSE)));
    @GetMapping("api/order/show-order")
    public String showOrder(){
        return order.processOrder();
    }

    @PostMapping("/api/order/pay")
    public void choosePayment(@RequestBody Payment payment){
        order.setPaymentStrategy(payment);
    }

    @PostMapping("/api/order/deliver")
    public void chooseDelivery(@RequestBody Delivery delivery){
        order.setDeliveryStrategy(delivery);
    }
}