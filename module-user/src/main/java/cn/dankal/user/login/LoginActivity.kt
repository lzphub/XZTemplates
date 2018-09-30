package cn.dankal.user.login

import android.os.Handler
import android.view.KeyEvent
import android.view.View
import api.UserServiceFactory
import butterknife.OnClick
import cn.dankal.basiclib.DKUserManager
import cn.dankal.basiclib.DankalApplication
import cn.dankal.basiclib.base.activity.BaseActivity
import cn.dankal.basiclib.pojo.UserResponseBody
import cn.dankal.basiclib.protocol.LoginProtocol.LOGIN
import cn.dankal.basiclib.rx.AbstractDialogSubscriber
import cn.dankal.basiclib.util.AppUtils
import cn.dankal.basiclib.util.StringUtil
import cn.dankal.basiclib.util.ToastUtils
import cn.dankal.user.R
import cn.dankal.user.R2
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = LOGIN)
class LoginActivity : BaseActivity() {

//    @Autowired
//    @JvmField var name: String? = null
//    @Autowired
//    @JvmField var age: Int? = 0

    private var exitTime: Long = 0

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initComponents() {}

    @OnClick(R2.id.bt_login, R2.id.tv_forget)
    fun onViewClicked(view: View) {
        val i = view.id
        if (i == R.id.bt_login) {
            val account = et_phone_num.text.toString()
            if (!StringUtil.checkPasswd(account)) {
                ToastUtils.showShort("请输入账号，数字、字母、符号，不允许特殊符号`'\\“ 空格")
                return
            }

            val pass = et_passwd.text.toString()
            if (!StringUtil.checkPasswd(pass) || pass.length < 6) {
                ToastUtils.showShort("请输入密码，6-20数字、字母、符号，不允许特殊符号`'\\“ 空格")
                return
            }

            accountLogin(account, pass)

        } else if (i == R.id.tv_forget) {
            //startActivity(new Intent(this, ForgetPasswdActivity.class));
        } else {}
    }

    /**
     * 账号登录
     *
     * @param phone
     * @param pass
     */
    private fun accountLogin(phone: String, pass: String) {
        UserServiceFactory.login(phone, pass).subscribe(object : AbstractDialogSubscriber<UserResponseBody>(this) {
            override fun onNext(userResponseBody: UserResponseBody) {
                val userInfo = userResponseBody.userInfo
                easeLogin(userInfo.easemobAccount, userInfo.easemobPassword)
                //              easeLogin("15018506776","123456");
                DKUserManager.saveUserInfo(userResponseBody)
            }
        })
    }

    /**
     * 环信登录
     *
     * @param phone
     * @param pass
     */
    private fun easeLogin(phone: String, pass: String) {
        DankalApplication.setLogin(true)

        /*showLoadingDialog();
        EMClient.getInstance().login(phone,
                pass, new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        runOnUiThread(() -> {
                            dismissLoadingDialog();
                            EMClient.getInstance().groupManager().loadAllGroups();
                            EMClient.getInstance().chatManager().loadAllConversations();
                            Log.d("main", "登录聊天服务器成功！");
                            DankalApplication.setLogin(true);
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        });
                    }

                    @Override
                    public void onProgress(int progress, String status) {
                    }

                    @Override
                    public void onError(int code, String message) {
                        Log.d("main", "登录聊天服务器失败！");
                    }
                });*/
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                ToastUtils.showShort("再按一次退出应用")
                exitTime = System.currentTimeMillis()
            } else {
                AppUtils.finishAllActivities()
                Handler().postDelayed({
                    try {
                        // 杀死该应用进程
                        android.os.Process.killProcess(android.os.Process.myPid())
                        System.exit(0)
                    } catch (e: Exception) {
                    }
                }, 500)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
