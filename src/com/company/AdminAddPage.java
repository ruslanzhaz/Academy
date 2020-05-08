package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddPage extends Container {
    private JLabel labelkind;
    private JTextField textkind;

    private JLabel labelname;
    private JTextField textname;

    private JLabel labelyear;
    private JTextField textyear;

    private JButton addd;
    private JButton back;

    public AdminAddPage() {
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("q.png");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        labelkind = new JLabel("Kind:");
        labelkind.setOpaque(true);
        labelkind.setBackground(Color.WHITE);
        labelkind.setBounds(250, 160, 50, 20);
        add(labelkind);
        textkind = new JTextField();
        textkind.setBounds(340, 150, 100, 40);
        add(textkind);

        labelname = new JLabel("Name:");
        labelname.setOpaque(true);
        labelname.setBackground(Color.WHITE);

        labelname.setBounds(250, 210, 50, 20);
        add(labelname);

        textname = new JTextField();
        textname.setBounds(340, 200, 100, 40);
        add(textname);

        labelyear = new JLabel("Year:");
        labelyear.setOpaque(true);
        labelyear.setBackground(Color.WHITE);
        labelyear.setBounds(250, 260, 50, 20);
        add(labelyear);

        textyear = new JTextField();
        textyear.setBounds(340, 250, 100, 40);
        add(textyear);

        addd = new JButton("Add");
        addd.setBounds(250, 400, 100, 50);
        addd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = 0;
                try {
                    year = Integer.parseInt(textyear.getText());
                    Courses courses = new Courses(null, textkind.getText(), textname.getText(),year);
                    Admin.addCourses(courses);

                    textkind.setText("");
                    textname.setText("");
                    textyear.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addd);

        back = new JButton("Back");
        back.setBounds(360, 400, 100, 50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Admin.showMenuPage();
            }
        });
        add(back);
        add(background);
    }
}

