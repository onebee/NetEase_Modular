package com.one.netease.modular;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.one.netease.order.Order_MainActivity;
import com.one.netease.personal.Personal_MainActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpOrder(View view) {
        Intent intent = new Intent(this, Order_MainActivity.class);
        intent.putExtra("name","onebit");
        startActivity(intent);
    }

    public void jumpPersonal(View view) {
        Intent intent = new Intent(this, Personal_MainActivity.class);
        intent.putExtra("name","personal");
        startActivity(intent);
    }
}
