package com.gary.dbdhldemo.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    public OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T extends RecyclerView.ViewHolder>{
        void onItemClick(T t,int position);
    }

    public View getViewByLayoutId(Context context,int layoutId){
        return LayoutInflater.from(context).inflate(layoutId,null);
    }

}

