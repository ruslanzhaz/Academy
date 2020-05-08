package com.company;


import java.io.*;
import java.net.*;
import java.util.*;
public class Student {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static StudentMainFrame frame;
    public static Socket  socket;
    public static String accaunt=null;

    private static  ArrayList<StudentData> students;

    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",8999);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addStudent(StudentData student){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Student");
        pd.setStudent(student);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static ArrayList<StudentData> listStudents(){
        ArrayList<StudentData> students=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Students");
        pd.setStudent(students);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                students=pd.getStudents();
                for(StudentData bd : students)
                    System.out.println(bd);
            }
        }catch (Exception e){e.printStackTrace();}
        return students;
    }

    public static ArrayList<Courses> listCourses(){
        ArrayList<Courses> courses=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List");
        try {
            outputStream.writeObject(pd);
            if((pd=(PackageData)inputStream.readObject())!=null){
                courses=pd.getCourses();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }

    public static void addEntry(Entry entry){
        PackageData pd=new PackageData();
        ArrayList<Entry> entry1 = new ArrayList<>();
        entry1.add(entry);
        pd.setOperationType("Add_T");
        pd.setEntry(entry1);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Entry> listEntry(){
        ArrayList<Entry> entry=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_T");
        pd.setEntry(entry);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                entry =pd.getEntry();
            }
        }catch (Exception e){e.printStackTrace();}
        return entry;
    }


    public static void showRegistrPage(){
        Student.frame.addStudent.setVisible(false);
        Student.frame.regitr.setVisible(true);
        Student.frame.menu.setVisible(false);
        Student.frame.repaint();
    }

    public static void myLogin(String login){
        accaunt=login;
    }

    public static void showListPage(){
        Student.frame.menu.setVisible(false);
        Student.frame.addEntry.setVisible(false);
        Student.frame.listPage.setVisible(true);
        ArrayList<Entry>list=listEntry();
        frame.listPage.updateArea(list);
        Student.frame.repaint();
    }

    public static void showMainMenu() {
        Student.frame.addStudent.setVisible(false);
        Student.frame.regitr.setVisible(false);
        Student.frame.listPage.setVisible(false);
        Student.frame.menu.setVisible(true);
        Student.frame.repaint();
    }


    public static void showMenuPage() {
        Student.frame.addStudent.setVisible(true);
        Student.frame.regitr.setVisible(false);
        Student.frame.menu.setVisible(false);
        Student.frame.repaint();
    }


    public static void main(String[] args){
        connectToServer();
        frame = new StudentMainFrame();
        frame.setVisible(true);
    }
}



