package com.example.estelle.cs_akazoo_app.base;

import android.app.Application;
import android.util.Log;

import timber.log.Timber;

public class AkazooApplication extends Application {

    public AkazooApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        Timber.i("application got created");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
