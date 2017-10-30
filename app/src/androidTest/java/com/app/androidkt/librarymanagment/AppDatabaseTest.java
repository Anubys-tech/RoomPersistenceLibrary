package com.app.androidkt.librarymanagment;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.app.androidkt.librarymanagment.db.AppDatabase;
import com.app.androidkt.librarymanagment.db.DatabaseCreator;
import com.app.androidkt.librarymanagment.db.dao.BookDao;
import com.app.androidkt.librarymanagment.db.dao.UserDao;
import com.app.androidkt.librarymanagment.utils.GroupByUtil;
import com.app.androidkt.librarymanagment.vo.User;
import com.app.androidkt.librarymanagment.vo.UserWithAge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by brijesh on 28/5/17.
 */
@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest {

    private UserDao mUserDao;
    private BookDao mBookDao;
    private AppDatabase mDb;
    private String TAG = "TTTT";

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
    public void writeUser() throws Exception {
        DatabaseCreator databaseCreator = new DatabaseCreator();
        List<User> users = databaseCreator.getRandomUserList();
        mUserDao.insertAll(users);

    }

    @Test
    public void fetchAllUser() throws Exception {
        writeUser();
        List<User> userFromDb = LiveDataTestUtil.getValue(mUserDao.fetchAllUser());
        assertEquals(20, userFromDb.size());
    }

    @Test
    public void fetchUserBetweenDate() throws Exception {
        writeUser();
        List<User> userFromDb = LiveDataTestUtil.getValue(mUserDao.fetchUserBetweenDate(DatabaseCreator.dob[0], DatabaseCreator.dob[2]));
        assertEquals(20, userFromDb.size());
    }

    @Test
    public void fetchUserByDOB() throws Exception {
        writeUser();
        List<User> userFromDb = LiveDataTestUtil.getValue(mUserDao.fetchUserByUserDOB(DatabaseCreator.dob[0]));
        assertEquals(20, userFromDb.size());
    }

    @Test
    public void groupByUserDOBYear() throws Exception {
        writeUser();
        List<GroupByUtil> userFromDb = LiveDataTestUtil.getValue(mUserDao.groupByUserDOBYear());
        assertEquals(20, userFromDb.size());
    }

    @Test
    public void fetchUserByUserDOBYear() throws Exception {
        writeUser();
        List<User> userFromDb = LiveDataTestUtil.getValue(mUserDao.fetchUserByDOBYear("1999"));
        assertEquals(20, userFromDb.size());
    }

    @Test
    public void fetchUserByDuration() throws Exception {
        writeUser();
        List<User> userFromDb = LiveDataTestUtil.getValue(mUserDao.fetchUserByDuration("-2 months"));
        assertEquals(20, userFromDb.size());
    }

    @Test
    public void fetchUserOrderByDOB() throws Exception {
        writeUser();
        List<User> userFromDb = LiveDataTestUtil.getValue(mUserDao.fetchUserOrderByDOB());
        assertEquals(20, userFromDb.size());
    }

    @Test
    public void fetchUserWithAge() throws Exception {
        writeUser();
        List<UserWithAge> userFromDb = LiveDataTestUtil.getValue(mUserDao.fetchUserWithAge());
        assertEquals(20, userFromDb.size());
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
