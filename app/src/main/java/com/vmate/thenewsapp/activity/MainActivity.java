package com.vmate.thenewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vmate.thenewsapp.R;
import com.vmate.thenewsapp.ViewModel.ArticalViewModel;
import com.vmate.thenewsapp.adapter.Adapterclass;
import com.vmate.thenewsapp.model.ArticalModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapterclass.ItemClickListener{

    private  static  final  String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ProgressBar progressBar;
    private TextView nodatafound;

   private ArrayList<ArticalModel> articalModelArrayList=new ArrayList<ArticalModel>();
   ArticalViewModel articalViewModel;
   private Adapterclass madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initi();
        getArtical();
    }



    private void initi() {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progress);
        nodatafound = findViewById(R.id.noResultTv);
        progressBar.setVisibility(View.VISIBLE);

        layoutManager = new  LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        madapter = new Adapterclass(MainActivity.this,articalModelArrayList,this);
        recyclerView.setAdapter(madapter);
        articalViewModel = ViewModelProviders.of(this).get(ArticalViewModel.class);

    }
    private void getArtical() {

articalViewModel.getArticalResponseLiveData().observe(this,articalResponse -> {
    progressBar.setVisibility(View.VISIBLE);
    if (articalResponse != null && articalResponse.getArticalModels() != null
            && !articalResponse.getArticalModels().isEmpty()) {

        progressBar.setVisibility(View.GONE);
        nodatafound.setVisibility(View.GONE);
        List<ArticalModel> articalList = articalResponse.getArticalModels();
        articalModelArrayList.addAll(articalList);
        madapter.notifyDataSetChanged();

    }
    else{
        progressBar.setVisibility(View.GONE);
        nodatafound.setVisibility(View.VISIBLE);
    }
});
}

    @Override
    public void onItemclick(ArticalModel item) {
        Intent intent = new Intent(MainActivity.this,MYWebview.class);
        intent.putExtra("url",""+item.getUrl());
        //intent.putExtra("title",""+item.getTitle());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
      //  Toast.makeText(this, "Clicked Title Name is : " +item.getTitle(), Toast.LENGTH_SHORT).show();
    }
}