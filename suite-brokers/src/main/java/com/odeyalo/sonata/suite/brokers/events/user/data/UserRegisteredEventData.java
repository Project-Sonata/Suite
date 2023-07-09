package com.odeyalo.sonata.suite.brokers.events.user.data;

import java.util.Objects;

public class UserRegisteredEventData {
    private String id;
    private String email;

    public UserRegisteredEventData() {
    }

    public UserRegisteredEventData(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public static UserRegisteredEventData of(String id, String email) {
        return new UserRegisteredEventData(id, email);
    }

    public String id() {
        return id;
    }

    public String email() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserRegisteredEventData) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "UserRegisteredEventData[" +
                "id=" + id + ", " +
                "email=" + email + ']';
    }

}
