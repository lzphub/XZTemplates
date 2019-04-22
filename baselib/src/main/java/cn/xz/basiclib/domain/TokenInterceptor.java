package cn.xz.basiclib.domain;


import java.io.IOException;


import cn.xz.basiclib.XZUserManager;
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
//        if (XZUserManager.getUserInfo() == null || !XZUserManager.isLogined()) {
//            return chain.proceed(originalRequest);
//        } else {
//            String accessToken = XZUserManager.getUserInfo().getData().getToken();
            String accessToken = "2519efc0a1284854a922a41e89b9f9cc";
            if (accessToken != null) {
                Request requestAuthorised = originalRequest.newBuilder()
                        .header("token", accessToken)
                        .build();
                return chain.proceed(requestAuthorised);
            }
            return chain.proceed(originalRequest);
//        }
    }
}
