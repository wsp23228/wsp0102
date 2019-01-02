package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.Userbean;
import com.example.wsp0102.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MyGridAdapter extends BaseAdapter {
    private Context context;
    private List<Userbean.DataBean.FenleiBean> list ;

    public MyGridAdapter(Context context, List<Userbean.DataBean.FenleiBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolDer holDer;
        holDer = new ViewHolDer();
        if(view == null){
            view = View.inflate(context, R.layout.grid_layout,null);
            holDer.text_id = view.findViewById(R.id.text_id);
            holDer.text_name = view.findViewById(R.id.text_name);
            holDer.imag_icon = view.findViewById(R.id.image_icon);
            view.setTag(holDer);
        }else{
            holDer = (ViewHolDer) view.getTag();
        }
        holDer.text_name.setText(list.get(i).getName());
        holDer.text_id.setText(list.get(i).getCid());
        ImageLoader.getInstance().displayImage(list.get(i).getIcon(),holDer.imag_icon);
        return view;
    }
    class ViewHolDer{
        private TextView text_id,text_name;
        private ImageView imag_icon;
    }
}
