package cn.dankal.basiclib.domain;


import java.io.IOException;

import cn.dankal.basiclib.DKUserManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author vane
 */
public class TokenInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
//        originalRequest.newBuilder().header("Content-Type", "application/json;charset=UTF-8").build();
        if (DKUserManager.getUserInfo() == null || !DKUserManager.isLogined()) {
            return chain.proceed(originalRequest);
        } else {
            String accessToken = DKUserManager.getUserToken().getAccessToken();
            if (accessToken != null) {
                Request requestAuthorised = originalRequest.newBuilder()
                        .header("X-Access-Token", accessToken)
                        .build();
                return chain.proceed(requestAuthorised);
            }
            return chain.proceed(originalRequest);
        }
    }
}
