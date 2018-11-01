/*
package cn.dankal.basiclib.common.share.mob;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.zhy.autolayout.AutoLinearLayout;

import cn.dankal.dklibrary.Constant;
import cn.dankal.dklibrary.R;
import cn.dankal.dklibrary.dkutil.DkToastUtil;
import cn.dankal.dklibrary.dkutil.Logger;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.favorite.WechatFavorite;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

*/
/**
 * Created by Zoro丶源 on 2016/12/3.
 *//*

public class ShareDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private AutoLinearLayout llQQ, llWechat, llWechatMoments,llQQZone,llWechatCollect;
    private MobShareUtil mobShareUtil;
    private String title, text, img, url;
    private static final String ID = "?share_id=";
    private static final String TOKEN = "&token=";
    private static final String IMG = "&img=";

    private static final String baseUrl = "http://share.inffur.com";

    public ShareDialog(Context context) {
        this(context, 0);
    }

    public ShareDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    public ShareDialog setText(String text) {
        this.text = text;
        return this;
    }

    public ShareDialog setImg(String img) {
        this.img = Constant.domain + img;
        return this;
    }

    public ShareDialog setUrl(String id, String token, String img) {
        this.url = baseUrl + ID + id*/
/* + TOKEN + token + IMG + img*//*
;
        return this;
    }

    public ShareDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        title = "快看我用手机定制了一个柜子！";
        text = "易道与现有的3D建模工具集成在一起，点击查看。";
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_share, null);
        llQQ = dialogView.findViewById(R.id.ll_qq);
        llWechat = dialogView.findViewById(R.id.ll_wechat);
        llWechatMoments = dialogView.findViewById(R.id.ll_wechatmoments);
        llQQZone = dialogView.findViewById(R.id.ll_qqzone);
        llWechatCollect = dialogView.findViewById(R.id.ll_wechatcollect);

        llQQ.setOnClickListener(this);
        llWechat.setOnClickListener(this);
        llWechatMoments.setOnClickListener(this);
        llQQZone.setOnClickListener(this);
        llWechatCollect.setOnClickListener(this);

        //获得dialog的window窗口
        Window window = this.getWindow();                //设置dialog在屏幕底部
        window.setGravity(Gravity.BOTTOM);                //设置dialog弹出时的动画效果，从屏幕底部向上弹出
//      window.getDecorView().setPadding(0, 0, 0, 0);                //获得window窗口的属性
//      WindowManager.LayoutParams lp = window.getAttributes();                //设置窗口宽度为充满全屏
//      lp.width = AutoUtils.getPercentWidthSize(500);                //设置窗口高度为包裹内容
//      lp.height = AutoUtils.getPercentHeightSize(400);                //将设置好的属性set回去
//      window.setAttributes(lp);
        setContentView(dialogView);

        mobShareUtil = new MobShareUtil();
        mobShareUtil.setOnMobShareListener(new MobShareUtil.OnMobShareListener() {
            @Override
            public void onComplete() {
                DkToastUtil.toToast("分享成功");
                dismiss();
            }

            @Override
            public void onError(Throwable throwable) {
                Logger.e("onError: " + throwable);
                dismiss();
            }

            @Override
            public void onCancel() {
                dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.ll_qq) {
            mobShareUtil.init(title, text, img, url);
            mobShareUtil.share(QQ.NAME);
        } else if (i == R.id.ll_wechat) {
            mobShareUtil.init(title, text, img, url);
            mobShareUtil.share(Wechat.NAME);
        } else if (i == R.id.ll_wechatmoments) {
            mobShareUtil.init(title, text, img, url);
            mobShareUtil.share(WechatMoments.NAME);
        } else if (i == R.id.ll_wechatcollect) {
            mobShareUtil.init(title, text, img, url);
            mobShareUtil.share(WechatFavorite.NAME);
        } else if (i == R.id.ll_qqzone) {
            mobShareUtil.init(title, text, img, url);
            mobShareUtil.share(QZone.NAME);
        }
    }
}
*/
