package com.example.retrofit;
import com.example.retrofit.Controller.RetrofitController;
import com.example.retrofit.Controller.RetrofitPostController;
import com.example.retrofit.Controller.RetrofitPostRegistrationController;
import com.example.retrofit.DTO.PostDataResponse;
import com.example.retrofit.DTO.RegisterDTO;
import com.example.retrofit.DTO.RegisterResponse;
import com.example.retrofit.DTO.SingleUserResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import retrofit2.Call;

import java.util.concurrent.CompletableFuture;

public class RetrofitTest {

    @Test
    public void singleUserTest() {
        SoftAssert softAssert = new SoftAssert();

        RetrofitController retrofitController = new RetrofitController();
        CompletableFuture<SingleUserResponse> future = retrofitController.start();

        try {
            SingleUserResponse singleUserResponse = future.get();
            //softAssert.assertEquals(singleUserResponse.hasNullFields(), false);
            softAssert.assertNotEquals(singleUserResponse.getData(), null);
            softAssert.assertNotEquals(singleUserResponse.getSupport(), null);
            softAssert.assertNotEquals(singleUserResponse.getData().getId(), null);
            softAssert.assertNotEquals(singleUserResponse.getData().getEmail(), null);
            softAssert.assertNotEquals(singleUserResponse.getData().getFirst_name(), null);
            softAssert.assertNotEquals(singleUserResponse.getData().getLast_name(), null);
            softAssert.assertNotEquals(singleUserResponse.getData().getAvatar(), null);
            softAssert.assertNotEquals(singleUserResponse.getSupport().getUrl(), null);
            softAssert.assertNotEquals(singleUserResponse.getSupport().getText(), null);
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void postDataTest() {
        SoftAssert softAssert = new SoftAssert();
        RetrofitPostController retrofitPostController = new RetrofitPostController();
        CompletableFuture<PostDataResponse> future = retrofitPostController.start();
        try {
            PostDataResponse postDataResponse = future.get();
            softAssert.assertNotEquals(postDataResponse.getId(), null);
            softAssert.assertNotEquals(postDataResponse.getJob(), null);
            softAssert.assertNotEquals(postDataResponse.getName(), null);
            softAssert.assertNotEquals(postDataResponse.getCreatedAt(), null);
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void registerTest() {
        SoftAssert softAssert = new SoftAssert();
        RetrofitPostRegistrationController registrationController = new RetrofitPostRegistrationController();

        CompletableFuture<RegisterResponse> future = registrationController.start(new RegisterDTO("eve.holt@reqres.in","pistol"));
        try {
            RegisterResponse registerResponse = future.get();;
            softAssert.assertNotEquals(registerResponse.getId(), null);
            softAssert.assertNotEquals(registerResponse.getToken(), null);
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
