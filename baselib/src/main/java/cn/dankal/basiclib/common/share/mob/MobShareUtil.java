//package cn.dankal.basiclib.common.share.mob;
//
//import java.util.HashMap;
//
//import cn.sharesdk.framework.Platform;
//import cn.sharesdk.framework.PlatformActionListener;
//import cn.sharesdk.framework.ShareSDK;
//import cn.sharesdk.tencent.qq.QQ;
//import cn.sharesdk.tencent.qzone.QZone;
//import cn.sharesdk.wechat.favorite.WechatFavorite;
//import cn.sharesdk.wechat.friends.Wechat;
//import cn.sharesdk.wechat.moments.WechatMoments;
//
//
///**
// * Created by Fred on 2016/10/25.
// */
//
//public class MobShareUtil implements PlatformActionListener {
//    private String url;
//    private String title;
//    private String img;
//    private String text;
//    private OnMobShareListener onMobShareListener;
//
//    /**
//     * @param title 标题
//     * @param text  文本
//     * @param img   图片地址
//     * @param url   链接地址
//     */
//    public void init(String title, String text, String img, String url) {
//        this.title = title;
//        this.img = img;
//        this.text = text;
//        this.url = url;
//    }
//
//    /* public  MobShareUtil getInstance(){
//         if (this instanceof MobShareUtil)
//             return this;
//
//     }*/
//    public void share(String platformName) {
//        Platform.ShareParams spm = null;
//        if (platformName.equals(WechatMoments.NAME)) {
//            spm = new WechatMoments.ShareParams();
//        } else if (platformName.equals(Wechat.NAME)) {
//            spm = new Wechat.ShareParams();
//        } else if (platformName.equals(QQ.NAME)) {
//            spm = new QQ.ShareParams();
//        }else if (platformName.equals(QZone.NAME)) {
//            spm = new QZone.ShareParams();
//        }else if (platformName.equals(WechatFavorite.NAME)) {
//            spm = new WechatFavorite.ShareParams();
//        }
//        spm.setShareType(Platform.SHARE_WEBPAGE); //非常重要：一定要设置分享属性
//        spm.setTitle(title);  //分享标题
//        spm.setTitleUrl(url);
//        spm.setText(text);   //分享文本
//        spm.setImageUrl(img);//网络图片rul
//        spm.setUrl(url);   //网友点进链接后，可以看到分享的详情
//        Platform platform = ShareSDK.getPlatform(platformName);
//        platform.setPlatformActionListener(this); // 设置分享事件回调
//        // 执行分享
//        platform.share(spm);
//    }
//
//    @Override
//    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//        onMobShareListener.onComplete();
//    }
//
//    @Override
//    public void onError(Platform platform, int i, Throwable throwable) {
//        onMobShareListener.onError(throwable);
//
//    }
//
//    @Override
//    public void onCancel(Platform platform, int i) {
//        onMobShareListener.onCancel();
//
//    }
//
//    public void setOnMobShareListener(OnMobShareListener onMobShareListener) {
//        this.onMobShareListener = onMobShareListener;
//    }
//
//    public interface OnMobShareListener {
//        void onComplete();
//
//        void onError(Throwable throwable);
//
//        void onCancel();
//    }
//}
//
