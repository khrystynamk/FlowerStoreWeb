package com.lab.flowerstore.flower;

import lombok.Getter;
import lombok.Setter;

public abstract class Item {
    @Getter @Setter
    private String description;
    public abstract double getPrice();
}