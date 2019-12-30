package com.one.netease.order;

import android.os.Bundle;

import com.one.netease.annotation.ARouter;

import androidx.appcompat.app.AppCompatActivity;
@ARouter(path = "/order/Order2_MainActivity")
public class Order2_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2_main);
    }
}
