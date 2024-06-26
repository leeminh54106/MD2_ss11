package baitonghop.business.feature;

import baitonghop.business.entity.Student;

public interface IStudentFeature {


    // 2. addNew(Student student)
    void addNewStudent(Student student);

    // 3. removeById(int studentId)
    void removeStudent(int studentId);

    // feature update student
    void updateStudent(Student student, int indexUpdate);

    // 4. findStudentById(int studentId)
    int findIndexById(int studentId);

    // 5. getAverageScore()
    void getAverageScore();

    // 6. sortByScore()
    void sortByScore();
}