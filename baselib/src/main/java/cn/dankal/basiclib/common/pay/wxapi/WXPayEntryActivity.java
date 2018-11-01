package cn.dankal.basiclib.common.pay.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import cn.dankal.zc.R;

import static cn.dankal.zc.wxapi.WxConstants.PAY_FAILED;
import static cn.dankal.zc.wxapi.WxConstants.PAY_SUCCESS;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "WXPayEntryActivity";

    private IWXAPI api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_pay);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        api = WXAPIFactory.createWXAPI(this, WXEntryActivity.WX_APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {

        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            //如果支付成功
            if (resp.errCode == 0) {
                LocalBroadcastManager.getInstance(this).
                        sendBroadcast(new Intent(PAY_SUCCESS));
            }
            //取消或者失败
            else {
                LocalBroadcastManager.getInstance(this).
                        sendBroadcast(new Intent(PAY_FAILED));
            }
            finish();

        }
    }

}