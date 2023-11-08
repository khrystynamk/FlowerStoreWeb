package com.lab.flowerstore.decorators;

import com.lab.flowerstore.flower.Item;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(Item item) {
        super(item);
        item.setDescription("[DECORATOR TYPE]: Ribbon");
    }

    public double getPrice() {
        final int PRICE = 40;
        return PRICE + this.getItem().getPrice();
    }
}
