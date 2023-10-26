package com.lab.flowerstore.flower;

import lombok.Getter;

public abstract class Item {
    @Getter
    private String description;
    public abstract double getPrice();
}