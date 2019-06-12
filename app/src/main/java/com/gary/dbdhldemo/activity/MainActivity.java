package com.gary.dbdhldemo.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gary.dbdhldemo.R;
import com.gary.dbdhldemo.fragment.DyFragmnet;
import com.gary.dbdhldemo.fragment.HomeFragmnet;
import com.gary.dbdhldemo.fragment.UserCenterFragmnet;
import com.gary.dbdhldemo.fragment.VideoFragmnet;
import com.gary.dbdhldemo.fragment.XqFragmnet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNavigationBar;

    private List<String> tabStringList;

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationBar = findViewById(R.id.bnb_bar);
        initBottomBar();
    }

    private void initBottomBar() {
        tabStringList = new ArrayList<>();
        tabStringList.add(getString(R.string.item1_string_home));
        tabStringList.add(getString(R.string.item2_string_sx));
        tabStringList.add(getString(R.string.item3_string_xq));
        tabStringList.add(getString(R.string.item4_string_dy));
        tabStringList.add(getString(R.string.item5_string_user_center));
        //为底部导航栏添加5个item
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.item1_bottom_menu_home, tabStringList.get(0)))
                .addItem(new BottomNavigationItem(R.drawable.item2_bottom_menu_funny, tabStringList.get(1)))
                .addItem(new BottomNavigationItem(R.drawable.item3_bottom_menu_found, tabStringList.get(2)))
                .addItem(new BottomNavigationItem(R.drawable.item4_bottm_menu_subscription, tabStringList.get(3)))
                .addItem(new BottomNavigationItem(R.drawable.item5_bottom_menu_mine, tabStringList.get(4)))
                .setInActiveColor("#303030")//设置未选择状态的颜色
                .setActiveColor("#FF3030")//设置选择的状态颜色
                .setBarBackgroundColor("#ffffff")//设置底部导航栏的背景颜色
                .setMode(BottomNavigationBar.MODE_FIXED)//设置模式为默认模式
                .setTabSelectedListener(this)
                .initialise();    //initialise 一定要放在 所有设置的最后一项

        //默认加载首页的Fragment
        replaceFragment(tabStringList.get(0));
    }


    //    复制以下代码到你的Activity即可
    private void replaceFragment(String tag) {
        if (currentFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(currentFragment).commit();
        }
        currentFragment = (Fragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (currentFragment == null) {
            switch (tag) {
                case "主页":
                    currentFragment = new HomeFragmnet();
                    break;
                case "视讯":
                    currentFragment = new VideoFragmnet();
                    break;
                case "星球":
                    currentFragment = new XqFragmnet();
                    break;
                case "订阅":
                    currentFragment = new DyFragmnet();
                    break;
                case "用户中心":
                    currentFragment = new UserCenterFragmnet();
                    break;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, currentFragment, tag).commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(currentFragment).commit();
        }
    }

    @Override
    public void onTabSelected(int position) {
        replaceFragment(tabStringList.get(position));
    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {
    }
}
