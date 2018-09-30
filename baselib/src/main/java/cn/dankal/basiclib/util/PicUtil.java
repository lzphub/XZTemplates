package cn.dankal.basiclib.util;

import android.widget.ImageView;

import cn.dankal.basiclib.util.image.PicUtils;

/**
 * Date: 2018/7/30.
 * Time: 11:47
 * classDescription:
 *
 * @author fred
 */
public class PicUtil {
    /**
     * 头像占位图
     *
     * @param imageView
     * @param photo
     */
    public static void setHeadPhoto(final ImageView imageView, final String photo) {
        PicUtils.loadAvatar(photo,imageView);
    }


    /**
     * 商品设置图片
     * @param imageView
     * @param photo
     */
    public static void setPhoto(final ImageView imageView, final String photo) {
        PicUtils.loadNormal(photo,imageView);
    }
}
