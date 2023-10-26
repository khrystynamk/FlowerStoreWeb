package com.lab7.lab72.flower;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Entity // Create a table of flowers
public class Flower extends Item {
    @Id
    private Integer id;
    @Getter
    private double sepalLength;
    @Setter
    private double price;
    private FlowerColor color;
    @Getter
    private FlowerType flowerType;

    public Flower(Flower flower) {

        this.price = flower.price;
        this.sepalLength = flower.sepalLength;
        this.flowerType = flower.flowerType;
        this.color = flower.color;
    }
    
    public String getColor() {
        return color.toString();
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return this.toString();
    }
}
