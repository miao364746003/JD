package bwie.com.www.jindong.type.model;

import java.util.List;

/**
 * Created by lenovo on 2018/8/8.
 */

public interface LeftCallBack {
    void Success(LeftListBean Leftlist);
    void Error(String error);
}
