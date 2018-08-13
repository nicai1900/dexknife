package com.nicaiya.dexknife.demo;

import android.content.Context;
import android.support.multidex.MultiDexApplication;


public class App extends MultiDexApplication {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Test a = new Test();
        a.test();
    }


}
