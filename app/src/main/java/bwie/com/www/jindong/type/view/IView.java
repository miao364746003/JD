package bwie.com.www.jindong.type.view;



import bwie.com.www.jindong.type.model.LeftListBean;
import bwie.com.www.jindong.type.model.TypeRightChildDataBean;
import bwie.com.www.jindong.type.model.TypeRightDataBean;

/**
 * Created by lenovo on 2018/8/8.
 */

public interface IView  {
    void getLeftData(LeftListBean Leftlist);
    void getRightParentData(TypeRightDataBean typeRightDataBean);
    void getTypeRightChildData(TypeRightChildDataBean typeRightChildDataBean);
}
