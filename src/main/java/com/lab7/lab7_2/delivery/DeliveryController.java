package com.lab7.lab7_2.delivery;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab7.lab7_2.flower.Flower;
import com.lab7.lab7_2.flower.FlowerColor;
import com.lab7.lab7_2.flower.FlowerType;


@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    DHLDeliveryStrategy dhlDelivery = new DHLDeliveryStrategy();
    PostDeliveryStrategy postDelivery = new PostDeliveryStrategy();

    @GetMapping("/")
	public List<?> delivery() {
		return List.of(dhlDelivery.getClass().getSimpleName(), postDelivery.getClass().getSimpleName());
	}

	@GetMapping("/post")
	public String dhl() {
		return postDelivery.deliver(List.of(new Flower(1, 45.0, 40.0, FlowerColor.PINK, FlowerType.TULIP)));
	}

	@GetMapping("/dhl")
	public String post() {
		return dhlDelivery.deliver(List.of(new Flower(1, 45.0, 40.0, FlowerColor.PINK, FlowerType.TULIP)));
	}
}
// delivery - page with listed delivery methods
// delivery/DHL - page of DHL delivery
// delivery/post - page of post delivery