package com.one.netease.modular;

import android.os.Bundle;
import android.view.View;

import com.one.netease.annotation.ARouter;

import androidx.appcompat.app.AppCompatActivity;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void jumpOrder(View view) {

    }

    public void jumpPersonal(View view) {


    }
}
