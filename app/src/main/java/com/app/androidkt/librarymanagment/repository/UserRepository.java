package com.app.androidkt.librarymanagment.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;

import com.app.androidkt.librarymanagment.LibApp;
import com.app.androidkt.librarymanagment.db.AppDatabase;
import com.app.androidkt.librarymanagment.db.DatabaseCreator;
import com.app.androidkt.librarymanagment.vo.User;

import java.util.List;

/**
 * Created by brijesh on 27/5/17.
 */

public class UserRepository {

    AppDatabase appDatabase;
    DatabaseCreator databaseCreator;

    public UserRepository(LibApp libApp) {
        appDatabase = Room.databaseBuilder(libApp, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        databaseCreator = new DatabaseCreator();
    }


    public void insertUser() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.userDao().insertAll(databaseCreator.getRandomUserList());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
    }

    public LiveData<Integer> deleteUserByState(final String... state) {
        final MutableLiveData<Integer> longMutableLiveData = new MutableLiveData<>();

        new AsyncTask<Void, Void, Integer>() {

            @Override
            protected Integer doInBackground(Void... voids) {
                return appDatabase.userDao().deleteUserByState(state);
            }

            @Override
            protected void onPostExecute(Integer aLong) {
                super.onPostExecute(aLong);
                longMutableLiveData.setValue(aLong);
            }
        }.execute();

        return longMutableLiveData;
    }

    public LiveData<List<User>> getAllUser() {
        return appDatabase.userDao().fetchAllUser();
    }

    public LiveData<Long> updateAddressByState(final String[] state, final String street) {
        final MutableLiveData<Long> longMutableLiveData = new MutableLiveData<>();
        new AsyncTask<Void, Void, Long>() {

            @Override
            protected Long doInBackground(Void... voids) {
                return appDatabase.userDao().updateAddressByState(state, street);
            }

            @Override
            protected void onPostExecute(Long aLong) {
                super.onPostExecute(aLong);
                longMutableLiveData.setValue(aLong);
            }
        }.execute();
        return longMutableLiveData;
    }
}
