package com.company.user.model;

import com.company.user.model.enums.Rights;
import com.company.user.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class User {
    private Rights rights = Rights.USER;
    private Status status = Status.ACTIVE;
    private int id;
    private String login;
    private String password;
    private String name;
    private String seName;

    public User(int id, String login, String password, Rights rights) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rights = rights;
    }

    public User() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getRights() == user.getRights() &&
                getStatus() == user.getStatus() &&
                getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword()) &&
                getName().equals(user.getName()) &&
                Objects.equals(getSeName(), user.getSeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRights(), getStatus(), getLogin(), getPassword(), getName(), getSeName());
    }
}

