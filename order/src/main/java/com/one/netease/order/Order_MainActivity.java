package com.one.netease.order;

import android.os.Bundle;
import android.util.Log;

import com.one.netease.common.base.BaseActivity;
import com.one.netease.common.utils.Cons;

public class Order_MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);
        Log.i(Cons.TAG,"order >> Order_main_activity");
    }
}
