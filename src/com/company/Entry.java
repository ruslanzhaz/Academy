package com.company;

import java.io.Serializable;

public class Entry implements Serializable {

    private Long id;
    private int courseId;
    private String name;
    private String surname;

    public Entry(){}

    public Entry(Long id, int courseId, String name, String surname) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.surname = surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCoursesId(int courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public int getCoursesId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

