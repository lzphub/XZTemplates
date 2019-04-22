package cn.xz.basiclib.rx;

import android.util.Log;

//import com.hyphenate.chat.EMClient;

import cn.xz.basiclib.XZApplication;
import cn.xz.basiclib.R;
import cn.xz.basiclib.XZUserManager;
import cn.xz.basiclib.domain.HttpStatusCode;
import cn.xz.basiclib.exception.LocalException;
import cn.xz.basiclib.util.ActivityUtils;
import io.reactivex.Observer;

/**
 * @author Dankal Android Developer
 * @since 2018/7/18
 */

public abstract class NormalSubscriber<T> implements Observer<T> {

    @Override
    public void onError(Throwable e) {
        if (e instanceof LocalException) {
            LocalException exception = (LocalException) e;
            //401 重新获取access token , 如果还返回412 就是refresh token 也失效了。需要重新登录
            if (exception.getErrorCode() == HttpStatusCode.TOKEN_INVAILD
                    ||exception.getErrorCode() == HttpStatusCode.UNAUTHORIZED) {
//                EMClient.getInstance().logout(true);
                XZUserManager.resetUserInfo();
                ActivityUtils.finishAllActivities();
                try {
                    ActivityUtils.startActivity(Class.forName(XZApplication.getContext().getString(R.string.login_activity_path)));
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            } else {
            }
        } else {
            Log.e("SubscriberThrowable", e.getMessage());
        }
    }

    @Override
    public void onComplete() {
    }
}
