package kuzstu.com.Applications.controller;

import kuzstu.com.Applications.model.Students;
import kuzstu.com.Applications.persistence.DB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("Applications/students")
public class StudentsController {

    private final List<Students> studentsList;
    public StudentsController() throws ParseException {
        studentsList = DB.getStudentList();
    }
    @GetMapping
    public List<Students> getStudent() {
        return studentsList;
    }
    @GetMapping("/{student_id}")
    public Students getStudent (@PathVariable("student_id") int studentId){
        return studentsList.stream()
                .filter(student -> student.id == studentId)
                .filter(student -> student.id() == studentId)
                .findAny()
                .orElse(null);
    }

    @GetMapping("StudentsByClassId/{class_id}")
    public List<Students> getStudentsByClassId(@PathVariable("class_id") int classId){
        return studentsList.stream()
                .filter(student -> student.classId == classId)
                .toList();
    }
}
