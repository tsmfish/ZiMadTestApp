package ua.pavel.malko.android.zimadtestapp;

import android.app.Application;

import ua.pavel.malko.android.zimadtestapp.repository.NetworkRepository;

public class ZiMadApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        NetworkRepository.getInstance().init(this);
    }
}
