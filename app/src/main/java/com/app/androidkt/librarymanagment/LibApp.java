package com.app.androidkt.librarymanagment;

import android.app.Application;

import com.app.androidkt.librarymanagment.db.AppDatabase;
import com.facebook.stetho.Stetho;

/**
 * Created by brijesh on 27/5/17.
 */

public class LibApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        deleteDatabase(AppDatabase.DATABASE_NAME);
    }
}
