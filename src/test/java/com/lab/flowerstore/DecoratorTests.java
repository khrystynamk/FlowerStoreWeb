package com.lab.flowerstore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.lab.flowerstore.decorators.BasketDecorator;
import com.lab.flowerstore.decorators.PaperDecorator;
import com.lab.flowerstore.decorators.RibbonDecorator;
import com.lab.flowerstore.flower.Flower;
import com.lab.flowerstore.flower.FlowerBucket;
import com.lab.flowerstore.flower.FlowerColor;
import com.lab.flowerstore.flower.FlowerPack;
import com.lab.flowerstore.flower.FlowerType;

public class DecoratorTests {
    private FlowerBucket flowerBucket;
    private RibbonDecorator flowerBucketRibbon;
    private BasketDecorator flowerBucketBasket;
    private PaperDecorator flowerBucketPaper;
    private Flower flower;
    private FlowerPack flowerPack;

    @BeforeEach
    public void setUp() {
        flowerBucket = new FlowerBucket();
        final double SEPALLENGTH = 45.0;
        final double PRICE = 40.0;
        final int ID = 1;
        final int QUANTITY = 15;
        flower = new Flower(ID, SEPALLENGTH, PRICE,
                    FlowerColor.PINK, FlowerType.TULIP);
        flowerPack = new FlowerPack(flower, QUANTITY);
        flowerBucket.add(flowerPack);
        flowerBucketRibbon = new RibbonDecorator(flowerBucket);
        flowerBucketBasket = new BasketDecorator(flowerBucket);
        flowerBucketPaper = new PaperDecorator(flowerBucket);
    }

    @Test
    public void testPriceRibbon() {
        double basePrice = flowerBucket.getPrice();
        final double RIBBON = 40;
        Assertions.assertEquals(basePrice + RIBBON,
                flowerBucketRibbon.getPrice());
    }

    @Test
    public void testItemOriginalFunctionalityRibbon() {
        final double EXPECTED = 640.0;
        double decoratedFlowerBucketPrice = flowerBucketRibbon.getPrice();
        Assertions.assertEquals(EXPECTED, decoratedFlowerBucketPrice);
    }

    @Test
    public void testPriceBasket() {
        double basePrice = flowerBucket.getPrice();
        final double BASKET = 4;
        Assertions.assertEquals(basePrice + BASKET,
                flowerBucketBasket.getPrice());
    }

    @Test
    public void testItemOriginalFunctionalityBasket() {
        final double EXPECTED = 604.0;
        Assertions.assertEquals(EXPECTED,
                flowerBucketBasket.getPrice());
    }

    @Test
    public void testPricePaper() {
        double basePrice = flowerBucket.getPrice();
        final double PAPER = 13;
        Assertions.assertEquals(basePrice + PAPER,
                flowerBucketPaper.getPrice());
    }

    @Test
    public void testItemOriginalFunctionalityPaper() {
        final double EXPECTED = 613.0;
        Assertions.assertEquals(EXPECTED,
                flowerBucketPaper.getPrice());
    }
}