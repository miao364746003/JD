package bwie.com.www.jindong.home.mvp.SYMVP.model;

import bwie.com.www.jindong.api.API;
import bwie.com.www.jindong.service.ApiService;
import bwie.com.www.jindong.type.model.ICallBack;
import bwie.com.www.jindong.utils.Utils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2018/8/10.
 */

public class IsymodeliMPL implements Isymodel{
    @Override
    public void getSyAD(final ICallBack callBack) {
        ApiService apiService = Utils.getUtilsApiService(API.ADURL);
        Flowable<ADBean> adInfo = apiService.getADInfo();
        adInfo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<ADBean>() {
                    @Override
                    public void onNext(ADBean adBean) {
                        callBack.CallBack(adBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getSYrecycleData(final ICallBack<SYRecycleBean> callBack) {
        ApiService apiService = Utils.getUtilsApiService(API.TYPELEFTURL);
        Flowable<SYRecycleBean> sYrecycleData = apiService.getSYrecycleData();
        sYrecycleData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<SYRecycleBean>() {
                    @Override
                    public void onNext(SYRecycleBean syRecycleBean) {
                        callBack.CallBack(syRecycleBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
