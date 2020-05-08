package com.company;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public static Long id = null;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject()) != null) {

                if (pd.getOperationType().equals("Add")) {
                    try {
                        Courses courses = pd.getCourse();
                        addCoursesToDb(courses);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("Add_T")){
                    try {
                        Entry entry= pd.getEntry().get(0);
                        addEntryToDb(entry);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }   else if (pd.getOperationType().equals("List_Students")) {
                    ArrayList<StudentData> students = getAllStudents();
                    PackageData resp = new PackageData();
                    resp.setStudent(students);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("List")) {
                    ArrayList<Courses> courses = getCourses();
                    PackageData resp = new PackageData();
                    resp.setCourses(courses);
                    outputStream.writeObject(resp);
                }   else if (pd.getOperationType().equals("Add_Student")) {
                    try {
                        StudentData student = pd.getStudent();
                        addStudent(student);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("List_T")){
                    ArrayList<Entry>entry=getEntry();
                    PackageData pd2=new PackageData();
                    pd2.setEntry(entry);
                    outputStream.writeObject(pd2);
                }
                else if (pd.getOperationType().equals("Delete")) {
                    Long id = pd.getId();
                    deleteBookToDB(id);
                } else {
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Entry> getEntry() {
        ArrayList<Entry> entry = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM entry";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                entry.add(new Entry(res.getLong("id"), res.getInt("coursesId"), res.getString("name"), res.getString("surname")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entry;
    }


    public void addStudent(StudentData student) {
        try {

            PreparedStatement pse = connection.prepareStatement("INSERT INTO studentdata (login, password,rank,clan,id) VALUES(?,?,?,?,NULL)");
            pse.setString(1, student.getLogin());
            pse.setString(2, student.getPassword());
            pse.setString(3, student.getRank());
            pse.setString(4, student.getClan());
            pse.executeUpdate();
            pse.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCoursesToDb(Courses courses) {
        try {
            PreparedStatement ps=connection.prepareStatement("insert into course(id,kind,name,year) values(null,?,?,?)");

            ps.setString(1,courses.getKind());
            ps.setString(2,courses.getName());
            ps.setInt(3,courses.getYear());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public ArrayList<StudentData> getAllStudents() {
        ArrayList<StudentData> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from studentdata");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new StudentData(rs.getString("login"), rs.getString("password"), rs.getString("rank"), rs.getString("clan"), rs.getLong("id")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public  void addEntryToDb(Entry entry) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into entry(id,courseId,name,surname) values(null,?,?,?)");

            ps.setInt(1,entry.getCoursesId());
            ps.setString(2,entry.getName());
            ps.setString(3,entry.getSurname());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Courses> getCourses() {
        ArrayList<Courses> courses = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM course";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                courses.add(new Courses(res.getLong("id"), res.getString("kind"),res.getString("name"),res.getInt("year")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    public void deleteBookToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM course WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

