package com.vmate.thenewsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vmate.thenewsapp.R;
import com.vmate.thenewsapp.model.ArticalModel;

import java.util.ArrayList;

public class Adapterclass extends RecyclerView.Adapter<Adapterclass.MyViewHolder> {

    private final Context context;
    ArrayList<ArticalModel> modelArrayList;
    private ItemClickListener clickListener;

    public Adapterclass(Context context, ArrayList<ArticalModel> modelArrayList,ItemClickListener itemClickListener) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ArticalModel articalModel = modelArrayList.get(position);
         holder.news_des.setText(articalModel.getDes());
         holder.news_title.setText(articalModel.getTitle());
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 clickListener.onItemclick(modelArrayList.get(position));
             }
         });
        Glide.with(context)
                .load(articalModel.getImage())
                .into(holder.imageView);

        Toast.makeText(context,""+modelArrayList.size(),Toast.LENGTH_LONG).show();

    }

    @Override
    public int getItemCount() {
        if(this.modelArrayList != null) {
            return this.modelArrayList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView news_title,news_des;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            news_title = itemView.findViewById(R.id.news_title);
            news_des =itemView.findViewById(R.id.news_des);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    public interface ItemClickListener{
        public void onItemclick(ArticalModel item);
    }
}
