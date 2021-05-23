package com.vmate.thenewsapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vmate.thenewsapp.responce.ArticalResponse;
import com.vmate.thenewsapp.retrofit.APIRequest;
import com.vmate.thenewsapp.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticalRepository {

    private static final String TAG = ArticalRepository.class.getSimpleName();
    private final APIRequest apiRequest;


    public ArticalRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(APIRequest.class);
    }

   public LiveData<ArticalResponse> getItemResponse() {
        final MutableLiveData<ArticalResponse> data = new MutableLiveData<>();
        apiRequest.getTopHeadlines()
                .enqueue(new Callback<ArticalResponse>() {
                    @Override
                    public void onResponse(Call<ArticalResponse> call, Response<ArticalResponse> response) {
                     if (response.body()!=null){
                         data.setValue(response.body());
                     }

                    }

                    @Override
                    public void onFailure(Call<ArticalResponse> call, Throwable t) {

                        data.setValue(null);
                    }
                });
        return data;
    }
}
