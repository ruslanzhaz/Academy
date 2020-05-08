package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentListPage extends Container {

    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton buy;
    private JButton back;
    private JTextArea area;

    public StudentListPage() {
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("mn.png");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        label = new JLabel("INSERT ID:");
        label.setBounds(250, 460, 80, 30);
        add(label);

        area = new JTextArea();
        area.setSize(600,400);
        area.setLocation(50,50);
        add(area);


        textField = new JTextField("");
        textField.setBounds(340, 460, 100, 30);
        add(textField);
        buy = new JButton("CHECK");
        buy.setBounds(150, 500, 100, 50);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Student.showMainMenu();

                    textField.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,
                        "Let`s go!");
            }

        });
        add(buy);

        back = new JButton("BACK");
        back.setBounds(550, 600, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student.showMainMenu();
            }
        });
        add(back);
        add(background);

    }

    public void updateArea(ArrayList<Entry> entry) {
        area.setText("");
        for (Entry ts : entry) {
            area.append(ts + "\n");
        }
        repaint();
    }
}

