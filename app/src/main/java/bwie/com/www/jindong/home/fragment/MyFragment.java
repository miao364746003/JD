package bwie.com.www.jindong.home.fragment;


import android.support.v4.app.Fragment;
import android.view.View;

import bwie.com.www.jindong.R;
import bwie.com.www.jindong.base.BaseFragment;
import bwie.com.www.jindong.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View view) {
//        view.findViewById(R.id.)
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClickEvent() {

    }
    //    public MyFragment onCreate(String title){
//        MyFragment fragment = new MyFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("title",title);
//        fragment.setArguments(bundle);
//        return fragment;
//    }

}
