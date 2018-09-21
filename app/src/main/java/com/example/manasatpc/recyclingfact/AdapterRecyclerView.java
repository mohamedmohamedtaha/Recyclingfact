package com.example.manasatpc.recyclingfact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manasatpc.recyclingfact.model.Commercy;

import java.util.ArrayList;


public class AdapterRecyclerView extends RecyclerView.Adapter {
    ArrayList<Commercy>dataList ;
    Context context;
    public AdapterRecyclerView(ArrayList<Commercy>dataList,Context context){
        this.dataList = dataList;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_commercy,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder)holder).textView.setText(dataList.get(position).getName());
        ((ViewHolder)holder).imageView.setImageResource(dataList.get(position).getImage_id());

        final int index = holder.getAdapterPosition();
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RecyclerViewActivity)context).setIntent(dataList.get(index));
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private View view;
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textView = (TextView)itemView.findViewById(R.id.text_view_title);
            imageView = (ImageView)itemView.findViewById(R.id.image_view);
        }
    }
}









