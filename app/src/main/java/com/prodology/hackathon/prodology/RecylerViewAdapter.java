package com.prodology.hackathon.prodology;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pritesh on 21/2/17.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder> {
    int []tileImageId={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
    int []mainImageId={R.drawable.image,R.drawable.image1,R.drawable.image,R.drawable.image1};
    String [] tileString={"A","B","C","D"};

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tileTitle;
        ImageView tileImage;
        ImageView mainImage;

        public ViewHolder(View itemView) {
            super(itemView);
            //give elements of cardview
            tileImage = (ImageView) itemView.findViewById(R.id.tileImage);
            mainImage = (ImageView) itemView.findViewById(R.id.mainImage);
            tileTitle = (TextView)itemView.findViewById(R.id.tileTitle);
        }
    }
    @Override
    public RecylerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =(View) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(RecylerViewAdapter.ViewHolder holder, int position) {
        //bind elements
        holder.tileTitle.setText(tileString[position]);
        holder.tileImage.setImageResource(tileImageId[position]);
        holder.mainImage.setImageResource(mainImageId[position]);


    }
    @Override
    public int getItemCount() {
        return 4;
    }


}