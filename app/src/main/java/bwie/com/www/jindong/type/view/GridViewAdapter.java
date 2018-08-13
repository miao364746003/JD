package bwie.com.www.jindong.type.view;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bwie.com.www.jindong.R;
import bwie.com.www.jindong.type.model.TypeRightChildDataBean;
import bwie.com.www.jindong.type.model.TypeRightDataBean;

/**
 * Created by lenovo on 2018/8/9.
 */

public class GridViewAdapter extends BaseAdapter {
    private List<TypeRightDataBean.DataBean.ListBean>  list;
    private Context context;
//    private List<TypeRightDataBean.DataBean.ListBean> list;

    public GridViewAdapter(List<TypeRightDataBean.DataBean.ListBean> childData, Context context) {
        this.list = childData;
        this.context = context;
    }

    @Override
    public int getCount() {
//        list = childData.get(0).getList();
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
        View v = LayoutInflater.from(context).inflate(R.layout.type_child_item, viewGroup,false);
        TextView textView = v.findViewById(R.id.type_child_item_text);
        SimpleDraweeView image = v.findViewById(R.id.type_child_item_image);
        Uri parse = Uri.parse(list.get(i).getIcon());
        image.setImageURI(parse);
        Log.d("xxx", "getView: "+list.get(i).getName());
        textView.setText(list.get(i).getName());
        return v;
    }

    static class gridViewHolder {
        SimpleDraweeView image;
        TextView textView;
    }
}
