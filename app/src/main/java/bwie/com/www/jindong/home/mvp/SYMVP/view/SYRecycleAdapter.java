package bwie.com.www.jindong.home.mvp.SYMVP.view;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import bwie.com.www.jindong.R;
import bwie.com.www.jindong.home.mvp.SYMVP.model.SYRecycleBean;


public class SYRecycleAdapter extends RecyclerView.Adapter<SYRecycleAdapter.ViewHolder> {

    private Context context;
    private List<SYRecycleBean.DataBean> list;

    public SYRecycleAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();

    }

    public void add(List<SYRecycleBean.DataBean> beans) {
        list.addAll(beans);
        notifyDataSetChanged();
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.sy_recycle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String name = list.get(position).getName();
        holder.textView.setText(name);
        String icon = list.get(position).getIcon();
        Uri parse = Uri.parse(icon);
        holder.image.setImageURI(parse);
        //        holder.textView.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                if (click!=null){
        //                    click.setOnClick(list.get(position).getCid());
        //                }
        //            }
        //        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.sy_recycle_text);
            image = itemView.findViewById(R.id.sy_recycle_image);
        }
    }

    public void setClick(onItemClick click) {
        this.click = click;
    }

    private onItemClick click;

    public interface onItemClick {
        void setOnClick(int cid);
    }
}
