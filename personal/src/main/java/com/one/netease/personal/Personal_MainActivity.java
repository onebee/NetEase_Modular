package com.one.netease.personal;

import android.os.Bundle;
import android.util.Log;

import com.one.netease.common.base.BaseActivity;
import com.one.netease.common.utils.Cons;
import com.one.netease.order.R;

public class Personal_MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);
        Log.i(Cons.TAG,"order >> Personal_main_activity");
    }
}
