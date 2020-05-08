package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminListPage extends Container {
    private JLabel label;
    private JButton btn;
    private JTextArea area;

    public AdminListPage(){
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("1.png");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        label=new JLabel("List");
        label.setBounds(320,10,150,60);
        add(label);

        btn = new JButton("Back");
        btn.setLocation(210,600);
        btn.setSize(300,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Admin.showMenuPage();
            }
        });
        add(btn);

        area = new JTextArea();
        area.setSize(600,400);
        area.setLocation(50,50);
        add(area);
        add(background);
    }

    public void updateArea(ArrayList<Courses> courses){
        area.setText("");
        for(Courses ts: courses){
            area.append(ts+"\n");
        }
        repaint();
    }


}
