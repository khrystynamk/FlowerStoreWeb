package com.lab.flowerstore.decorators;

import com.lab.flowerstore.flower.Item;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) {
        super(item);
        item.setDescription("[DECORATOR TYPE]: Paper");
    }

    public double getPrice() {
        final int PRICE = 13;
        return PRICE + this.getItem().getPrice();
    }
}
