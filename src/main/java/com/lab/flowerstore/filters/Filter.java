package com.lab.flowerstore.filters;
import com.lab.flowerstore.flower.Item;

public interface Filter {
    boolean match(Item item);
}