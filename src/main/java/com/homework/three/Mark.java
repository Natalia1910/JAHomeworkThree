package com.homework.three;

import java.util.Scanner;

public class Mark {
    Scanner scanner = new Scanner(System.in);

    private int studentID;
    private int subjectID;
    private int firsM;
    private int secondM;
    private int thirdM;
    private int exam;

    public Mark() {

    }

    public Mark(int studentID, int subjectID, int firsM, int secondM, int thirdM, int exam) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.firsM = firsM;
        this.secondM = secondM;
        this.thirdM = thirdM;
        this.exam = exam;

        studentID = scanner.nextInt();
        subjectID = scanner.nextInt();
        firsM = scanner.nextInt();
        secondM = scanner.nextInt();
        thirdM = scanner.nextInt();
        exam = scanner.nextInt();
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getFirsM() {
        return firsM;
    }

    public void setFirsM(int firsM) {
        this.firsM = firsM;
    }

    public int getSecondM() {
        return secondM;
    }

    public void setSecondM(int secondM) {
        this.secondM = secondM;
    }

    public int getThirdM() {
        return thirdM;
    }

    public void setThirdM(int thirdM) {
        this.thirdM = thirdM;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }
}
