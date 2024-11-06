package com.StudentDataManagement.StudentDataManagement.StudentController;

import com.StudentDataManagement.StudentDataManagement.StudentService.StudentService;
import com.StudentDataManagement.StudentDataManagement.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> students) {
        List<Student> addedStudents = studentService.addStudents(students);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedStudents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        Optional<Student> student = studentService.updateStudent(id, updatedStudent);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/marks/greaterthan/{mark}")
    public ResponseEntity<List<Student>> getStudentsWithMarksGreaterThan(@PathVariable double mark) {
        return ResponseEntity.ok(studentService.getStudentsByMarkGreaterThan(mark));
    }

    @GetMapping("/marks/lesserthan/{mark}")
    public ResponseEntity<List<Student>> getStudentsWithMarksLessThan(@PathVariable double mark) {
        return ResponseEntity.ok(studentService.getStudentsByMarkLessThan(mark));
    }

    @GetMapping("/marks/between/{minMark}/{maxMark}")
    public ResponseEntity<List<Student>> getStudentsWithMarksBetween(@PathVariable double minMark, @PathVariable double maxMark) {
        return ResponseEntity.ok(studentService.getStudentsByMarkBetween(minMark, maxMark));
    }

    @GetMapping("/fees/paid")
    public ResponseEntity<List<Student>> getStudentByPaid() {
        return ResponseEntity.ok(studentService.getStudentByPaid());
    }

    @GetMapping("/fees/notpaid")
    public ResponseEntity<List<Student>> getStudentByNotPaid() {
        return ResponseEntity.ok(studentService.getStudentByNotPaid());
    }
}
