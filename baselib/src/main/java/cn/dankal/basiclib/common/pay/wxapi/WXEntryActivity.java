package cn.dankal.basiclib.common.pay.wxapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import cn.dankal.zc.ActivityManager;
import cn.dankal.zc.LoginActivity;
import cn.dankal.zc.R;
import cn.dankal.zc.WebViewActivity;

import static com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode.ERR_OK;

/**
 * description: 微信
 *
 * @author vane
 * @since 2018/3/14
 */

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    private IWXAPI iwxapi;

    public static final String WX_APP_ID = WxConstants.WX_APP_ID;
    private static final String TAG = "WXEntryActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_pay);
        getWindow().setBackgroundDrawableResource(R.color.transparent);

        iwxapi = WXAPIFactory.createWXAPI(this, WX_APP_ID, false);
        iwxapi.registerApp(WX_APP_ID);
        iwxapi.handleIntent(getIntent(), this);

    }


    @Override
    public void onReq(BaseReq baseReq) {
        Log.e(TAG, "onReq: ");
    }

    @SuppressLint("CheckResult")
    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.errCode == ERR_OK && baseResp instanceof SendAuth.Resp) {
            SendAuth.Resp resp = (SendAuth.Resp) baseResp;
            String code = resp.code;
            Log.e(TAG, "onResp: " + code);

            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("code", code);
            startActivity(intent);

            ActivityManager.getAppManager().finishActivity(LoginActivity.class);
            finish();
        } else if (baseResp.errCode == ERR_OK) {
            //分享成功
        } else {
            showToast("微信授权失败");
            WXEntryActivity.this.finish();
        }

    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        iwxapi.handleIntent(intent, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iwxapi.unregisterApp();
    }




}
