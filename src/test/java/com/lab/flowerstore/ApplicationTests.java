package com.lab.flowerstore;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lab.flowerstore.flower.FlowerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FlowerRepository.class})
class ApplicationTests {
    @Test
    void contextLoads() {
    }
}
