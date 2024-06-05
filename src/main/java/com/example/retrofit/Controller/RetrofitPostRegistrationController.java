package com.example.retrofit.Controller;


import com.example.retrofit.DTO.RegisterDTO;
import com.example.retrofit.DTO.RegisterResponse;
import com.example.retrofit.Interface.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class RetrofitPostRegistrationController implements Callback<RegisterResponse> {

    static final String BASE_URL = "https://reqres.in";

    public CompletableFuture<RegisterResponse> start(RegisterDTO registerDTO) {
        CompletableFuture<RegisterResponse> future = new CompletableFuture<>();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<RegisterResponse> call = apiService.postRegister(registerDTO);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    future.complete(response.body());
                } else {
                    future.completeExceptionally(new IOException("Error response "));
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
    }


    @Override
    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

        if (response.isSuccessful()) {
            RegisterResponse postDataResponse = response.body();
            System.out.println(postDataResponse);
        }else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<RegisterResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
