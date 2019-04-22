package cn.xz.basiclib.rx;

import android.util.Log;

import cn.xz.basiclib.base.BaseView;
import cn.xz.basiclib.domain.HttpStatusCode;
import cn.xz.basiclib.exception.LocalException;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Dankal Android Developer
 * @since 2018/7/18
 */

public abstract class AbstractSubscriber<T> implements Observer<T> {

    protected BaseView view;

    public AbstractSubscriber(BaseView view) {
        this.view = view;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (view != null) view.addNetworkRequest(d);
    }

    @Override
    public void onError(Throwable e) {
        if (e == null || view == null) return;
        if (e instanceof LocalException) {
            LocalException exception = (LocalException) e;
            //401 重新获取access token , 如果还返回412 就是refresh token 也失效了。需要重新登录
            if (exception.getErrorCode() == HttpStatusCode.TOKEN_INVAILD||
                    exception.getErrorCode() == HttpStatusCode.UNAUTHORIZED) {
                view.tokenInvalid();
                view.showToast("登录信息失效");
            } else {
                view.showToast(exception.getMsg());
            }
        } else {
            Log.e("SubscriberThrowable", e.getMessage());
        }
    }

    @Override
    public void onComplete() {
        this.view = null;
    }
}
