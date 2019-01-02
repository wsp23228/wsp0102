package com.example.wsp0102.show.showpresenter;

import com.example.wsp0102.MainActivity;
import com.example.wsp0102.api.Api;
import com.example.wsp0102.show.showmodel.IShowModel;
import com.example.wsp0102.show.showmodel.ShowModel;

public class ShowPresenter implements IShowPresenter{

    MainActivity mainActivity;
    private final ShowModel showModel;

    public ShowPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        showModel = new ShowModel();
    }

    @Override
    public void ShowPresenterData() {
        showModel.getShowData(Api.SHOW, new IShowModel.ShowCallBack() {
            @Override
            public void getShowSuccess(String data) {
                mainActivity.ShowViewData(data);
            }

            @Override
            public void getShowFailed() {
                mainActivity.ShowViewData("请求失败");
            }
        });
    }
}
