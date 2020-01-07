package com.one.netease.modular;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.one.netease.annotation.ARouter;
import com.one.netease.annotation.Parameter;
import com.one.netease.annotation.model.RouterBean;
import com.one.netease.arouter.api.core.ARouterLoadGroup;
import com.one.netease.arouter.api.core.ARouterLoadPath;
import com.one.netease.modular.apt.ARouter$$Group$$order;
import com.one.netease.modular.apt.ARouter$$Group$$personal;

import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {


    @Parameter
    String name;

    @Parameter(name = "agex")
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = getIntent().getStringExtra("name");
        age = getIntent().getIntExtra("agex", age);
    }

    public void jumpOrder(View view) {
//        Intent intent = new Intent(this, Order_MainActivity.class);
//        intent.putExtra("name","onebit");
//        startActivity(intent);

        ARouterLoadGroup loadGroup = new ARouter$$Group$$order();
        Map<String, Class<? extends ARouterLoadPath>> groupMap = loadGroup.loadGroup();

        Class<? extends ARouterLoadPath> clazz = groupMap.get("order");
        // 类加载
        try {
            ARouterLoadPath path = clazz.newInstance();


            Map<String, RouterBean> pathMap = path.loadPath();
            // 获取personal/Personal_MainActivity 对象
            RouterBean routerBean = pathMap.get("/order/Order_MainActivity");
            if (routerBean != null) {
                Intent intent1 = new Intent(this, routerBean.getClazz());
                intent1.putExtra("name", "onebit");
                intent1.putExtra("agex", 30);
                startActivity(intent1);

            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void jumpPersonal(View view) {
//        Intent intent = new Intent(this, Personal_MainActivity.class);
//        intent.putExtra("name","personal");
//        startActivity(intent);

//         最终集成化模式,所有子模块APT生成的类,都会打包到apk 中
        ARouterLoadGroup loadGroup = new ARouter$$Group$$personal();
        Map<String, Class<? extends ARouterLoadPath>> groupMap = loadGroup.loadGroup();

        Class<? extends ARouterLoadPath> clazz = groupMap.get("personal");
        // 类加载
        try {
            ARouterLoadPath path = clazz.newInstance();


            Map<String, RouterBean> pathMap = path.loadPath();
            // 获取personal/Personal_MainActivity 对象
            RouterBean routerBean = pathMap.get("/personal/Personal_MainActivity");
            if (routerBean != null) {
                Intent intent = new Intent(this, routerBean.getClazz());
                intent.putExtra("name", "onebit");
                startActivity(intent);

            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
