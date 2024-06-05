package com.example.retrofit.Controller;

import com.example.retrofit.DTO.PostDataRequest;
import com.example.retrofit.DTO.PostDataResponse;
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

public class RetrofitPostController implements Callback<PostDataResponse> {

    static final String BASE_URL = "https://reqres.in";

    public CompletableFuture<PostDataResponse> start() {
        CompletableFuture<PostDataResponse> future = new CompletableFuture<>();

        PostDataRequest postDataRequest = new PostDataRequest();
        postDataRequest.setName("morpheus");
        postDataRequest.setJob("leader");

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<PostDataResponse> call = apiService.postDataResponse(postDataRequest);
        call.enqueue(new Callback<PostDataResponse>() {
            @Override
            public void onResponse(Call<PostDataResponse> call, Response<PostDataResponse> response) {
                if (response.isSuccessful()) {
                    future.complete(response.body());
                } else {
                    future.completeExceptionally(new IOException("Error response "));
                }
            }

            @Override
            public void onFailure(Call<PostDataResponse> call, Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
    }


    @Override
    public void onResponse(Call<PostDataResponse> call, Response<PostDataResponse> response) {

        if (response.isSuccessful()) {
            PostDataResponse postDataResponse = response.body();
            System.out.println(postDataResponse);
        }else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<PostDataResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
