package baitonghop.presentation;

import baitonghop.business.entity.Student;
import baitonghop.business.feature.IStudentFeature;
import baitonghop.business.feature.impl.StudentFeatureImpl;

import java.util.Scanner;

public class StudentManagement {

    public static IStudentFeature studentFeature = new StudentFeatureImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MENU ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃			%30s									┃\n","1. SHOW ALL");
            System.out.printf("┃			%30s									┃\n","2. ADD NEW STUDENT");
            System.out.printf("┃			%30s									┃\n","3. REMOVE BY ID");
            System.out.printf("┃			%30s 									┃\n","4. UPDATE BY ID");
            System.out.printf("┃			%30s									┃\n","5. FIND STUDENT BY ID");
            System.out.printf("┃			%30s									┃\n","6. GET AVERAGE SCORE ALL");
            System.out.printf("┃			%30s									┃\n","7. SORT BY SCORE");
            System.out.printf("┃			%30s									┃\n","8. EXIT");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    handleShowAll();
                    break;
                case 2:
                    handleAddNewStudent(sc);
                    break;
                case 3:
                    handleRemoveById(sc);
                    break;
                case 4:
                    handleUpdateStudent(sc);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Enter your choice again 1 -> 7");
            }
        } while (true);
    }

    private static void handleUpdateStudent(Scanner sc) {
        System.out.println("Enter student id update: ");
        int updateId = Integer.parseInt(sc.nextLine());
        int indexUpdate = studentFeature.findIndexById(updateId);
        if (indexUpdate < 0) {
            System.err.println("Không tồn tại id muốn cập nhật");
            return;
        }
        boolean isLoop = true;
        do {
            Student studentUpdate = StudentFeatureImpl.studentList.get(indexUpdate);
            System.out.println("1. student Name");
            System.out.println("2. Average Score");
            System.out.println("3. Return ");
            int subChoice = Integer.parseInt(sc.nextLine());
            switch (subChoice) {
                case 1:
                    System.out.println("Enter update student name: ");
                    // studentList[indexUpdate].setStudentName()
                    studentUpdate.setStudentName(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Enter update average score");
                    studentUpdate.setAverageScore(Double.parseDouble(sc.nextLine()));
                    break;
                case 3:
                    isLoop = false;
                    break;
                default:
                    System.err.println("Enter again 1 -> 3");
            }
            studentFeature.updateStudent(studentUpdate, indexUpdate);
        } while (isLoop);
    }

    private static void handleRemoveById(Scanner sc) {
        System.out.println("Enter student id remove: ");
        int removeId = Integer.parseInt(sc.nextLine());
        int indexDelete = studentFeature.findIndexById(removeId);
        if (indexDelete < 0) {
            System.err.println("Không tồn tại id muốn xóa");
            return;
        }
        studentFeature.removeStudent(removeId);
    }

    private static void handleShowAll() {
        if (StudentFeatureImpl.studentList.isEmpty()) {
            System.err.println("student is empty");
            return;
        }
        for (Student student : StudentFeatureImpl.studentList) {
            System.out.println(student);
        }
    }

    private static void handleAddNewStudent(Scanner sc) {
        System.out.println("Nhập vào số lượng muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.inputData(sc);
            studentFeature.addNewStudent(student);
        }
    }


}