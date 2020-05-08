package com.company;

import java.io.Serializable;

public class Courses implements Serializable {

    private Long id;
    private String kind;
    private String name;
    private int year;

    public Courses(){}

    public Courses(Long id, String kind, String name, int year) {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.year = year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
