package cn.xz.basiclib.pojo;

/**
 * Date: 2018/7/17.
 * Time: 11:30
 * classDescription:
 *
 * @author fred
 */
public class UserInfoBean {

    /**
     * code : 0
     * data : {"token":"76519F2E2ADEC7848088C7DDC64113F0","account":18802075356}
     * msg : null
     */

    private int code;
    private DataBean data;
    private Object msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * token : 76519F2E2ADEC7848088C7DDC64113F0
         * account : 18802075356
         */

        private String token;
        private long account;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getAccount() {
            return account;
        }

        public void setAccount(long account) {
            this.account = account;
        }
    }
}
