package com.vmate.thenewsapp.retrofit;

import com.vmate.thenewsapp.responce.ArticalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.vmate.thenewsapp.constanse.AppConstanse.API_KEY;

public interface APIRequest{

    @GET("top-headlines?country=in&category=business&apiKey="+API_KEY)
    Call<ArticalResponse> getTopHeadlines();
}
