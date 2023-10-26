package com.lab7.lab7_2.store;

import java.util.ArrayList;
import java.util.List;

import com.lab7.lab7_2.flower.Flower;
import com.lab7.lab7_2.flower.FlowerColor;
import com.lab7.lab7_2.flower.FlowerType;
import com.lab7.lab7_2.flower.Item;
import lombok.Getter;
import lombok.Setter;
import com.lab7.lab7_2.filters.Filter;
import com.lab7.lab7_2.filters.FlowerFilter;

public class Store {
    @Getter @Setter
    private List<Item> items;
    public List<Item> search(Filter filter) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (filter.match(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public static void main(String[] args) {
        final double MIN_PRICE = 25.0;
        final double MAX_PRICE = 70.0;
        Store store = new Store();
        FlowerFilter filter = new FlowerFilter(FlowerColor.RED,
                                                FlowerType.ROSE,
                                                MIN_PRICE,
                                                MAX_PRICE);

        final double[] PRICES = {25.0, 50.0, 65.0};
        final double[] LENGTHS = {15.0, 20.0, 25.0};

        store.setItems(new ArrayList<>());
        store.items.add(new Flower(1, LENGTHS[0], PRICES[0],
                        FlowerColor.PINK, FlowerType.TULIP));
        store.items.add(new Flower(2, LENGTHS[1], PRICES[1],
                        FlowerColor.PINK, FlowerType.ROSE));
        store.items.add(new Flower(3, LENGTHS[2], PRICES[2],
                        FlowerColor.RED, FlowerType.ROSE));

        List<Item> foundItems = store.search(filter);
        for (Item item : foundItems) {
            System.out.println("Found item: " + item);
        }
    }
}
