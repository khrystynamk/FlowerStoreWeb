package com.lab7.lab7_2.flower;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flower")
public class FlowerController {
	private final FlowerService flowerService;

    @GetMapping("/")
	public List<Flower> flower() {
		return List.of(new Flower(1, 45.0, 40.0, FlowerColor.PINK, FlowerType.TULIP));
	}

	@Autowired
	public FlowerController(FlowerService flowerService){
		this.flowerService = flowerService;
	}

	@GetMapping("/list")
	public List<Flower> ListFlower() {
		return flowerService.getFlowers();
	}
}
