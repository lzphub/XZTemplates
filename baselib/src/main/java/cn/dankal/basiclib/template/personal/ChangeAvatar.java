package cn.dankal.basiclib.template.personal;

import android.content.Intent;
import android.widget.ImageView;

import cn.dankal.basiclib.common.camera.CameraHandler;

/**
 * Date: 2018/8/2.
 * Time: 11:05
 * classDescription:
 * 修改头像
 *
 * @author fred
 */
public interface ChangeAvatar {
    void checkPermission(CameraHandler cameraHandler);
    void setIvHead(ImageView imageView);
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
