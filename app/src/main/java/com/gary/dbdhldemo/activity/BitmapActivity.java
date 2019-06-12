package com.gary.dbdhldemo.activity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.gary.dbdhldemo.R;
import com.gary.dbdhldemo.util.BitmapUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        File file = new File("file:///android_asset/image1.jpg");
        Log.e("文件是否存在",String.valueOf(file.exists()));

        InputStream is= null;


        for(int i = 0;i<10000;i++) {

            try {
                //获取文件流
                is = getResources().getAssets().open("image/image1.jpg");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(is);
        }



    }
}
