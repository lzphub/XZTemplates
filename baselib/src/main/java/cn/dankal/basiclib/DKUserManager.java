package cn.dankal.basiclib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import cn.dankal.basiclib.pojo.UserInfoBean;
import cn.dankal.basiclib.pojo.UserResponseBody;
import cn.dankal.basiclib.util.PreferenceUtil;


/**
 * @author vane
 */
public class DKUserManager {

    private static Context mContext = DankalApplication.getContext();
    private static SharedPreferences mSpUserInfo;
    private static SharedPreferences mSpToken;
    private static final String PreferenceUserInfo = "userinfo";
    private static final String PreferenceToken = "token";
    private static UserInfoBean userInfo;
    private static UserResponseBody.TokenBean userToken;

    static {
        mSpUserInfo = mContext.getSharedPreferences(PreferenceUserInfo, Context.MODE_PRIVATE);
        mSpToken = mContext.getSharedPreferences(PreferenceToken, Context.MODE_PRIVATE);
    }
 

    /**
     * 最初mUserInfo各属性内容为空，
     * 如登录后可更新当前的UserInfo和本地的缓存
     */
    public static void saveUserInfo(UserResponseBody userResponseBody) {
        UserInfoBean userInfo = userResponseBody.getUserInfo();
        UserResponseBody.TokenBean token = userResponseBody.getToken();
        if (userInfo!=null) {
            PreferenceUtil.updateBean(mSpUserInfo, getUserInfo(), userInfo);
        }
        if (token!=null) {
            PreferenceUtil.updateBean(mSpToken, getUserToken(), token);
        }
    }

    public static void updateUserInfo(UserInfoBean userInfo) {
        if (userInfo!=null) {
            PreferenceUtil.updateBean(mSpUserInfo, getUserInfo(), userInfo);
        }
    }
    public static void updateUserToken(UserResponseBody.TokenBean token) {
        if (token!=null) {
            PreferenceUtil.updateBean(mSpToken, getUserToken(), token);
        }
    }
    /**
     * 如果从本地缓存中获取对象为空则实例化一个空对象
     * 判断是否登录全程通过user_id是不是为0来判断而不是通过
     * mUserInfo是否等于null，防止UserManager.getUserInfo出现空指针
     */
    private static void readUserInfo() {
        userInfo = (UserInfoBean) PreferenceUtil.getBeanValue(mSpUserInfo, UserInfoBean.class);
        if (userInfo == null) {
            userInfo = new UserInfoBean();
        }
    }

    private static void readUserToken() {
        userToken = (UserResponseBody.TokenBean) PreferenceUtil.getBeanValue(mSpToken,
                UserResponseBody.TokenBean.class);
        if (userToken == null) {
            userToken = new UserResponseBody.TokenBean();
        }
    }
    /**
     * 清空缓存时调用
     */
    public static void resetUserInfo() {
        SharedPreferences.Editor editor = mSpUserInfo.edit();
        editor.clear();
        editor.apply();
        userInfo = new UserInfoBean();
    }
    public static void resetToken() {
        SharedPreferences.Editor editor = mSpToken.edit();
        editor.clear();
        editor.apply();
        userToken = new UserResponseBody.TokenBean();
    }

    /**
     * 判断已经登录
     */
    public static boolean isLogined() {
        return !TextUtils.isEmpty(getUserToken().getAccessToken());
    }

    public static UserResponseBody.TokenBean getUserToken() {
        if (userToken == null) {
            readUserToken();
        }
        return userToken;
    }

    public static UserInfoBean getUserInfo() {
        if (userInfo == null) {
            readUserInfo();
        }
        return userInfo;
    }
}
