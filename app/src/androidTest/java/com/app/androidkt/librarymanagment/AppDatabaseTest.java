package com.app.androidkt.librarymanagment;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.app.androidkt.librarymanagment.db.AppDatabase;
import com.app.androidkt.librarymanagment.db.dao.BookDao;
import com.app.androidkt.librarymanagment.db.dao.UserDao;
import com.app.androidkt.librarymanagment.vo.User;
import com.app.androidkt.librarymanagment.vo.UserBooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by brijesh on 28/5/17.
 */
@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest {

    private UserDao mUserDao;
    private BookDao mBookDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mUserDao = mDb.userDao();
        mBookDao = mDb.bookDao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
//        User user = new User();
//        user.createDate=new Date();
//        user.firstName="tttt";
//        mUserDao.insert(user);
//        List<User> byName = LiveDataTestUtil.getValue(mUserDao.gatAllUser());
//        assertEquals(byName.get(0).userId, -1);
    }

    @Test
    public void deleteTest() throws Exception {
//        User user;
//        mUserDao.insert(TestUtil.createUser(223));
//        mUserDao.deleteUser(223);
//        user = LiveDataTestUtil.getValue(mUserDao.findUserById());
//        assertNull(user);
    }

    @Test
    public void testJoin() throws Exception {
//        mUserDao.insert(TestUtil.createUser(1));
//        mBookDao.insertBook(TestUtil.createBook(1));
//        User user = LiveDataTestUtil.getValue(mUserDao.findUserById());
//        assertEquals(1, user.borrowe);
    }
}
