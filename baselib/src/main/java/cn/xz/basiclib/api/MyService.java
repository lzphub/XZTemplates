package cn.xz.basiclib.api;

import cn.xz.annotations.ApiFactory;
import cn.xz.basiclib.bean.PostBean;
import cn.xz.basiclib.bean.VersionBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@ApiFactory(value = BaseApi.class)
public interface MyService {

    //退出登录
    @POST("seller/logout")
    Observable<PostBean> logout();

    //获取APP版本信息
    @POST("getAppVersion")
    @FormUrlEncoded
    Observable<VersionBean> getVersion(@Field("type")String type);
}
