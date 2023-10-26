package com.lab7.lab7_2.filters;
import com.lab7.lab7_2.flower.Item;

public interface Filter {
    boolean match(Item item);
}