package bwie.com.www.jindong.service;


import bwie.com.www.jindong.home.mvp.SYMVP.model.ADBean;
import bwie.com.www.jindong.home.mvp.SYMVP.model.SYRecycleBean;
import bwie.com.www.jindong.type.model.LeftListBean;
import bwie.com.www.jindong.type.model.TypeRightChildDataBean;
import bwie.com.www.jindong.type.model.TypeRightDataBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/8/7.
 */

public interface ApiService {
    @GET("ad/getAd")
    Flowable<ADBean> getADInfo();
//    product/getCatagory?token=2A00251F5AB63143C6162282C229BCD8
    @GET("product/getCatagory")
    Flowable<LeftListBean> getTypeLeftList(@Query("token")String token);
//    product/getProductCatagory?cid=2&token=2A00251F5AB63143C6162282C229BCD8
    @GET("product/getProductCatagory")
    Flowable<TypeRightDataBean> getTypeRightData(@Query("cid")int cid, @Query("token")String token);
//    product/getProducts?pscid=39&token=2A00251F5AB63143C6162282C229BCD8
    //子类数据
    @GET("product/getProducts")
    Flowable<TypeRightChildDataBean> getTypeRightChildData(@Query("pscid")int pscid, @Query("token")String token);

    //首页数据
//    https://www.zhaoapi.cn/product/getCatagory
    @GET("product/getCatagory")
    Flowable<SYRecycleBean> getSYrecycleData();
}
