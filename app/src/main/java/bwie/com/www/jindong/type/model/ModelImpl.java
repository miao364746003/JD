package bwie.com.www.jindong.type.model;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import bwie.com.www.jindong.api.API;
import bwie.com.www.jindong.home.fragment.ChildCallBack;
import bwie.com.www.jindong.service.ApiService;
import bwie.com.www.jindong.utils.Utils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2018/8/8.
 */

public class ModelImpl implements Imodel {


    @Override
    public void getLeftData(String token, final LeftCallBack callBack) {
        HttpLoggingInterceptor Interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("Interceptor", "日志信息: " + message);
            }
        });

        Interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .addInterceptor(Interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API.TYPELEFTURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<LeftListBean> flowable = apiService.getTypeLeftList(token);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<LeftListBean>() {
                    @Override
                    public void onNext(LeftListBean leftListBean) {
                        callBack.Success(leftListBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.Error(t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRightParentData(int cid, String token, final ICallBack<TypeRightDataBean> callBack) {
        HttpLoggingInterceptor Interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("Interceptor", "日志信息: " + message);
            }
        });

        Interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .addInterceptor(Interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API.TYPELEFTURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<TypeRightDataBean> flowable = apiService.getTypeRightData(cid, token);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<TypeRightDataBean>() {
                    @Override
                    public void onNext(TypeRightDataBean typeRightDataBean) {
                        callBack.CallBack(typeRightDataBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private static final String TAG = "ModelImpl";

    @Override
    public void getTypeRightChildData(int pscid, String token, final ChildCallBack childCallBack) {
        ApiService apiService = Utils.getUtilsApiService(API.TYPELEFTURL);
        Flowable<TypeRightChildDataBean> typeRightChildData = apiService.getTypeRightChildData(pscid, token);
        typeRightChildData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<TypeRightChildDataBean>() {
                    @Override
                    public void onNext(TypeRightChildDataBean typeRightChildDataBean) {
                        childCallBack.success(typeRightChildDataBean);
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
