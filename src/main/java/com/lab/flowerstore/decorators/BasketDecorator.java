package com.lab.flowerstore.decorators;

import com.lab.flowerstore.flower.Item;

public class BasketDecorator extends ItemDecorator {
    public BasketDecorator(Item item) {
        super(item);
        item.setDescription("[DECORATOR TYPE]: Basket");
    }

    public double getPrice() {
        final int PRICE = 4;
        return PRICE + this.getItem().getPrice();
    }
}
