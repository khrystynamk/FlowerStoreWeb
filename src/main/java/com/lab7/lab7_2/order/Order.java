package com.lab7.lab7_2.order;

import java.util.ArrayList;
import java.util.List;

import com.lab7.lab7_2.delivery.Delivery;
import com.lab7.lab7_2.flower.Item;
import com.lab7.lab7_2.payment.Payment;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order<Thing extends Item> {
    protected Payment payment;
    protected Delivery delivery;
    private List<Thing> items = new ArrayList<>();

    void addItem(Thing newItem) {
        items.add(newItem);
    }

    void removeItem(Thing item) {
        if (items.contains(item)){
            items.remove(item);
        }
        System.out.println("You cannot remove an item that is not in your cart!");
    }

    public String processOrder() {
        double price = calculateTotalPrice();
        String paymnt = ((payment==null)? "null" : payment.toString());
        String delivr = ((delivery==null)? "null" : delivery.toString());
        return ("Your order consists of the following items: " + items.toString() + "\n"
             + "You have chosen the following way of [PAYMENT]: " + paymnt.getClass().getSimpleName() + "\n"
             + "You have chosen the following way of [DELIVERY]: " + delivr.getClass().getSimpleName() + "\n"
             + "Total price of your order is " + price);
    }

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        double price = 0;
        for (Thing item : items) {
            price += item.getPrice();
        }
        
        return price;
    }
}
