package com.company.domain;

// 1. There's a good practice to separate classes to particular layers and avoid using inner classes.
//    Inner class makes sense if it's private. But in our case both inner classes are public,
//    so it's better to make them outer.
//    Moreover, DummyDao class is a service so it's better to structure all classes by functional layers.
// 2. By the naming convention the field names in Java should have cammelCase style beginning with low case letter
// 3. All class fields should be private to encapsulate information. To get access for them, setters and getters
//    are used.
// 4. There's a good approach to declare input parameters of methods as final to make them immutable
// 5. To force using methods in current package only, they should be without a modifier.
//    If methods can be used in subclasses only, they should be protected.
//    For getting access to methods from everywhere, they should be public.

public class User {

    private String userName;
    private String userSurname;

    public User() {
    }

    public User(final String userName) {
        this.userName = userName;
    }

    public User(final String userName, final String userSurname) {
        this.userName = userName;
        this.userSurname = userSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(final String userSurname) {
        this.userSurname = userSurname;
    }

    // 1. The method equals() should override particular method in Object.class
    // 2. Some additional checks are added
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        if (user.userName != null ? !user.userName.equals(userName) : user.userName != null) {
            return false;
        }
        return user.userSurname != null ? user.userSurname.equals(userSurname) : user.userSurname == null;
    }

    // Methods equals() and hashCode() must be overwritten both together
    @Override
    public int hashCode() {
        return 31 * (userName != null ? userName.hashCode() : 0) + (userSurname != null ? userSurname.hashCode() : 0);
    }
}