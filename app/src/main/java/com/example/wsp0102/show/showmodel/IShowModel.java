package com.example.wsp0102.show.showmodel;

public interface IShowModel {
    public void getShowData(String url,ShowCallBack showCallBack);
    public interface ShowCallBack{
        public void getShowSuccess(String data);
        public void getShowFailed();

    }
}
