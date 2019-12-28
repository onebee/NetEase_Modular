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

        if (getIntent() != null) {

            Log.e(Cons.TAG, getIntent().getStringExtra("name"));
        }
    }

    public void jumpApp(View view) throws ClassNotFoundException {
//        // 类加载方式
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

    public void jumpPersonal(View view) throws ClassNotFoundException {

//        Class targetClass = Class.forName("com.one.netease.personal.Personal_MainActivity");
//        Intent intent = new Intent(this, targetClass);
//        intent.putExtra("name","onebit");
//        startActivity(intent);

//        Class<?> targetClass = RecordPathManager.getTargetClass("personal", "Personal_MainActivity");
//        if (targetClass == null) {
//            Log.e(Cons.TAG,"targetClass 为空");
//        }
//        Intent intent = new Intent(this, targetClass);
//        intent.putExtra("name","onebit");
//        startActivity(intent);
    }
}
