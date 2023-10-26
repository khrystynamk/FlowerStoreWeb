package com.lab7.lab72.delivery;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab7.lab72.flower.Flower;
import com.lab7.lab72.flower.FlowerColor;
import com.lab7.lab72.flower.FlowerType;


@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    DHLDeliveryStrategy dhlDelivery = new DHLDeliveryStrategy();
    PostDeliveryStrategy postDelivery = new PostDeliveryStrategy();

    @GetMapping("/")
	public List< ? > delivery() {
		return List.of(dhlDelivery.getClass().getSimpleName(),
				postDelivery.getClass().getSimpleName());
	}

	@GetMapping("/post")
	public String dhl() {
		final double sepalLength = 45.0;
		final double price = 40.0;
		final int id = 1;
		return postDelivery.deliver(List.of(new Flower(id, sepalLength,
				price, FlowerColor.PINK, FlowerType.TULIP)));
	}

	@GetMapping("/dhl")
	public String post() {
		final double sepalLength = 45.0;
		final double price = 40.0;
		final int id = 1;
		return dhlDelivery.deliver(List.of(new Flower(id, sepalLength,
				price, FlowerColor.PINK, FlowerType.TULIP)));
	}
}
// delivery - page with listed delivery methods
// delivery/DHL - page of DHL delivery
// delivery/post - page of post delivery