package cn.dankal.basiclib.protocol;


/**
 * @author vane
 * @since 2018/7/19
 */

public interface BaseRouteProtocol {
    String SCHEME = "native";
    String HOST = "xx.dankal.cn";
    String PATH = SCHEME + "://" + HOST;
}
