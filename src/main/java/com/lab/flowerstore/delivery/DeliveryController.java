package com.lab.flowerstore.delivery;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.flowerstore.flower.FlowerColor;
import com.lab.flowerstore.flower.FlowerType;

import lombok.Getter;

import com.lab.flowerstore.flower.Flower;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    @Getter
    private DHLDeliveryStrategy dhlDelivery = new DHLDeliveryStrategy();
    @Getter
    private PostDeliveryStrategy postDelivery = new PostDeliveryStrategy();

    @GetMapping("/")
    public List<?> delivery() {
        return List.of(dhlDelivery.getClass().getSimpleName(),
                postDelivery.getClass().getSimpleName());
    }

    @GetMapping("/post")
    public String dhl() {
        final double SEPALLENGTH = 45.0;
        final double PRICE = 40.0;
        final int ID = 1;
        return postDelivery.deliver(List.of(new Flower(ID, SEPALLENGTH, PRICE, FlowerColor.PINK, FlowerType.TULIP)));
    }

    @GetMapping("/dhl")
    public String post() {
        final double SEPALLENGTH = 45.0;
        final double PRICE = 40.0;
        final int ID = 1;
        return dhlDelivery.deliver(List.of(new Flower(ID, SEPALLENGTH, PRICE, FlowerColor.PINK, FlowerType.TULIP)));
    }
}
// delivery - page with listed delivery methods
// delivery/DHL - page of DHL delivery
// delivery/post - page of post delivery