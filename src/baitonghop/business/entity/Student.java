package baitonghop.business.entity;

import baitonghop.business.feature.impl.StudentFeatureImpl;

import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    private double averageScore;

    public Student() {
    }

    public Student(int studentId, String studentName, double averageScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.averageScore = averageScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
//thực hiện nhập dữ liệu:
    public void inputData(Scanner scanner) {
        this.studentId = idAutoIncrement();
        this.studentName = inputStudentName(scanner);
        this.averageScore = inputAverageScore(scanner);
    }

//Id tự tăng
    public int idAutoIncrement() {
        int maxId = 0;
        for (Student student : StudentFeatureImpl.studentList) {
            if (maxId < student.getStudentId()) {
                maxId = student.getStudentId();
            }
        }
        return maxId + 1;
    }

    public String inputStudentName(Scanner scanner) {
        System.out.println("Enter your student name: ");
        return scanner.nextLine();
    }

    public double inputAverageScore(Scanner scanner) {
        System.out.println("Enter your average score: ");
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "[ ID: " + this.studentId + " | Name: " + this.studentName + " | AverageScore: " + this.averageScore + " ]";
    }


}