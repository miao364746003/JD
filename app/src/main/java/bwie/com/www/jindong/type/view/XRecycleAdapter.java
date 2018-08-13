package bwie.com.www.jindong.type.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import bwie.com.www.jindong.R;
import bwie.com.www.jindong.type.model.LeftListBean;


public class XRecycleAdapter  extends RecyclerView.Adapter<XRecycleAdapter.ViewHolder>{

    private Context context;
    private List<LeftListBean.DataBean> list;

    public XRecycleAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();

    }
    public  void add(List<LeftListBean.DataBean> beans){
        list.addAll(beans);
        notifyDataSetChanged();
    }
    public  void clear(){
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.type_left_recycle_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String name = list.get(position).getName();
        holder.textView.setText(name);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (click!=null){
                    click.setOnClick(list.get(position).getCid());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.type_left_recycle_item);
        }
    }

    public void setClick(onItemClick click) {
        this.click = click;
    }

    private onItemClick click;
    public interface onItemClick{
        void setOnClick(int cid);
    }
}
