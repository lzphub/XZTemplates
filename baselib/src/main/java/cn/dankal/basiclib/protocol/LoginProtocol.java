package cn.dankal.basiclib.protocol;

/**
 * Created by fred
 * Date: 2018/9/28.
 * Time: 17:32
 * classDescription:
 */
public interface LoginProtocol extends BaseRouteProtocol {
    String PART = "/login/";

    String LOGIN=PART+"login";
}
