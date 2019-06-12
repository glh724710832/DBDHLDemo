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

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.JsonViewHodler> {

    private Context context;
    private List<Video.TrailersBean> trailers;

    public JsonAdapter(Context context,List<Video.TrailersBean> trailers){
        this.context = context;
        this.trailers = trailers;
    }

    ///将item布局和ViewHolder绑定，并返回一个ViewHolder类型的对象
    //将item布局映射到view试图
    //参数列表 int i  为item类型，代表TypePosition
    @Override
    public JsonViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_adapter_json,null);
        JsonViewHodler jsonViewHodler = new JsonViewHodler(view);
        return jsonViewHodler;
    }


//设置数据，下方i      为posion位置
    @Override
    public void onBindViewHolder(@NonNull JsonViewHodler jsonViewHodler, int i) {
        jsonViewHodler.tv_id.setText(String.valueOf(trailers.get(i).getId()));
        jsonViewHodler.tv_movieName.setText(trailers.get(i).getMovieName());
        Glide.with(context).load(trailers.get(i).getCoverImg()).into(jsonViewHodler.json_image_view);
        jsonViewHodler.tv_url.setText(trailers.get(i).getHightUrl());
        jsonViewHodler.tv_videoTitle.setText(trailers.get(i).getVideoTitle());
        jsonViewHodler.tv_type.setText(String.valueOf(trailers.get(i).getType()));


    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }


    //步骤二：自定义类继承viewHodler，绑定item控件
    public static class JsonViewHodler extends RecyclerView.ViewHolder{

        private TextView tv_id;
        private TextView tv_movieName;
        private ImageView json_image_view;
        private TextView tv_url;
        private TextView tv_videoTitle;
        private TextView tv_type;

        public JsonViewHodler(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_movieName = itemView.findViewById(R.id.tv_movieName);
            json_image_view = itemView.findViewById(R.id.json_image_view);
            tv_url = itemView.findViewById(R.id.tv_url);
            tv_videoTitle = itemView.findViewById(R.id.tv_videoTitle);
            tv_type = itemView.findViewById(R.id.tv_type);


        }
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

}
