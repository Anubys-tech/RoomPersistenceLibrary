package com.app.androidkt.librarymanagment.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.app.androidkt.librarymanagment.vo.User;

import java.util.List;

/**
 * Created by brijesh on 27/5/17.
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> user);

    @Query("delete from user where state in (:state)")
    int deleteUserByState(String... state);

    @Query("delete from user where user_id=:id")
    int deleteUser(int id);

    @Query("select * from user where user_id=:id")
    LiveData<User> fetchUserByUserId(int id);

    @Query("select * from user")
    LiveData<List<User>> fetchAllUser();

    @Query("update user set street=:street where state in(:state)")
    long updateAddressByState(String[] state, String street);
}
