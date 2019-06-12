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

import cn.jzvd.JZVideoPlayerStandard;

public class JsonFourFragmentAdapter extends RecyclerView.Adapter<JsonFourFragmentAdapter.JsonViewHodler> {

    private Context context;
    private List<Video.TrailersBean> trailers;

    public JsonFourFragmentAdapter(Context context, List<Video.TrailersBean> trailers){
        this.context = context;
        this.trailers = trailers;
    }

    ///将item布局和ViewHolder绑定，并返回一个ViewHolder类型的对象
    //将item布局映射到view试图
    @Override
    public JsonViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_four_adapter_json,null);
        JsonViewHodler jsonViewHodler = new JsonViewHodler(view);
        return jsonViewHodler;
    }



    @Override
    public void onBindViewHolder(@NonNull JsonViewHodler jsonViewHodler, int i) {

        Glide.with(context).load(trailers.get(i).getCoverImg()).into(jsonViewHodler.jzVideoPlayerStandard.thumbImageView);


        //饺子播放器设置播放网址，选择模式，标题
        jsonViewHodler.jzVideoPlayerStandard.setUp(String.valueOf(trailers.get(i).getHightUrl()),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,trailers.get(i).getVideoTitle());
        //给饺子播放器的imageview设置较高清晰度的图片
        jsonViewHodler.jzVideoPlayerStandard.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }


    //步骤二：自定义类继承viewHodler，绑定item控件
    public static class JsonViewHodler extends RecyclerView.ViewHolder{


        private JZVideoPlayerStandard jzVideoPlayerStandard;


        public JsonViewHodler(@NonNull View itemView) {
            super(itemView);

            jzVideoPlayerStandard = itemView.findViewById(R.id.jz_videoplayer);



        }
    }




}
