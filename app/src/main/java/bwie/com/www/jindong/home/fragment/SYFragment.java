package bwie.com.www.jindong.home.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import bwie.com.www.jindong.R;
import bwie.com.www.jindong.base.BaseFragment;
import bwie.com.www.jindong.home.mvp.SYMVP.model.ADBean;
import bwie.com.www.jindong.home.mvp.SYMVP.model.SYRecycleBean;
import bwie.com.www.jindong.home.mvp.SYMVP.presenter.ISYpresenterImpl;
import bwie.com.www.jindong.home.mvp.SYMVP.view.ISYview;


/**
 * A simple {@link Fragment} subclass.
 */
public class SYFragment extends BaseFragment<ISYpresenterImpl> implements ISYview {

    private static final String TAG = "SYFragment";
    private Banner banner;
    private List<String> images=new ArrayList<>();


    @Override
    protected ISYpresenterImpl getPresenter() {
        presenter = new ISYpresenterImpl(this);
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_sy;
    }

    @Override
    protected void initView(View view) {
        banner = view.findViewById(R.id.sy_banner);
        banner.setImageLoader(new MyBanner());

    }

    @Override
    protected void initData() {
        presenter.getADInfo();
        presenter.getSYrecycleInfo();
    }

    @Override
    protected void initClickEvent() {

    }


    public static SYFragment onCreate(String title) {
        SYFragment fragment = new SYFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void getADInfoData(ADBean adBean) {
        for (int i = 0; i < adBean.getData().size(); i++) {
            images.add(adBean.getData().get(i).getIcon());
        }
        banner.setImages(images);
        banner.start();
    }

    @Override
    public void getSYRecycleInfoData(SYRecycleBean bean) {
        // TODO: 2018/8/11 处理recycle数据

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestory();
        presenter = null;
    }
    public class MyBanner extends ImageLoader {

        public void displayImage(Context context, Object      path, ImageView imageView) {

            //path表示当前要显示的图片的url，，imageView表示当前要显示图片的载体
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
