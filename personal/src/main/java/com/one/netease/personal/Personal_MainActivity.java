package com.one.netease.personal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.one.netease.annotation.ARouter;
import com.one.netease.common.base.BaseActivity;
import com.one.netease.common.utils.Cons;
import com.one.netease.order.R;
@ARouter(path = "/personal/Personal_MainActivity")
public class Personal_MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);
        Log.i(Cons.TAG,"order >> Personal_main_activity");
    }


    public void jumpApp(View view) throws ClassNotFoundException {
//        Class targetClass = Class.forName("com.one.netease.modular.MainActivity");
//        Intent intent = new Intent(this, targetClass);
//        intent.putExtra("name","onebit");
//        startActivity(intent);
//        Class<?> targetClass = RecordPathManager.getTargetClass("app", "MainActivity");
//        if (targetClass == null) {
//            Log.e(Cons.TAG,"targetClass 为空");
//        }
//        Intent intent = new Intent(this, targetClass);
//        intent.putExtra("name","onebit");
//        startActivity(intent);

    }

    public void jumpOrder(View view) throws ClassNotFoundException {

//        Class targetClass = Class.forName("com.one.netease.order.Order_MainActivity");
//        Intent intent = new Intent(this, targetClass);
//        intent.putExtra("name","onebit");
//        startActivity(intent);

//        Class<?> targetClass = RecordPathManager.getTargetClass("order", "Order_MainActivity");
//        if (targetClass == null) {
//            Log.e(Cons.TAG,"targetClass 为空");
//        }
//        Intent intent = new Intent(this, targetClass);
//        intent.putExtra("name","onebit");
//        startActivity(intent);
    }

}
