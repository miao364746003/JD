package bwie.com.www.jindong.type.presenter;

import android.util.Log;

import bwie.com.www.jindong.base.BasePresenter;
import bwie.com.www.jindong.home.fragment.ChildCallBack;
import bwie.com.www.jindong.home.fragment.TypeFragment;
import bwie.com.www.jindong.type.model.ICallBack;
import bwie.com.www.jindong.type.model.Imodel;
import bwie.com.www.jindong.type.model.LeftCallBack;
import bwie.com.www.jindong.type.model.LeftListBean;
import bwie.com.www.jindong.type.model.ModelImpl;
import bwie.com.www.jindong.type.model.TypeRightChildDataBean;
import bwie.com.www.jindong.type.model.TypeRightDataBean;
import bwie.com.www.jindong.type.view.IView;

/**
 * Created by lenovo on 2018/8/8.
 */

public class PresenterImpl extends BasePresenter implements IPresenter ,LeftCallBack,ICallBack<TypeRightDataBean>{
    IView view;
    Imodel model;

    public PresenterImpl(TypeFragment view) {
        this.view = view;
        this.model = new ModelImpl();
    }

    @Override
    public void getLeftList(String token) {
        model.getLeftData(token,this);
    }

    @Override
    public void getRightParenData(int cid, String token) {
        model.getRightParentData(cid,token,this);
    }

    @Override
    public void getRightChildData(int pscid, String token) {
        model.getTypeRightChildData(pscid, token, new ChildCallBack() {
            @Override
            public void success(TypeRightChildDataBean bean) {
                view.getTypeRightChildData(bean);
            }
        });
    }

    @Override
    public void Success(LeftListBean Leftlist) {
        view.getLeftData(Leftlist);
    }

    private static final String TAG = "PresenterImpl";

    @Override
    public void CallBack(TypeRightDataBean typeRightDataBean) {
        view.getRightParentData(typeRightDataBean);
    }

    @Override
    public void Error(String error) {
        Log.d(TAG, "Error: "+error);
    }


    @Override
    public void onDestory() {
        view=null;

    }


}
