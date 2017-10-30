package com.app.androidkt.librarymanagment.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.app.androidkt.librarymanagment.db.dao.BookDao;
import com.app.androidkt.librarymanagment.db.dao.UserDao;
import com.app.androidkt.librarymanagment.utils.DateConverter;
import com.app.androidkt.librarymanagment.vo.Book;
import com.app.androidkt.librarymanagment.vo.User;

/**
 * Created by brijesh on 27/5/17.
 */

@Database(entities = {User.class, Book.class}, version = 1)
abstract public class AppDatabase extends RoomDatabase {

    public static String DATABASE_NAME = "LibraryDb";

    public abstract UserDao userDao();

    public abstract BookDao bookDao();


}
