package com.example.retrofit.Interface;

import com.example.retrofit.DTO.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("/api/users/2")
    Call<SingleUserResponse> getSingleUserResponse();
    @POST("/api/users")
    Call<PostDataResponse> postDataResponse(@Body PostDataRequest postDataRequest);
    @POST("/api/register")
    Call<RegisterResponse> postRegister(@Body RegisterDTO registerDTO);
}
