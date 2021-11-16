package com.example.android.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<ModelClass> modelClassArrayList;

   public Adapter(Context context,ArrayList<ModelClass> modelClassArrayList)
   {
       this.context = context;
       this.modelClassArrayList = modelClassArrayList;
   }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mtime.setText(modelClassArrayList.get(position).getPublishedAt());
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mdescription.setText(modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView mheading,mdescription,mauthor,mtime;

        CardView cardView;

        ImageView imageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.heading);
            mdescription = itemView.findViewById(R.id.description);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.timezone);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
