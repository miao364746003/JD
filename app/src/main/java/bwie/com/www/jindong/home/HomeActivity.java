package bwie.com.www.jindong.home;


import android.graphics.Color;
import android.os.Bundle;


import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import bwie.com.www.jindong.R;
import bwie.com.www.jindong.base.BaseActivity;
import bwie.com.www.jindong.home.fragment.CartFragment;
import bwie.com.www.jindong.home.fragment.FindFragment;
import bwie.com.www.jindong.home.fragment.MyFragment;
import bwie.com.www.jindong.home.fragment.SYFragment;
import bwie.com.www.jindong.home.fragment.TypeFragment;

public class HomeActivity extends BaseActivity {


    @Bind(R.id.home_bottomtabar)
    BottomTabBar homeBottomtabar;
    private SYFragment syFragment;
    private BottomTabBar mBottomTabBar;

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.home_bottomtabar);
        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .setTabPadding(0,0,0)
                .setChangeColor(Color.DKGRAY,Color.GREEN)
                .addTabItem("首页", R.drawable.ac1, SYFragment.class)
                .addTabItem("分类", R.drawable.abx, TypeFragment.class)
                .addTabItem("发现", R.drawable.abz, FindFragment.class)
                .addTabItem("购物车", R.drawable.abv, CartFragment.class)
                .addTabItem("我的", R.drawable.ac3, MyFragment.class)
                .isShowDivider(false);
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
