package com.lab7.lab72.flower;

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
		final double sepalLength = 45.0;
		final double price = 40.0;
		final int id = 1;
		return List.of(new Flower(id, sepalLength, price, FlowerColor.PINK, FlowerType.TULIP));
	}

	@Autowired
	public FlowerController(FlowerService flowerService) {
		this.flowerService = flowerService;
	}

	@GetMapping("/list")
	public List<Flower> listFlower() {
		return flowerService.getFlowers();
	}
}
