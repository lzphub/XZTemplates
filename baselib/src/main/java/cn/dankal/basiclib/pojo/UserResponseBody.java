package cn.dankal.basiclib.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Date: 2018/7/27.
 * Time: 18:01
 * classDescription:
 *
 * @author fred
 */
public class UserResponseBody {

    /**
     * user_info : {"uuid":"uuid","name":"name","avatar":"avatar","new_avatar":"new_avatar","gender":"女","mobile":"mobile","binding_count":"binding_count","region":"负责区域","qrcode":"qrcode","supplier":"齐是多","feedback":"91.9%","response":"99%","custom_active":"99%","k_bean":100}
     * token : {"access_token":"access_token","refresh_token":"refresh_token","expiry_time":"expiry_time"}
     */

    @JSONField(name = "user_info")
    private UserInfoBean userInfo;
    @JSONField(name = "token")
    private TokenBean token;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public TokenBean getToken() {
        return token;
    }

    public void setToken(TokenBean token) {
        this.token = token;
    }

    public static class TokenBean {
        /**
         * access_token : access_token
         * refresh_token : refresh_token
         * expiry_time : expiry_time
         */

        @JSONField(name = "access_token")
        private String accessToken;
        @JSONField(name = "refresh_token")
        private String refreshToken;
        @JSONField(name = "expiry_time")
        private String expiryTime;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getExpiryTime() {
            return expiryTime;
        }

        public void setExpiryTime(String expiryTime) {
            this.expiryTime = expiryTime;
        }
    }
}
