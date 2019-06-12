package com.gary.dbdhldemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gary.dbdhldemo.Adapter.MyPagerAdapter;
import com.gary.dbdhldemo.R;
import com.gary.dbdhldemo.fragment.tabLayoutFragment.FirstTabFragment;
import com.gary.dbdhldemo.fragment.tabLayoutFragment.FourTabFragment;
import com.gary.dbdhldemo.fragment.tabLayoutFragment.SecondTabFragment;
import com.gary.dbdhldemo.fragment.tabLayoutFragment.ThridTabFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmnet extends Fragment {

    private List<String> tabTitleList;
    private List<Fragment> fragmentList;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);


        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        fragmentList = new ArrayList<>();
        tabTitleList = new ArrayList<>();


        //添加碎片
        fragmentList.add(new FirstTabFragment());
        fragmentList.add(new SecondTabFragment());
        fragmentList.add(new ThridTabFragment());
        fragmentList.add(new FourTabFragment());

        //添加标题
        tabTitleList.add("LoL");
        tabTitleList.add("一起看");
        tabTitleList.add("郭德纲");
        tabTitleList.add("饺子视频");

        //将标题添加给TabLayout,偷懒采用循环
        for (int i = 0; i < tabTitleList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabTitleList.get(i)));
        }

        //将TabLayout与Viewpager联动起来
        tabLayout.setupWithViewPager(viewPager);

        //设置适配器

        viewPager.setAdapter(new MyPagerAdapter(getFragmentManager(), tabTitleList, fragmentList));


        return view;


    }


}
