package com.lab.flowerstore.delivery;
import java.util.List;

import com.lab.flowerstore.flower.Item;

public interface Delivery {
    String deliver(List<Item> items);
}