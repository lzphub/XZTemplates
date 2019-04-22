package cn.xz.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zero
 * <p>
 * Date: 2017-08-21.
 * Time: 15:40
 * <p>
 * className: CheckLogin
 * classDescription: 验证登录
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CheckLogin {


    int requesrCode() default -1;

}
