package com.app.androidkt.librarymanagment.vo;

import android.arch.persistence.room.Embedded;

/**
 * Created by brijesh on 30/10/17.
 */

public class UserWithAge {
    @Embedded
    public User user;

    public int age;
}
