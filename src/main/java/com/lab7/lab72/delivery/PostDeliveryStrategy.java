package com.lab7.lab72.delivery;

import java.util.List;

import com.lab7.lab72.flower.Item;

public class PostDeliveryStrategy implements Delivery {
    public String deliver(List<Item> items) {
        return ("Your order consists of the following items "
             + items.toString() + "\n" 
             +  "The post delivery is in progress...");
    }
}
