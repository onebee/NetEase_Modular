package com.one.netease.modular;

import com.one.netease.arouter.api.core.ParameterLoad;

/**
 * @author diaokaibin@gmail.com on 2019-12-30.
 *
 *
 */
public class XActivity$$Paramter implements ParameterLoad {
    @Override
    public void loadParameter(Object target) {
        MainActivity t = (MainActivity) target;
        t.name = t.getIntent().getStringExtra("name");
        t.age = t.getIntent().getIntExtra("age",0);
    }
}
