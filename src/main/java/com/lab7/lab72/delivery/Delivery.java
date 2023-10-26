package com.lab7.lab72.delivery;
import java.util.List;

import com.lab7.lab72.flower.Item;

public interface Delivery {
    String deliver(List<Item> items);
}