package com.moxdroid.samplesharedpreferences;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by moxdroid on 2017-04-12.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
