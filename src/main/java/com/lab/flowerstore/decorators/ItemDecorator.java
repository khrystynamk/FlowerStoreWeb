package com.lab.flowerstore.decorators;

import com.lab.flowerstore.flower.Item;

import lombok.Getter;

public abstract class ItemDecorator extends Item {
    @Getter
    private Item item;

    public ItemDecorator(Item source) {
        this.item = source;
    }
}
