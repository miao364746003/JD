package bwie.com.www.jindong.home.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.List;

import bwie.com.www.jindong.R;
import bwie.com.www.jindong.base.BaseFragment;
import bwie.com.www.jindong.type.model.LeftListBean;
import bwie.com.www.jindong.type.model.TypeRightChildDataBean;
import bwie.com.www.jindong.type.model.TypeRightDataBean;
import bwie.com.www.jindong.type.presenter.PresenterImpl;
import bwie.com.www.jindong.type.view.IView;
import bwie.com.www.jindong.type.view.TypeExpandableAdapter;
import bwie.com.www.jindong.type.view.XRecycleAdapter;


public class TypeFragment extends BaseFragment<PresenterImpl> implements IView {

    private RecyclerView recyclerView;
    private ExpandableListView expandableListView;
    private XRecycleAdapter recycleAdapter;
    private TypeExpandableAdapter typeExpandableAdapter;


    @Override
    protected PresenterImpl getPresenter() {
        presenter = new PresenterImpl(this);
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_type;
    }

    @Override
    protected void initView(View view) {

        recyclerView = view.findViewById(R.id.type_recycle_left);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //        left数据


        //right二级列表
        /***************************************************/
        expandableListView = view.findViewById(R.id.type_expandable_right);
        expandableListView.setGroupIndicator(null);
    }

    @Override
    protected void initData() {
        //                left请求数据
        presenter.getLeftList("2A00251F5AB63143C6162282C229BCD8");
        //        left设置数据
        recycleAdapter = new XRecycleAdapter(getContext());
        recyclerView.setAdapter(recycleAdapter);

        //        请求数据父
        presenter.getRightParenData(2, "2A00251F5AB63143C6162282C229BCD8");
        //请求数据子
        //        presenter.getRightChildData(39,"2A00251F5AB63143C6162282C229BCD8");
        typeExpandableAdapter = new TypeExpandableAdapter(getContext());
        expandableListView.setAdapter(typeExpandableAdapter);
        //默认展开

        //无法点击
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
    }

    private void show() {
        int groupCount = typeExpandableAdapter.getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            expandableListView.expandGroup(i);
        }
    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    protected void initClickEvent() {
        recycleAdapter.setClick(new XRecycleAdapter.onItemClick() {
            @Override
            public void setOnClick(int cid) {
                if (typeExpandableAdapter.getGroupCount()>0) {
                    typeExpandableAdapter.clearGroupData();
                }
                presenter.getRightParenData(cid, "2A00251F5AB63143C6162282C229BCD8");
            }
        });
    }


    @Override
    public void getLeftData(LeftListBean list) {
        List<LeftListBean.DataBean> beans = list.getData();
        recycleAdapter.add(beans);

    }

    private static final String TAG = "TypeFragment";

    @Override
    public void getRightParentData(TypeRightDataBean typeRightDataBean) {
        List<TypeRightDataBean.DataBean> data = typeRightDataBean.getData();
        typeExpandableAdapter.addGroupData(data);
        show();
    }

    @Override
    public void getTypeRightChildData(TypeRightChildDataBean typeRightChildDataBean) {
        //        List<TypeRightChildDataBean.DataBean> data = typeRightChildDataBean.getData();
        //        String title = data.get(0).getTitle();
        //        typeExpandableAdapter.addChildData(data);
        //        Log.d(TAG, "getTypeRightChildData: "+data.size());
    }

    public TypeFragment onCreate(String title) {
        TypeFragment fragment = new TypeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestory();
        presenter = null;
    }
}
