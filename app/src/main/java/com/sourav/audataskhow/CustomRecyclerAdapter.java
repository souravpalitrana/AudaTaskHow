package com.sourav.audataskhow;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Hasmath on 10/4/2015.
 */

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    ArrayList<String> data;
    Context context;
    private LayoutInflater inflater;
    int current;
    public CustomRecyclerAdapter(Context context,ArrayList<String> data)
    {
        this.data=data;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.row,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //  holder.title.setText(information.title);
        //  holder.icon.setImageResource(information.iconId);

        holder.imageView.setImageResource(R.drawable.splash_categories);
        current=position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);

            imageView=(ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public int getCurrentItem()
    {
        return current;
    }

}
