package bwie.com.www.jindong.type.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bwie.com.www.jindong.R;
import bwie.com.www.jindong.type.model.TypeRightDataBean;


public class TypeExpandableAdapter extends BaseExpandableListAdapter {
    private List<TypeRightDataBean.DataBean> groupData;
    private Context context;
    private GridViewAdapter adapter;
    private String title;

    public TypeExpandableAdapter(Context context) {
        this.context =context;
        this.groupData = new ArrayList<>();
    }
    public void addGroupData(List<TypeRightDataBean.DataBean> groupData){
        this.groupData.addAll(groupData);
        notifyDataSetChanged();
    }
    public void clearGroupData(){
        this.groupData.clear();
        notifyDataSetChanged();
    }

//    public void addChildData(List<TypeRightChildDataBean.DataBean> childData) {
//        this.childData.addAll(childData);
//        notifyDataSetChanged();
//    }
//    public void addChildData(TypeRightChildDataBean childData) {
//        this.childData.addAll(childData);
//        notifyDataSetChanged();
//    }

    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return groupData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return groupData.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder holder;
        if (view==null){
            view = View.inflate(context,R.layout.type_group,null);
            holder = new GroupViewHolder();
            holder.textView = view.findViewById(R.id.type_group_text);
            view.setTag(holder);
        }else {
            holder = (GroupViewHolder) view.getTag();
        }
        holder.textView.setText(groupData.get(i).getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.type_child,viewGroup,false);
        GridView gridView = v.findViewById(R.id.type_child_gridview);
        List<TypeRightDataBean.DataBean.ListBean> list = groupData.get(i).getList();
        adapter = new GridViewAdapter(list, context);
        gridView.setAdapter(adapter);
        return v;

//        ChildViewHolder holder;
//        if (view==null){
//            view = View.inflate(context,R.layout.type_group,null);
//            holder = new ChildViewHolder();
//            holder.textView = view.findViewById(R.id.type_group_text);
//            view.setTag(holder);
//        }else {
//            holder = (ChildViewHolder) view.getTag();
//        }
//        title = groupData.get(i).getList().get(i1).getName();
//        holder.textView.setText(title);
//        Log.d("xxx", "getChildView: "+title);
//        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    static class GroupViewHolder{
        TextView textView ;
    }
    static class ChildViewHolder{
        TextView textView ;
    }
}
