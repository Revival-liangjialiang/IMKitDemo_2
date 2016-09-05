package com.example.k.imkittest;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by k on 2016/9/5.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
