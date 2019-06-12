package com.gary.dbdhldemo.activity;

import android.view.View;

import com.gary.dbdhldemo.R;
import com.gary.dbdhldemo.base.BaseActivity;

public class TestActivity extends BaseActivity implements BaseActivity.ButterKnifeInterface {
    @Override
    protected void setStatus() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitApp();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void destory() {

    }

    @Override
    protected Boolean isSetVerticalScreen() {
        return null;
    }

    @Override
    public void initButterKnife() {

    }
}
