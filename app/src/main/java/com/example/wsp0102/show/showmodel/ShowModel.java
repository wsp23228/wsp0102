package com.example.wsp0102.show.showmodel;

import com.example.wsp0102.OKhttp3.Okhttputils;

public class ShowModel implements IShowModel {
    @Override
    public void getShowData(String url, final ShowCallBack showCallBack) {
        Okhttputils.OkhttpGet(url, new Okhttputils.OkhttpCallBack() {
            @Override
            public void getOkhttpSuccess(String data) {
                showCallBack.getShowSuccess(data);
            }

            @Override
            public void getOkhttpFailed() {
                showCallBack.getShowFailed();
            }
        });
    }
}
