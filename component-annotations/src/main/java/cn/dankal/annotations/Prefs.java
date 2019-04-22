package cn.xz.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * Created by Tony Shen on 16/3/28.
 */

@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Prefs {

    String key();

}
