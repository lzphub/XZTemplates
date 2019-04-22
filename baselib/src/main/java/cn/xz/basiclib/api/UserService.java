package cn.xz.basiclib.api;

import cn.xz.basiclib.bean.PostBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import cn.xz.annotations.ApiFactory;

/**
 * classDescription:
 * 用户
 */

@ApiFactory(value = BaseApi.class)
public interface UserService {

    /**
     * 获取验证码
     */
    @POST("sendSms")
    @FormUrlEncoded
    Observable<PostBean> obtainVerifyCode(@Field("phone") String phone);

}
