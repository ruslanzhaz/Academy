package com.company;

import java.net.*;
import java.sql.*;

public class Server {
    public static Connection connection;
    public static void main(String[] args) {
        try{
            connectToDb();
            ServerSocket ss = new ServerSocket(8999);

            while(true){
                System.out.println("waiting for client");
                Socket socket = ss.accept();
                System.out.println("new client connected");

                ServerThread sth = new ServerThread(socket,connection);
                sth.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static  void connectToDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/animes_project?serverTimezone=UTC",
                            "root",
                            "");
            System.out.println("Connected to DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


