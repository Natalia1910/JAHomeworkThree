package com.homework.three;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UniversityDatabase uDB = new UniversityDatabase();
        Student student = new Student();
        Mark mark = new Mark();

        String choice = scanner.nextLine();

        if ("add".equals(choice)) {
            uDB.addStudent(student);
        } else if ("update".equals(choice)) {
            uDB.updateDataForStudent(student);
        } else if ("delete".equals(choice)) {
            uDB.deleteStudent(student);
        } else if ("mark".equals(choice)) {
            uDB.addMarkForStudent(student, mark);
        }
    }
}
