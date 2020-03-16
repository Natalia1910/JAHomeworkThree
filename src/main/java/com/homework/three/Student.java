package com.homework.three;

import java.util.Scanner;

public class Student {
    private Scanner scanner = new Scanner(System.in);

    private int studentID;
    private String name;
    private String lastName;
    private String course;
    private int age;

    public Student(){

    }

    public Student(int studentID, String name, String lastName, String course, int age) {
        this.studentID = studentID;
        this.name = name;
        this.lastName = lastName;
        this.course = course;
        this.age = age;

        studentID = scanner.nextInt();
        name = scanner.next();
        lastName = scanner.next();
        course = scanner.next();
        age = scanner.nextInt();
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
