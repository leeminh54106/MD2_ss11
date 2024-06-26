package baitonghop.business.feature.impl;

import baitonghop.business.entity.Student;
import baitonghop.business.feature.IStudentFeature;

import java.util.ArrayList;
import java.util.List;

public class StudentFeatureImpl implements IStudentFeature {
    public static List<Student> studentList = new ArrayList<>();

    @Override
    public void addNewStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void removeStudent(int studentId) {
        studentList.remove(findIndexById(studentId));
    }

    @Override
    public void updateStudent(Student student, int indexUpdate) {
        studentList.set(indexUpdate, student);
    }

    @Override
    public int findIndexById(int studentId) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId() == studentId) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void getAverageScore() {

    }

    @Override
    public void sortByScore() {

    }
}