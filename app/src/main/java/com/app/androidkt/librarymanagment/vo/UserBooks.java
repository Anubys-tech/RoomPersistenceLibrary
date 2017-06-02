package com.app.androidkt.librarymanagment.vo;

/**
 * Created by brijesh on 28/5/17.
 */

public class UserBooks extends User {
    public int borrowe;

    @Override
    public boolean equals(Object obj) {
        UserBooks userBooks= (UserBooks) obj;
        if(!userBooks.firstName.equals(this.firstName))
            return false;

        if(userBooks.borrowe!=this.borrowe)
            return false;

        if(!userBooks.address.equals(this.address))
            return false;

        return true;
    }
}
