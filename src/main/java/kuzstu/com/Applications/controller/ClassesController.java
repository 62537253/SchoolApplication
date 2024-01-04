package kuzstu.com.Applications.controller;

import java.util.List;

import kuzstu.com.Applications.model.Classes;
import kuzstu.com.Applications.model.Students;

import kuzstu.com.Applications.repository.classes.ClassesRepositoryH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Application/classes")
public class ClassesController {

    private final ClassesRepositoryH2 repository;
    @Autowired
    public ClassesController(ClassesRepositoryH2 repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Classes> readAllClass() {
        return repository.readAllClass();
    }

    @GetMapping("/{class_id}")
    public Classes readClass(@PathVariable("class_id") int classId) {
        return repository.readClass(classId);
    }

    @GetMapping("/{class_id}/students")
    public List<Students> getStudentsByClassId(@PathVariable("class_id") int classId) {
        return repository.getStudentsByClassId(classId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createClass(@RequestBody Classes classes) {
        repository.createClass(classes);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{class_id}")
    public void updateClass(@RequestBody Classes classes, @PathVariable("class_id") int classId) {
        repository.updateClass(classes, classId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{class_id}")
    public void deleteClass(@PathVariable("class_id") int classId) {
        repository.deleteClass(classId);
    }
}
