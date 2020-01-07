package com.one.netease.order;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.one.netease.annotation.ARouter;
import com.one.netease.common.base.BaseActivity;
import com.one.netease.common.utils.Cons;
@ARouter(path = "/order/Order_MainActivity")
public class Order_MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);
        Log.i(Cons.TAG,"order >> Order_main_activity");


    }

    public void jumpApp(View view) throws ClassNotFoundException {

    }

    public void jumpPersonal(View view) throws ClassNotFoundException {


    }
}
