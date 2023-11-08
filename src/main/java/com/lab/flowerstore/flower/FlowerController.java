package com.lab.flowerstore.flower;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/list")
    public List<Flower> listFlower() {
        return flowerService.getFlowers();
    }

    @PostMapping(value = "/add", 
                headers = "content-type=text/json",
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Flower flower) {
        flowerService.add(flower);
    }

    // To add to a table: echo '{"id": "3",
    // "color": 1, "flowerType": 2,
    // "sepalLength": 15, "price": 900}' |
    // curl -H "Content-Type: application/json"
    // -d @- http://localhost:8080/api/flower/add
}
