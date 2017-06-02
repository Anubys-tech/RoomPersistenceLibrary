package com.app.androidkt.librarymanagment.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.app.androidkt.librarymanagment.vo.Book;
import com.app.androidkt.librarymanagment.vo.UserBooks;

import java.util.List;

/**
 * Created by brijesh on 28/5/17.
 */

@Dao
public interface BookDao {

    @Insert
    void insertBooks(List<Book> books);

    @Query("SELECT user.*,count(book.user_id) as borrowe FROM user LEFT JOIN book ON user.user_id = book.user_id group by user.user_id,book.user_id")
    LiveData<List<UserBooks>> fetchBookBorrower();


}
