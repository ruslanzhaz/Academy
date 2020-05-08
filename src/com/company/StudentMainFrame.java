package com.company;

import javax.swing.*;
public class StudentMainFrame extends JFrame {
    public StudentAddPage addEntry;
    public StudentMainMenu menu;
    public StudentRegistr regitr;
    public StudentListPage listPage;
    public StudentAdd addStudent;


    public StudentMainFrame(){
        setTitle("STUDENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);
        menu = new StudentMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        addStudent = new StudentAdd();
        addStudent.setLocation(0, 0);
        addStudent.setVisible(true);
        add(addStudent);

        listPage = new StudentListPage();
        listPage.setLocation(0, 0);
        listPage.setVisible(false);
        add(listPage);


        regitr=new StudentRegistr();
        regitr.setLocation(0,0);
        regitr.setVisible(false);
        add(regitr);

        addEntry = new StudentAddPage();
        addEntry.setLocation(0,0);
        addEntry.setVisible(false);
        add(addEntry);


        repaint();
    }
}
