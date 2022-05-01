package com.example.se_project2;
import java.sql.*;
public class db {
    public  static Connection conn = null;

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\hasan\\IdeaProjects\\SE_Project2 - Copy\\src\\main\\resources\\com\\example\\se_project2\\carservice.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM users");
            if(res.next()){
                System.out.println("username: "+res.getString("username")+" Pass: "+res.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        String url = "jdbc:sqlite:C:\\Users\\hasan\\IdeaProjects\\SE_Project2\\src\\main\\resources\\com\\example\\se_project2\\carservice.db";
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static db getInstance() {
        return new db();
    }
}
