package com.example.wsp0102;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.MyGridAdapter;
import com.example.bean.Userbean;
import com.example.wsp0102.show.showpresenter.ShowPresenter;
import com.example.wsp0102.show.showview.IShowView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IShowView {

    private GridView grid_view;
    private TextView text_title;
    private ShowPresenter showPresenter;
    private List<Userbean.DataBean.FenleiBean> fenlei;
    private MyGridAdapter gridAdapter;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid_view = findViewById(R.id.grid_view);
        showPresenter = new ShowPresenter(this);
        showPresenter.ShowPresenterData();
        grid_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                shan();
                return false;
            }
        });
    }

    private void shan() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确认删除吗");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                fenlei.remove(index);
                gridAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
    @Override
    public void ShowViewData(final String data) {
        new Thread(){
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        Userbean userbean = gson.fromJson(data, Userbean.class);
                        fenlei = userbean.getData().getFenlei();
                        gridAdapter = new MyGridAdapter(MainActivity.this,fenlei);
                        grid_view.setAdapter(gridAdapter);
                    }
                });
            }
        }.start();
    }
}
