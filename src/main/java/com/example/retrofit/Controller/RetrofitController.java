package com.example.retrofit.Controller;

import com.example.retrofit.DTO.SingleUserResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.retrofit.Interface.ApiService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RetrofitController implements Callback<SingleUserResponse> {

    static final String BASE_URL = "https://reqres.in";

    public CompletableFuture<SingleUserResponse> start() {
        CompletableFuture<SingleUserResponse> future = new CompletableFuture<>();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<SingleUserResponse> call = apiService.getSingleUserResponse();
        call.enqueue(new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                if (response.isSuccessful()) {
                    future.complete(response.body());
                } else {
                    future.completeExceptionally(new IOException("Error response "));
                }
            }

            @Override
            public void onFailure(Call<SingleUserResponse> call, Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
    }

    @Override
    public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
        if(response.isSuccessful()) {
            SingleUserResponse singleUserResponse = response.body();
            System.out.println(singleUserResponse);
        } else {
            System.out.println(response.errorBody());
        }

    }

    @Override
    public void onFailure(Call<SingleUserResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
