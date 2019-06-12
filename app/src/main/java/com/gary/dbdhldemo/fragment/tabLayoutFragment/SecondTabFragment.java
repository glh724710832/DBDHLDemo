package com.gary.dbdhldemo.fragment.tabLayoutFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gary.dbdhldemo.Adapter.Json2Adapter;
import com.gary.dbdhldemo.Adapter.JsonAdapter;
import com.gary.dbdhldemo.Adapter.Type2Adapter;
import com.gary.dbdhldemo.Adapter.TypeAdpader;
import com.gary.dbdhldemo.R;
import com.gary.dbdhldemo.bean.Video;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondTabFragment extends Fragment {

    private MyHandler handler;
    private TextView textView;
    private RecyclerView recyclerView;
    private List<Video.TrailersBean> trailers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_second_tab,container,false);
        textView = view.findViewById(R.id.text);

        handler = new MyHandler();

        requestBaiduUrl(textView);

        //RecyclerView展示Json
        recyclerView = view.findViewById(R.id.recycler_view);
        jsonRecyclerView();


        return view;
    }

    //RecyclerView设置
    private void jsonRecyclerView() {

        trailers = new ArrayList<>();

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    class MyHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("收到消息没","ok2");
            String json = (String) msg.obj;
            Gson gson = new Gson();
            Video video = gson.fromJson(json,Video.class);

            trailers = video.getTrailers();
            recyclerView.setAdapter(new Json2Adapter(getActivity(),trailers));
            Log.e("数据个数",String.valueOf(video.getTrailers().size()));
        }
    }

    private void requestBaiduUrl(final TextView textView) {
        Log.e("收到消息没","ok1");
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url("http://api.m.mtime.cn/PageSubArea/TrailerList.api").build();
        final Call call = okHttpClient.newCall(request);



        call.enqueue(new Callback() {
                       @Override
                       public void onFailure(Call call, IOException e) {

                       }

                       @Override
                       public void onResponse(Call call, Response response) throws IOException {
                           if(response.isSuccessful()) {
                              String json = response.body().string();
                              Message message = new Message();
                              message.obj =json;
                               handler.sendMessage(message);
                           }
                       }
                   });

            }


    }



