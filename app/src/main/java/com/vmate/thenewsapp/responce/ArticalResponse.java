package com.vmate.thenewsapp.responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vmate.thenewsapp.model.ArticalModel;

import java.util.List;

public class ArticalResponse {

    @SerializedName("articles")
    @Expose
    private List<ArticalModel> articalModels;

    public List<ArticalModel> getArticalModels() {
        return articalModels;
    }

    public void setArticalModels(List<ArticalModel> articalModels) {
        this.articalModels = articalModels;
    }

    @Override
    public String toString() {
        return "ArticalResponse{" +
                "articalModels=" + articalModels +
                '}';
    }
}
