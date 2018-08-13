package bwie.com.www.jindong.home.mvp.SYMVP.model;

import bwie.com.www.jindong.type.model.ICallBack;

/**
 * Created by lenovo on 2018/8/10.
 */

public interface Isymodel {
    void getSyAD(ICallBack<ADBean> callBack);
    void getSYrecycleData(ICallBack<SYRecycleBean> callBack);
}
