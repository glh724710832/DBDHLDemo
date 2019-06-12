package com.gary.dbdhldemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gary.dbdhldemo.R;
import com.gary.dbdhldemo.base.adapter.BaseSingleRecyclerViewAdapter;
import com.gary.dbdhldemo.base.adapter.BaseViewHolder;
import com.gary.dbdhldemo.bean.Video;

import java.util.List;

public class Json2Adapter extends BaseSingleRecyclerViewAdapter<Video.TrailersBean, Json2Adapter.TViewHolder> {


    public Json2Adapter(Context context, List<Video.TrailersBean> dataList) {
        super(context, dataList);

    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_adapter_json;
    }

    @Override
    protected TViewHolder getNewViewHolder(View view) {
        return new TViewHolder(view);
    }

    @Override
    protected void showData(TViewHolder tViewHolder, int position) {
        tViewHolder.tv_id.setText(String.valueOf(getDataList().get(position).getId()));
        tViewHolder.tv_movieName.setText(getDataList().get(position).getMovieName());
        Glide.with(getContext()).load(getDataList().get(position).getCoverImg()).into(tViewHolder.json_image_view);
        tViewHolder.tv_url.setText(getDataList().get(position).getHightUrl());
        tViewHolder.tv_videoTitle.setText(getDataList().get(position).getVideoTitle());
        tViewHolder.tv_type.setText(String.valueOf(getDataList().get(position).getType()));
    }

    static class TViewHolder extends BaseViewHolder{

         TextView tv_id;
         TextView tv_movieName;
         ImageView json_image_view;
         TextView tv_url;
         TextView tv_videoTitle;
         TextView tv_type;

        public TViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_movieName = itemView.findViewById(R.id.tv_movieName);
            json_image_view = itemView.findViewById(R.id.json_image_view);
            tv_url = itemView.findViewById(R.id.tv_url);
            tv_videoTitle = itemView.findViewById(R.id.tv_videoTitle);
            tv_type = itemView.findViewById(R.id.tv_type);
        }
    }

}
