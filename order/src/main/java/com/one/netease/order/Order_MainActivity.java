package com.one.netease.order;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.one.netease.annotation.ARouter;
import com.one.netease.annotation.Parameter;
import com.one.netease.arouter.api.ParameterManager;
import com.one.netease.arouter.api.RouterManager;
import com.one.netease.common.base.BaseActivity;
import com.one.netease.common.utils.Cons;
@ARouter(path = "/order/Order_MainActivity")
public class Order_MainActivity extends BaseActivity {

    @Parameter
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);
        Log.i(Cons.TAG,"order >> Order_main_activity");

        // 懒加载,跳到哪个加载哪个类
        ParameterManager.getInstance().loadParameter(this);


        Log.i(Cons.TAG, "receive parameter : " + name);
    }

    public void jumpApp(View view) throws ClassNotFoundException {

    }

    public void jumpPersonal(View view) throws ClassNotFoundException {

        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withString("name","onebit")
                .navigation(this);

    }
}
