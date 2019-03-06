package com.masterfood.masterfoodapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "com.wirelabs", "com.masterfood"
})
public class MasterFoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterFoodApiApplication.class, args);
    }

}
