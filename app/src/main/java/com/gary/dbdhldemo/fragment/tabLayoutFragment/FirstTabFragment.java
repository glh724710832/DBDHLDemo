package com.gary.dbdhldemo.fragment.tabLayoutFragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gary.dbdhldemo.R;

public class FirstTabFragment extends Fragment {

    private ImageView image_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_first_tab,null);
        image_view = view.findViewById(R.id.image_view);
        loadImage();
        return view;
    }
public void loadImage(){
    //显示网络图片
    Glide.with(getActivity()).load("http://p1.img.cctvpic.com//uploadimg//2016//11//21//1479709196170747.jpg").into(image_view);
}

}
