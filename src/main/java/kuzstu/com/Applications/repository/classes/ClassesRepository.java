package kuzstu.com.Applications.repository.classes;

import kuzstu.com.Applications.model.Classes;
import kuzstu.com.Applications.model.Students;

import java.util.List;

public interface ClassesRepository {


    List<Classes> readAllClass();

    Classes readClass(int classId);

    List<Students> getStudentsByClassId(int classId);

    void createClass(Classes classes);

    void updateClass(Classes classes, int classId);

    void deleteClass(int classId);
}
