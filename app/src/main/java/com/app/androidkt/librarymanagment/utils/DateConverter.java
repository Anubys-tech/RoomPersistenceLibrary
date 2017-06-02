package com.app.androidkt.librarymanagment.utils;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by brijesh on 27/5/17.
 */

public class DateConverter {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date value) {
        return value == null ? null : value.getTime();
    }
}
