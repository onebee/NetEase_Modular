package com.one.netease.order.debug;

import android.os.Bundle;
import android.util.Log;

import com.one.netease.common.base.BaseActivity;
import com.one.netease.common.utils.Cons;
import com.one.netease.order.R;

import androidx.annotation.Nullable;

/**
 * @author diaokaibin@gmail.com on 2019-12-22.
 */
public class Order_debug_activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_debug_activity_main);
        Log.i(Cons.TAG,"order >> Order_debug_activity");
    }
}
