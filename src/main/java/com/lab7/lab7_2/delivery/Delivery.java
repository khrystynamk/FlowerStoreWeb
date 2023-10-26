package com.lab7.lab7_2.delivery;
import java.util.List;
import com.lab7.lab7_2.flower.Item;

public interface Delivery {
    String deliver(List<Item> items);
}