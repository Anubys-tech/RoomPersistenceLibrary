package com.app.androidkt.librarymanagment;

import com.app.androidkt.librarymanagment.vo.Address;
import com.app.androidkt.librarymanagment.vo.Book;
import com.app.androidkt.librarymanagment.vo.User;

import java.util.Date;

/**
 * Created by brijesh on 28/5/17.
 */

public class TestUtil {
    public static final User createUser(int uid) {
        Address address = new Address();
        address.setCity("Pune");
        address.setPostCode("362625");
        address.setState("MH");

        User user = new User();
        user.address=address;
        user.firstName="Don";
        user.createDate=new Date();
        user.userId=uid;
        return user;
    }

    public static final Book createBook(int user_id) {
        Book book = new Book();
        book.setTitle("Test Book Title");
        book.setUserId(user_id);
        return book;
    }
}
