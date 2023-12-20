package kuzstu.com.Applications.controller;

import kuzstu.com.Applications.model.Classes;

import java.text.ParseException;
import java.util.List;

import kuzstu.com.Applications.model.Students;
import kuzstu.com.Applications.persistence.DB;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Application/classes")
public class ClassesController {
    private final List<Classes> classesList;
    public ClassesController() throws ParseException {
        this.classesList = DB.getClassesList();
    }

    public ClassesController(List<Classes> classesList) {
        this.classesList = classesList;
    }

    @GetMapping
    public List<Classes> getClasses(){
        return classesList;
    }
    @GetMapping("/{class_id}")
    public Classes getClasses (@PathVariable("class_id") int classId){
        return classesList.stream()
                .filter(classes -> classes.id == classId)
                .filter(classes -> classes.id() == classId)
                .findAny()
                .orElse(null);
    }

    @GetMapping("/{class_id}/students")
    public List<Students> getStudentsByClassId(@PathVariable("class_id") int classId) throws ParseException {
        List<Students> studentsList = DB.getStudentList();
        return studentsList.stream()
                .filter(students -> students.classId == classId)
                .toList();
    }
}
