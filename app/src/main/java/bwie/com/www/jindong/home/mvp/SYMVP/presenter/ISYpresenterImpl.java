package bwie.com.www.jindong.home.mvp.SYMVP.presenter;


import bwie.com.www.jindong.base.BasePresenter;
import bwie.com.www.jindong.home.fragment.SYFragment;
import bwie.com.www.jindong.home.mvp.SYMVP.model.ADBean;
import bwie.com.www.jindong.home.mvp.SYMVP.model.Isymodel;
import bwie.com.www.jindong.home.mvp.SYMVP.model.IsymodeliMPL;
import bwie.com.www.jindong.home.mvp.SYMVP.model.SYRecycleBean;
import bwie.com.www.jindong.home.mvp.SYMVP.view.ISYview;
import bwie.com.www.jindong.type.model.ICallBack;

/**
 * Created by lenovo on 2018/8/10.
 */

public class ISYpresenterImpl extends BasePresenter implements ISYpresenter {
    private ISYview view;
    private Isymodel model;

    public ISYpresenterImpl(SYFragment activity) {
        this.view = activity;
        this.model = new IsymodeliMPL();
    }

    @Override
    public void getADInfo() {
        model.getSyAD(new ICallBack<ADBean>() {
            @Override
            public void CallBack(ADBean adBean) {
                view.getADInfoData(adBean);
            }
        });
    }

    @Override
    public void getSYrecycleInfo() {
        model.getSYrecycleData(new ICallBack<SYRecycleBean>() {
            @Override
            public void CallBack(SYRecycleBean syRecycleBean) {
                view.getSYRecycleInfoData(syRecycleBean);
            }
        });
    }

    @Override
    public   void onDestory() {
        view=null;
    }
}
