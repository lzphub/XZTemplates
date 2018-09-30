package cn.dankal.basiclib.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Date: 2018/7/17.
 * Time: 11:30
 * classDescription:
 *
 * @author fred
 */
public class UserInfoBean {

    /**
     * uuid : uuid
     * name : name
     * avatar : avatar
     * new_avatar : new_avatar
     * gender : 女
     * mobile : mobile
     * binding_count : binding_count
     * region : 负责区域
     * qrcode : qrcode
     * brand : 齐是多
     * favorable_rate : 91.9%
     * response_rate : 99%
     * customer_activity : 99%
     * k_bean : 100
     * easemob_account : admin
     * easemob_password : 123321
     */

    @JSONField(name = "uuid")
    private String uuid;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "avatar")
    private String avatar;
    @JSONField(name = "new_avatar")
    private String newAvatar;
    @JSONField(name = "gender")
    private String gender;
    @JSONField(name = "mobile")
    private String mobile;
    @JSONField(name = "binding_count")
    private String bindingCount;
    @JSONField(name = "region")
    private String region;
    @JSONField(name = "brand")
    private String brand;
    @JSONField(name = "favorable_rate")
    private String favorableRate;
    @JSONField(name = "response_rate")
    private String responseRate;
    @JSONField(name = "customer_activity")
    private String customerActivity;
    @JSONField(name = "k_bean")
    private String kBean;
    @JSONField(name = "easemob_account")
    private String easemobAccount;
    @JSONField(name = "easemob_password")
    private String easemobPassword;


    @JSONField(name = "isset_pay_password")
    private boolean payPassword;

    public boolean getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(boolean payPassword) {
        this.payPassword = payPassword;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNewAvatar() {
        return newAvatar;
    }

    public void setNewAvatar(String newAvatar) {
        this.newAvatar = newAvatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBindingCount() {
        return bindingCount;
    }

    public void setBindingCount(String bindingCount) {
        this.bindingCount = bindingCount;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBrand() {
        return brand;
    }

    public UserInfoBean setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getkBean() {
        return kBean;
    }

    public UserInfoBean setkBean(String kBean) {
        this.kBean = kBean;
        return this;
    }

    public String getFavorableRate() {
        return favorableRate;
    }

    public void setFavorableRate(String favorableRate) {
        this.favorableRate = favorableRate;
    }

    public String getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(String responseRate) {
        this.responseRate = responseRate;
    }

    public String getCustomerActivity() {
        return customerActivity;
    }

    public void setCustomerActivity(String customerActivity) {
        this.customerActivity = customerActivity;
    }

    public String getKBean() {
        return kBean;
    }

    public void setKBean(String kBean) {
        this.kBean = kBean;
    }

    public String getEasemobAccount() {
        return easemobAccount;
    }

    public void setEasemobAccount(String easemobAccount) {
        this.easemobAccount = easemobAccount;
    }

    public String getEasemobPassword() {
        return easemobPassword;
    }

    public void setEasemobPassword(String easemobPassword) {
        this.easemobPassword = easemobPassword;
    }
}
