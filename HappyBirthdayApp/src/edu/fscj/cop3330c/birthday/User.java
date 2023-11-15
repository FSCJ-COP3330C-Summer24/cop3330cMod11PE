// User.java
// D. Singletary
// 10/24/23
// user classes

package edu.fscj.cop3330c.birthday;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Locale;

// user class
public class User implements Serializable {
    private StringBuilder name;
    private String email;
    private ZonedDateTime birthday;

    public User() { }

    public User(String fName, String lName, String email,
                ZonedDateTime birthday) {
        this.name = new StringBuilder();
        this.name.append(fName).append(" ").append(lName);
        this.email = email;
        this.birthday = birthday;
    }

    public StringBuilder getName() {
        return name;
    }

    public String getEmail() { return email; }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return this.name + "," + this.birthday;
    }
}

class UserWithLocale extends User {
    private User user;
    private Locale locale;

    // overload to allow previously instantiated user
    public UserWithLocale(User user, Locale locale) {
        this.user = user;
        this.locale = locale;
    }

    // overload to allow previously instantiated user
    public UserWithLocale(String fName, String lName, String email,
                          ZonedDateTime birthday, Locale locale) {
        this.user = new User(fName, lName, email, birthday);
        this.locale = locale;
    }

    public Locale getLocale() { return locale; }

    // overrides
    @Override
    public StringBuilder getName() {
        return user.getName();
    }
    @Override
    public String getEmail() { return user.getEmail(); }
    @Override
    public ZonedDateTime getBirthday() { return user.getBirthday(); }
    @Override
    public String toString() {
        return this.user + "," + this.locale;
    }
}


