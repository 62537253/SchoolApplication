package kuzstu.com.Applications.controller;

import kuzstu.com.Applications.model.Students;

import kuzstu.com.Applications.repository.students.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Applications/students")
public class StudentsController {

    private final StudentsRepository repository;

    @Autowired
    public StudentsController(StudentsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Students> readAllStudents() {
        return repository.readAllStudents();
    }

    @GetMapping("/{student_id}")
    public Students readStudent (@PathVariable("student_id") int studentId) {
        return repository.readStudent(studentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createStudent(@RequestBody Students students) {
        repository.createStudent(students);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{student_id}")
    public void updateStudent(@RequestBody Students students, @PathVariable("student_id") int studentId) {
        repository.updateStudent(students, studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{student_id}")
    public void deleteStudent(@PathVariable("student_id") int studentId) {
        repository.deleteStudent(studentId);
    }

}
