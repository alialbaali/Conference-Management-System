package com.confy.app;

import android.app.Application;

import timber.log.Timber;

public class ConfyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
