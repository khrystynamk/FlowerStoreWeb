package com.lab7.lab72.flower;


import java.util.ArrayList;
import java.util.List;

public class FlowerBucket extends Item {
    private List<FlowerPack> flowerBouquet = new ArrayList<>();

    public void add(FlowerPack flowerPack) {
        flowerBouquet.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack : flowerBouquet) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    public String getDescription() {
        return this.toString();
    }
}
