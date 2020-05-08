package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenu extends Container {
    public JButton addd;
    public JButton list;
    public JButton delete;
    public JButton exit;

    public AdminMainMenu() {
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("back.png");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        //setVisible(true);

        addd = new JButton("Add course");
        addd.setLocation(100, 250);
        addd.setSize(100, 50);
        addd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddPage();
            }
        });
        add(addd);

        list = new JButton("List courses");
        list.setLocation(300, 250);
        list.setSize(110, 50);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showListPage();
            }
        });
        add(list);

        delete= new JButton("Delete course");
        delete.setLocation(500, 250);
        delete.setSize(120, 50);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDeletePage();
            }
        });
        add(delete);

        exit = new JButton("Exit");
        exit.setBounds(400, 450, 200, 50);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
        add(background);

    }

    int x = 0, y = 100;
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Tahoma", Font.BOLD + Font.PLAIN, 38);
        g2.setFont(font);
        g2.setColor(Color.YELLOW);
        g2.drawString("WELCOME to shinobi school!!", x, y);
        try {
            Thread.sleep(700);
        } catch (Exception ex) {
        }
        x += 10;
        if (x > this.getWidth()) {
            x = 0;
        }
        repaint();
    }
}

