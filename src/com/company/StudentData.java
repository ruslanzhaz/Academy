package com.company;


import java.io.Serializable;

public class StudentData implements Serializable {
    private String login;
    private String password;
    private String rank;
    private String clan;
    private long id;

    public StudentData() {
    }

    public StudentData(String login, String password, String rank, String clan,long id) {
        this.login = login;
        this.password = password;
        this.rank = rank;
        this.clan = clan;
        this.id=id;
    }

    public StudentData(String login, String password, String rank, String clan) {
        this.login = login;
        this.password = password;
        this.rank = rank;
        this.clan = clan;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String Clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "GuestData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rank='" + rank + '\'' +
                ", clan='" + clan + '\'' +
                ", id=" + id +
                '}';
    }
}



