package com.gary.dbdhldemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gary.dbdhldemo.R;
import com.gary.dbdhldemo.bean.Video;

import java.util.List;

public class TypeAdpader extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Video.TrailersBean> trailersBeanList;
    private Context context;
    private static final int ITME_TYPE_IMAGE = 1;
    private static final int ITME_TYPE_TEXT = 2;

    public TypeAdpader(List<Video.TrailersBean> trailersBeanList, Context context) {
        this.trailersBeanList = trailersBeanList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        if(position %2 ==0 ){
            return  ITME_TYPE_IMAGE;
        }else{
            return  ITME_TYPE_TEXT;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {

        if(itemType==ITME_TYPE_IMAGE){
            View view = LayoutInflater.from(context).inflate(R.layout.item_type_image,null);
            TypeViewHolder typeViewHolder = new TypeViewHolder(view);
            return typeViewHolder;
        }else{
            View view = LayoutInflater.from(context).inflate(R.layout.item_type_text,null);
            TypeTwoViewHolder typeTwoViewHolder = new TypeTwoViewHolder(view);
            return typeTwoViewHolder;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {



        if(viewHolder instanceof TypeViewHolder){
            //图片类型
            TypeViewHolder typeViewHolder = (TypeViewHolder) viewHolder;
            if(i == 4){
                Glide.with(context).load("http://img3.imgtn.bdimg.com/it/u=2312312869,2939919792&fm=26&gp=0.jpg").into(typeViewHolder.item_type_image);
            }else {
                typeViewHolder.item_type_image.setImageResource(R.mipmap.ic_launcher);
            }
        }else {
            //文本类型
            TypeTwoViewHolder typeTwoViewHolder = (TypeTwoViewHolder) viewHolder;
            if(i == 5){
                typeTwoViewHolder.item_type_text.setText("http://p1.img.cctvpic.com//uploadimg//2016//11//21//1479709196170747.jpg");
            }else{
                //避免recyclerView的复用机制:下滑界面后新页面的位置也会被设置
                typeTwoViewHolder.item_type_text.setText(String.format("什么颜色:%d",i));

            }

        }

    }

    @Override
    public int getItemCount() {
        return trailersBeanList.size();
    }


    //自定义viewHolder
    public class TypeViewHolder extends RecyclerView.ViewHolder{
            //绑定控件
        ImageView item_type_image;
        public TypeViewHolder(@NonNull View itemView) {
            super(itemView);
            item_type_image = itemView.findViewById(R.id.item_type_image);
        }
    }

    //自定义viewHolder
    public class TypeTwoViewHolder extends RecyclerView.ViewHolder{
        //绑定控件
        TextView item_type_text;
        public TypeTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            item_type_text = itemView.findViewById(R.id.item_type_text);
        }
    }


}
