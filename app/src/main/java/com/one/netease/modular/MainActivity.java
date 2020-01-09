package com.one.netease.modular;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.one.netease.annotation.ARouter;
import com.one.netease.annotation.Parameter;
import com.one.netease.arouter.api.ParameterManager;
import com.one.netease.arouter.api.RouterManager;
import com.one.netease.common.order.OrderDrawable;
import com.one.netease.common.utils.Cons;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {



    @Parameter(name = "/order/getDrawable")
    OrderDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.isRelease) {

            Log.i(Cons.TAG," 当前为: 集成化模式,除app 可以运行,其他子模块都是Android Library");
        } else {
            Log.i(Cons.TAG," 当前为: 组件化模式,app/order/personal 子模块可以独立运行");

        }


        ParameterManager.getInstance().loadParameter(this);
        ImageView imageView = findViewById(R.id.iv);
        imageView.setImageResource(drawable.getDrawable());


    }

    public void jumpOrder(View view) {

        RouterManager.getInstance()
                .build("/order/Order_MainActivity")
                .withString("name","onebit in MainActivity")
                .navigation(this,162);

    }

    public void jumpPersonal(View view) {
        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withString("name","onebit")
                .navigation(this,163);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Log.i(Cons.TAG,"onActivityResult : "+data.getStringExtra("call"));
        }

    }
}
