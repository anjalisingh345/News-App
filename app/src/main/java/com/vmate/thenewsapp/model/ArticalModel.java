package com.vmate.thenewsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ArticalModel {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String des;

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("urlToImage")
    @Expose
    private String image;
    @SerializedName("publishedAt")
    @Expose
    private  String publishedAt;
    @SerializedName("content")
    @Expose
    private  String content;
    @SerializedName("author")
    @Expose
    private  String author;


    public ArticalModel(String image, String title, String des,String url,String author,String content,String publishedAt) {
        this.image = image;
        this.title = title;
        this.des = des;
        this.url = url;
        this.author = author;
        this.content = content;
        this.publishedAt = publishedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

}
