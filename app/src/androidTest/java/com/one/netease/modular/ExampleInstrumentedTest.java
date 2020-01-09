package com.one.netease.modular;

import android.content.Context;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.one.netease.modular", appContext.getPackageName());
    }

    @Test
    public void hah() throws ClassNotFoundException, InstantiationException, IllegalAccessException {


        Class<?> clazz = Class.forName("com.one.netease.modular.MainActivity");
        Log.i(">>>", clazz.getName() + "   ----  " + clazz);
//        MainActivity main = (MainActivity) clazz.newInstance();
//
//        main.setHa();

    }
}
