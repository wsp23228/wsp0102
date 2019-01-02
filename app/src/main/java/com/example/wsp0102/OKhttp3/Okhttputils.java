package com.example.wsp0102.OKhttp3;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttputils {

    private static OkHttpClient okHttpClient;

    public static void OkhttpGet(String url, final OkhttpCallBack okhttpCallBack){
        okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).method("GET", null).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                okhttpCallBack.getOkhttpFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                okhttpCallBack.getOkhttpSuccess(response.body().string());
            }
        });
    }
    public interface OkhttpCallBack{
        public void getOkhttpSuccess(String data);
        public void getOkhttpFailed();

    }
}
