package com.lab.flowerstore.order;

import java.util.ArrayList;
import java.util.List;

import com.lab.flowerstore.delivery.Delivery;
import com.lab.flowerstore.flower.Item;
import com.lab.flowerstore.payment.Payment;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order<Thing extends Item> {
    private Payment payment;
    private Delivery delivery;
    private List<Thing> items = new ArrayList<>();

    void addItem(Thing newItem) {
        items.add(newItem);
    }

    void removeItem(Thing item) {
        if (items.contains(item)) {
            items.remove(item);
        }
    }

    public String processOrder() {
        double price = calculateTotalPrice();
        String paymnt = "null";
        String delivr = "null";

        if (payment != null) {
            paymnt = payment.toString();
        }

        if (delivery != null) {
            delivr = delivery.toString();
        }

        return ("Your order consists of the following items: " 
             + items.toString() + "\n"
             + "You have chosen the following way of [PAYMENT]: " 
             + paymnt.getClass().getSimpleName() + "\n"
             + "You have chosen the following way of [DELIVERY]: " 
             + delivr.getClass().getSimpleName() + "\n"
             + "Total price of your order is " + price);
    }

    public void setPaymentStrategy(Payment newPayment) {
        this.payment = newPayment;
    }

    public void setDeliveryStrategy(Delivery newDelivery) {
        this.delivery = newDelivery;
    }

    public double calculateTotalPrice() {
        double price = 0;
        for (Thing item : items) {
            price += item.getPrice();
        }
        
        return price;
    }
}
