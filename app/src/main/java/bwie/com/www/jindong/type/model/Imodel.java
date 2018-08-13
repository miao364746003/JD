package bwie.com.www.jindong.type.model;


import bwie.com.www.jindong.home.fragment.ChildCallBack;

/**
 * Created by lenovo on 2018/8/8.
 */

public interface Imodel{
    void getLeftData(String token,LeftCallBack callBack);
    void getRightParentData(int cid,String token,ICallBack<TypeRightDataBean> callBack);
    void getTypeRightChildData(int pscid, String token, ChildCallBack childCallBack);
}
