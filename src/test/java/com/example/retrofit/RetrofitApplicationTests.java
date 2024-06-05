package com.example.retrofit;

import com.example.retrofit.Controller.RetrofitPostController;
import org.testng.annotations.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetrofitApplicationTests {

    @Test
    void singleUserTest() {
        RetrofitTest tests = new RetrofitTest();
        tests.singleUserTest();
    }

    @Test
    void postDataTest() {
        RetrofitTest tests = new RetrofitTest();
        tests.postDataTest();
    }
    @Test
    void registerSuccessfulTest() {
        RetrofitTest tests = new RetrofitTest();
        tests.registerTest();
    }


}
