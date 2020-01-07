package com.one.netease.modular;

import android.os.Bundle;

import com.one.netease.annotation.ARouter;
import com.one.netease.annotation.Parameter;

import androidx.appcompat.app.AppCompatActivity;
@ARouter(path = "/app/Main3Activity")
public class Main3Activity extends AppCompatActivity {

    @Parameter
    String password;

    @Parameter
    int gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
}
