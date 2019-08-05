package com.wya.env.module.login

import android.content.Intent
import com.wya.env.module.MainActivity
import com.wya.env.R
import com.wya.env.base.BaseActivity
import com.wya.env.common.CommonValue
import com.wya.env.util.SaveSharedPreferences
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

/**
 * @date: 2018/4/8 13:58
 * @author: Chunjiang Mao
 * @classname: StartUpActivity
 * @describe: 启动页
 */

class StartUpActivity : BaseActivity() {

    override fun initView() {
        showToolBar(false)
        setBackgroundColor(R.color.white, true)
        //是否登录
        val isLogin = SaveSharedPreferences.getBoolean(this, CommonValue.IS_LOGIN)
        Observable.just(1).delay(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (isLogin) {
                        startActivity(Intent(this@StartUpActivity, MainActivity::class.java))
                        finish()
                    } else {
                        startActivity(Intent(this@StartUpActivity, LoginActivity::class.java))
                        finish()
                    }
                }
    }

    override fun getLayoutId(): Int {
        return R.layout.start_up_activity
    }
}
