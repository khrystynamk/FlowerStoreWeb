package com.lab7.lab72.filters;
import com.lab7.lab72.flower.Item;

public interface Filter {
    boolean match(Item item);
}