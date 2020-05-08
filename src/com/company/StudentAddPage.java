package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class StudentAddPage extends Container {
    private JLabel labelId;
    private JLabel labelName;
    private JTextField textName;
    private JLabel labelSurname;
    private JTextField textSurname;
    private JButton addEntry;
    private JButton back;

    public StudentAddPage(){
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("21.png");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        labelId=new JLabel("Id:");
        labelId.setBounds(100,150,120,40);
        add(labelId);

        Courses[]courses=null;
        ArrayList<Courses> list = Student.listCourses();
        courses = list.toArray(new Courses[list.size()]);

        JComboBox comboBox=new JComboBox(courses);
        comboBox.setBounds(230,150,250,40);
        add(comboBox);
        labelName=new JLabel("Name:");
        labelName.setBounds(100,200,120,40);
        add(labelName);

        textName=new JTextField();
        textName.setBounds(230,200,250,40);
        add(textName);

        labelSurname=new JLabel("Surname:");
        labelSurname.setBounds(100,250,120,40);
        add(labelSurname);

        textSurname=new JTextField();
        textSurname.setBounds(230,250,250,40);
        add(textSurname);

        addEntry=new JButton("ADD");
        addEntry.setBounds(100,400,120,50);
        addEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Courses myCourses = (Courses) comboBox.getSelectedItem();
                    Entry entry=new Entry(null,myCourses.getId().intValue(),textName.getText(),textSurname.getText());
                    Student.addEntry(entry);

                    textName.setText("");
                    textSurname.setText("");


                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(addEntry);

        back=new JButton("BACK");
        back.setBounds(360,400,120,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student.frame.addEntry.setVisible(false);
                Student.frame.listPage.setVisible(false);
                Student.frame.menu.setVisible(true);
                Student.frame.repaint();
            }
        });
        add(back);
        add(background);
    }

}

