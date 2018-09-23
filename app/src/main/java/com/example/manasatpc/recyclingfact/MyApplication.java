package com.example.manasatpc.recyclingfact;

import android.app.Application;

import com.twitter.sdk.android.core.Twitter;

/**
 * Created by ManasatPC on 21/09/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Twitter.initialize(this);
    }
}
