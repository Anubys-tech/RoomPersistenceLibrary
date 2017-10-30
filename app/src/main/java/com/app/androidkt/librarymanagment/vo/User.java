package com.app.androidkt.librarymanagment.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.app.androidkt.librarymanagment.utils.DateConverter;
import com.app.androidkt.librarymanagment.utils.TimestampConverter;

import java.util.Date;

/**
 * Created by brijesh on 27/5/17.
 */

//Table names in SQLite are case insensitive.
@Entity(indices = {@Index(value = "first_name")})
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    public long userId;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "created_date")
    @TypeConverters({TimestampConverter.class})
    public Date createDate;

    @ColumnInfo(name = "date_of_birth")
    @TypeConverters({DateConverter.class})
    public Date dob;

    @Embedded
    public Address address;

}
