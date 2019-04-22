package cn.xz.basiclib.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import cn.xz.basiclib.R;
import cn.xz.basiclib.XZApplication;
import cn.xz.basiclib.api.BaseApi;
import cn.xz.basiclib.util.image.PicUtils;


public class PicUtil {
    //设置Glide加载头像默认图
    public static RequestOptions setApply(){
        RequestOptions options = new RequestOptions();
        options.centerCrop()
                .placeholder(R.mipmap.pic_head_holder)
                .error(R.mipmap.pic_head_holder)
                .fallback(R.mipmap.pic_head_holder);
        return options;
    }

    //Glide加载头像
    public static void loadAvter(String url, ImageView imageView) {
        Glide.with(XZApplication.getContext()).load(BaseApi.IMAGE_URL + url).apply(setApply()).into(imageView);
    }

    //设置Glide加载默认图
    public static RequestOptions setApply2(){
        RequestOptions options = new RequestOptions();
        options.centerCrop()
                .placeholder(R.mipmap.pic_photo_holder)
                .error(R.mipmap.pic_photo_holder)
                .fallback(R.mipmap.pic_photo_holder);
        return options;
    }

    //Glide加载图片
    public static void loadImg(String url, ImageView imageView) {
        Glide.with(XZApplication.getContext()).load(BaseApi.IMAGE_URL + url).apply(setApply2()).into(imageView);
    }
}
