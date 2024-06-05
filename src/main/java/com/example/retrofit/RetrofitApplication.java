package com.example.retrofit;

import com.example.retrofit.Controller.RetrofitController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetrofitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetrofitApplication.class, args);
        RetrofitController controller = new RetrofitController();
        controller.start();
    }

}
