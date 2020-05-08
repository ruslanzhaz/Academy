package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentAdd extends Container {
    private JLabel login;
    private JTextField textLogin;
    private JPasswordField textpassword;
    private JLabel password;
    private JButton signIn;
    private JButton registr;
    private JLabel welcome;


    public StudentAdd() {
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("1.png");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        login = new JLabel("Login:");
        login.setOpaque(true);
        login.setBackground(Color.WHITE);
        login.setBounds(265, 160, 50, 20);
        add(login);
        textLogin = new JTextField();
        textLogin.setBounds(340, 150, 100, 40);
        add(textLogin);

        password = new JLabel("Password:");
        password.setOpaque(true);
        password.setBackground(Color.WHITE);
        password.setBounds(265, 215, 60, 20);
        add(password);

        textpassword = new JPasswordField();
        textpassword.setBounds(340, 200, 100, 40);
        add(textpassword);
        welcome = new JLabel("");
        welcome.setBounds(250, 400, 80, 40);
        add(welcome);


        registr = new JButton("Registr");
        registr.setBounds(340, 310, 100, 50);
        registr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.showRegistrPage();
            }
        });
        add(registr);

        signIn = new JButton("Sign_in");
        signIn.setBounds(340, 250, 100, 50);
        signIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<StudentData> students = Student.listStudents();

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getLogin().equals(textLogin.getText()) && students.get(i).getPassword().equals(textpassword.getText())) {
                        Student.myLogin(students.get(i).getLogin());
                        Student.showMainMenu();
                        break;
                    } else {
                        welcome.setText("Wrong password or login");
                    }


                }
            }
        });
        add(signIn);
        add(background);
        repaint();



    }

    int x = 150, y = 100;
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Tahoma", Font.BOLD + Font.PLAIN, 37);
        g2.setFont(font);
        g2.setColor(Color.YELLOW);
        g2.drawString("WELCOME to shinobi class!!", x, y);
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
        }
        x -= 10;
        if (x > this.getWidth()) {
            x = 0;
        }
        repaint();
    }
}



