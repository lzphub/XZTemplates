package cn.dankal.basiclib.api;

import cn.dankal.annotations.ApiFactory;
import cn.dankal.basiclib.base.BaseResult;
import cn.dankal.basiclib.pojo.CheckCode;
import cn.dankal.basiclib.pojo.UserInfoBean;
import cn.dankal.basiclib.pojo.UserResponseBody;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Date: 2018/7/27.
 * Time: 17:44
 * classDescription:
 * 用户
 *
 * @author fred
 */

@ApiFactory(value = BaseApi.class)
public interface UserService {

    /**
     * 获取验证码 scalar
     * 找回密码:pass 设置支付密码: set_pay 绑定银行卡 bindcard
     */
    @GET("partner/Send")
    Observable<String> obtainVerifyCode(@Query("mobile") String moblie, @Query("send_type") String type);

    /**
     * 检查验证码 key
     */
    @POST("partner/Send/checkCode")
    @FormUrlEncoded
    Observable<CheckCode> verifyCode(@Field("mobile") String mobile,
                                     @Field("code") String code,
                                     @Field("send_type") String send_type);

    /**
     * 设置密码 scalar
     */
    @POST("partner/User/resetPassword")
    @FormUrlEncoded
    Observable<String> resetPassword(@Field("mobile") String mobile, @Field("key") String key, @Field("password") String password);

    /**
     * 登录
     */
    @POST("partner/User/login")
    @FormUrlEncoded
    Observable<UserResponseBody> login(@Field("account") String account, @Field("password") String password);

    /**
     * 获取用户信息
     *
     * @return
     */
    @GET("partner/User")
    Observable<BaseResult<UserInfoBean>> getUserInfo();


    /**
     * 修改负责区域
     *
     * @param region
     * @return
     */
    @POST("partner/User/updateRegion")
    @FormUrlEncoded
    Observable<String> updateRegion(@Field("region") String region);

    /**
     * 修改性别
     *
     * @param gender
     * @return
     */
    @POST("partner/User/updateGender")
    @FormUrlEncoded
    Observable<String> updateGender(@Field("gender") String gender);

    /**
     * 修改姓名
     *
     * @param name
     * @return
     */
    @POST("partner/User/updateName")
    @FormUrlEncoded
    Observable<String> updateName(@Field("name") String name);

    /**
     * 修改头像
     * @param avatar 头像相对地址
     * @return
     */
    @POST("partner/User/updateAvatar")
    @FormUrlEncoded
    Observable<String> updateAvatar(@Field("avatar") String avatar);

    /**
     * 更新token
     * @param token
     * @return
     */
    @POST("partner/User/updateToken")
    @FormUrlEncoded
    Observable<UserResponseBody.TokenBean> updateToken(@Field("refresh_token") String token);


    /**
     * 退出登录
     * @return
     */
    @GET("app/User/logout")
    Observable<String> logout();

}
