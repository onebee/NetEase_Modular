package com.one.netease.personal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.one.netease.annotation.ARouter;
import com.one.netease.annotation.Parameter;
import com.one.netease.arouter.api.ParameterManager;
import com.one.netease.arouter.api.RouterManager;
import com.one.netease.common.base.BaseActivity;
import com.one.netease.common.utils.Cons;
import com.one.netease.order.R;
@ARouter(path = "/personal/Personal_MainActivity")
public class Personal_MainActivity extends BaseActivity {


    @Parameter
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);
        Log.i(Cons.TAG,"order >> Personal_main_activity");

        ParameterManager.getInstance().loadParameter(this);
        Log.i(Cons.TAG, " personal 接收参数值: " + name);
    }


    public void jumpApp(View view) throws ClassNotFoundException {
        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withString("name","onebit")
                .navigation(this);

    }

    public void jumpOrder(View view) throws ClassNotFoundException {
        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withResultString("name","onebit")
                .navigation(this,155);
    }

}
