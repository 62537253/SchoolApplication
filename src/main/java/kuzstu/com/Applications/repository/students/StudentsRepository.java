package kuzstu.com.Applications.repository.students;

import kuzstu.com.Applications.model.Students;

import java.util.List;

public interface StudentsRepository {

    List<Students> readAllStudents();

    Students readStudent(int studentId);

    void createStudent(Students students);

    void updateStudent(Students students, int studentId);

    void deleteStudent(int studentId);

}
