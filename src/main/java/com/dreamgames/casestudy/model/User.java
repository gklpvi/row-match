package com.dreamgames.casestudy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String username;
    private Integer userlevel;
    private Integer usercoin;
    public User() {
    }

    public User(String username, int userlevel, int usercoin) {
        this.username = "";
        this.userlevel = 1;
        this.usercoin = 5000;
    }

    public int getId() {
        return this.userid;
    }

    public void setId(int id) {
        this.userid = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserLevel() {
        return this.userlevel;
    }

    public void setUserLevel(int level) {
        this.userlevel = level;
    }

    public int getUserCoin() {
        return this.usercoin;
    }

    public void setUserCoin(int coin) {
        this.usercoin = coin;
    }

}
