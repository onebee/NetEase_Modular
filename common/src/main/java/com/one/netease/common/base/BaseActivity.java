package com.one.netease.common.base;

import android.os.Bundle;
import android.util.Log;

import com.one.netease.common.utils.Cons;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author diaokaibin@gmail.com on 2019-12-22.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(Cons.TAG,"common/BaseActivity");
    }
}
