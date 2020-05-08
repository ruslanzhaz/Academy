package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistr extends Container {
    private JLabel login;
    private JTextField textLogin;
    private JLabel rank;
    private JTextField textRank;
    private JLabel clan;
    private JTextField textClan;
    private JPasswordField textpassword;
    private JLabel password;
    private JButton back;
    private JButton registr;

    public StudentRegistr () {
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("4.jpeg");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        login = new JLabel("Login:");
        login.setBounds(250, 150, 80, 40);
        add(login);
        textLogin = new JTextField();
        textLogin.setBounds(340, 150, 100, 40);
        add(textLogin);

        password = new JLabel("Password:");
        password.setBounds(250, 200, 80, 40);
        add(password);

        textpassword = new JPasswordField();
        textpassword.setBounds(340, 200, 100, 40);
        add(textpassword);

        rank = new JLabel("Rank:");
        rank.setBounds(250, 250, 80, 40);
        add(rank);
        textRank = new JTextField();
        textRank.setBounds(340, 250, 100, 40);
        add(textRank);


        clan = new JLabel("Clan:");
        clan.setBounds(250, 300, 80, 40);
        add(clan);
        textClan = new JTextField();
        textClan.setBounds(340, 300, 100, 40);
        add(textClan);

        back=new JButton("Back");
        back.setBounds(340,410,100,50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.showMenuPage();
            }
        });
        add(back);
        registr=new JButton("Register");
        registr.setBounds(340,350,100,50);
        registr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    StudentData student = new StudentData(textLogin.getText(), textpassword.getText(),textRank.getText(), textClan.getText());
                    Student.addStudent(student);
                    textLogin.setText("");
                    textpassword.setText("");
                    textRank.setText("");
                    textClan.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        add(registr);
        add(background);
    }

    int x = 0, y = 100;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Tahoma", Font.BOLD + Font.PLAIN, 50);
        g2.setFont(font);
        g2.setColor(Color.GREEN);
        g2.drawString("Register part", x, y);
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
        }
        x += 10;
        if (x > this.getWidth()) {
            x = 0;
        }
        repaint();
    }
}


