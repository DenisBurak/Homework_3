package com.zemelya.domain;

import com.zemelya.util.Constants;

import java.util.List;
import java.util.Objects;

import static com.zemelya.util.Constants.EMPTY_STRING;

public class User {

    private Long id;
    private String name;
    private String surname;
    private List<User> friends;

    public User() {
        this.id = Constants.DEFAULT_ID;
        this.name = EMPTY_STRING;
        this.surname = EMPTY_STRING;
        this.friends = null;
    }

    public User(Long id, String name, String surname, List<User> friends) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.friends = friends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends.addAll(friends);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(friends, user.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, friends);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", friends=" + FriendsToString() + '}';
    }

    public String FriendsToString() {
        String friendsString = "";

        for (User friend : friends) {
            if (friendsString.isEmpty()) {
                friendsString = "{";
                friendsString = friendsString.concat(friend.name);
            } else {
                friendsString = friendsString.concat(",").concat(friend.name);
            }
        }
        friendsString = friendsString.concat("}");

        return friendsString;
    }

}
