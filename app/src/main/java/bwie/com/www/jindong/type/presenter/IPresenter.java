package bwie.com.www.jindong.type.presenter;



/**
 * Created by lenovo on 2018/8/8.
 */

public interface IPresenter{
    void getLeftList(String token);
    void getRightParenData(int cid, String token);
    void getRightChildData(int pscid,String token);

}
