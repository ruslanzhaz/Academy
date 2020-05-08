package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMainMenu extends Container {
    public JButton addEntry;
    public JButton list;
    public JButton exit;

    public StudentMainMenu() {
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("11.png");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        addEntry = new JButton("Entry Course");
        addEntry.setLocation(200, 150);
        addEntry.setSize(300, 30);
        addEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.frame.menu.setVisible(false);
                Student.frame.listPage.setVisible(false);
                Student.frame.addEntry.setVisible(true);
                Student.frame.repaint();
            }
        });
        add(addEntry);

        list = new JButton("check");
        list.setLocation(200, 190);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.showListPage();
            }
        });
        add(list);


        exit = new JButton("EXIT");
        exit.setBounds(200, 350, 300, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
        add(background);

    }
}


