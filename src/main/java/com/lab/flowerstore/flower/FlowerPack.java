package com.lab.flowerstore.flower;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FlowerPack {
    // private static final int MAX_QUANTITY = 100;
    private Flower flower;
    @Getter
    private int quantity = 1;

    public FlowerPack(Flower flower, int quantity) {
        this.flower = new Flower(flower);
        this.setQuantity(quantity);
    }

    public double getPrice() {
        return flower.getPrice() * ((double) quantity);
    }

    public void setQuantity(int newQuantity) {
        if (newQuantity <= 0) {
            this.quantity = 1;
        }
        else {
            this.quantity = newQuantity;
        }
        // if (quantity < 1){
        //     this.quantity = quantity;
        // }
        // else if (quantity > MAX_QUANTITY){
        //     quantity = MAX_QUANTITY;
        // }
    }
}
