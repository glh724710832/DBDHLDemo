package com.gary.dbdhldemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gary.dbdhldemo.R;
import com.gary.dbdhldemo.base.adapter.BaseMultipleRecyclerViewAdapter;
import com.gary.dbdhldemo.base.adapter.BaseViewHolder;
import com.gary.dbdhldemo.bean.Video;

import java.util.List;

public class Type2Adapter extends BaseMultipleRecyclerViewAdapter {

    private List<Video.TrailersBean> trailersBeanList;
    private static final int ITME_TYPE_IMAGE = 1;
    private static final int ITME_TYPE_TEXT = 2;

    public Type2Adapter(Context context, List<Video.TrailersBean> trailersBeanList) {
        super(context);
        this.trailersBeanList = trailersBeanList;
    }

    @Override
    protected int getMultipleItemViewType(int position) {
        if(position %2 ==0 ){
            return  ITME_TYPE_IMAGE;
        }else{
            return  ITME_TYPE_TEXT;
        }
    }

    @Override
    protected int getItemSize() {
        return trailersBeanList.size();
    }

    @Override
    protected BaseViewHolder getNewBaseViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        if(itemType == ITME_TYPE_IMAGE){
            return new TypeTwoViewHolder(getViewByLayoutId(getContext(),R.layout.item_type_image));
        }else {
            return new TypeTwoViewHolder(getViewByLayoutId(getContext(),R.layout.item_type_text));
        }
    }

    @Override
    protected void showData(BaseViewHolder baseViewHolder, int position) {
          if(baseViewHolder instanceof TypeViewHolder){
              TypeViewHolder typeViewHolder = (TypeViewHolder) baseViewHolder;
          }else {
              TypeTwoViewHolder typeTwoViewHolder = (TypeTwoViewHolder) baseViewHolder;
              if(position == 5){
                  typeTwoViewHolder.item_type_text.setText("哈哈");
              }
          }
    }

    //自定义viewHolder
    public class TypeViewHolder extends BaseViewHolder{
        //绑定控件
        ImageView item_type_image;
        public TypeViewHolder(@NonNull View itemView) {
            super(itemView);
            item_type_image = itemView.findViewById(R.id.item_type_image);
        }
    }

    //自定义viewHolder
    public class TypeTwoViewHolder extends BaseViewHolder{
        //绑定控件
        TextView item_type_text;
        public TypeTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            item_type_text = itemView.findViewById(R.id.item_type_text);
        }
    }


}
