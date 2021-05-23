package com.vmate.thenewsapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vmate.thenewsapp.repository.ArticalRepository;
import com.vmate.thenewsapp.responce.ArticalResponse;

public class ArticalViewModel extends AndroidViewModel {

    private ArticalRepository articalRepository;
    private LiveData<ArticalResponse> articalResponseLiveData;

    public ArticalViewModel(@NonNull Application application) {
        super(application);

        articalRepository = new ArticalRepository();

        this.articalResponseLiveData = articalRepository.getItemResponse();
    }

    public LiveData<ArticalResponse> getArticalResponseLiveData(){
        return articalResponseLiveData;
    }
}
