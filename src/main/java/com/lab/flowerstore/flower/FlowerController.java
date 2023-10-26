package com.lab.flowerstore.flower;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flower")
public class FlowerController {
    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping("/")
    public List<Flower> flower() {
        final double SEPALLENGTH = 45.0;
        final double PRICE = 40.0;
        final int ID = 1;
        return List.of(new Flower(ID, SEPALLENGTH, PRICE,
                 FlowerColor.PINK, FlowerType.TULIP));
    }

    @GetMapping("/list")
    public List<Flower> listFlower() {
        return flowerService.getFlowers();
    }
}
