package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false" +
                "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "sammy";
        String password = "FP_auMySQL20";

        try {
            System.out.println("Attempt to connect to db");

            Connection myCon = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Connection to db was succesfull to connect to db");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
