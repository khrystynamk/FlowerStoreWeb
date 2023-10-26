package com.lab7.lab72.flower;

import lombok.Getter;

public abstract class Item {
    @Getter
    private String description;
    public abstract double getPrice();
}