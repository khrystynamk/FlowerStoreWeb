package com.lab7.lab7_2.flower;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlowerService{
    private FlowerRepository flowerRepository;
    public FlowerService(FlowerRepository flowerRepository){
        this.flowerRepository = flowerRepository;
    }
    // public List<Flower> getFlowers(){
    //     return List.of(new Flower(1, 40.0, 45.0, FlowerColor.PINK, FlowerType.TULIP));
    // }
    public List<Flower> getFlowers(){
        return flowerRepository.findAll();
    }

    public void add(Flower flower){
        flowerRepository.save(flower);
    }
}