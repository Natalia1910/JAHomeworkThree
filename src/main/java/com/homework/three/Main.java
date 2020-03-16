package com.homework.three;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        UniversityDatabase uDB = new UniversityDatabase();
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        Mark mark = new Mark();
        String choice = scanner.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "natalia",
                    "natalia0211");

            if ("add".equals(choice)) {
                uDB.addStudent(student);
            } else if ("update".equals(choice)) {
                uDB.updateDataForStudent(student);
            } else if ("delete".equals(choice)) {
                uDB.deleteStudent(student);
            } else if ("mark".equals(choice)) {
                uDB.addMarkForStudent(student, mark);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            connection.close();
        }
    }
}
