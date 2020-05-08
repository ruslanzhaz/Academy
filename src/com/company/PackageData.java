package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Courses> courses;
    ArrayList<Entry> entry;
    ArrayList<StudentData> students;
    StudentData student;
    Entry entr;;
    Courses course;
    Long id;

    public PackageData(){}

    public PackageData(String operationType, ArrayList<Courses> courses, ArrayList<Entry> entry, ArrayList<StudentData> students, StudentData student, Entry entr, Courses course, Long id) {
        this.operationType = operationType;
        this.courses = courses;
        this.entry = entry;
        this.students = students;
        this.student = student;
        this.entr = entr;
        this.course = course;
        this.id = id;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setCourses(ArrayList<Courses> courses) {
        this.courses = courses;
    }

    public void setEntry(ArrayList<Entry> entry) {
        this.entry = entry;
    }

    public void setStudent(ArrayList<StudentData> students) {
        this.students = students;
    }

    public void setStudent(StudentData student) {
        this.student = student;
    }

    public void setEntr(Entry entr) {
        this.entr = entr;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public ArrayList<Courses> getCourses() {
        return courses;
    }

    public ArrayList<Entry> getEntry() {
        return entry;
    }

    public ArrayList<StudentData> getStudents() {
        return students;
    }

    public StudentData getStudent() {
        return student;
    }

    public Entry getEntr() {
        return entr;
    }

    public Courses getCourse() {
        return course;
    }// public Course

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", courses=" + courses +
                ", entries=" + entry +
                ", students=" + students +
                ", student=" + student +
                ", entry=" + entr +
                ", course=" + course +
                ", id=" + id +
                '}';
    }
}
