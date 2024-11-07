package com.StudentDataManagement.StudentDataManagement.StudentController;

import com.StudentDataManagement.StudentDataManagement.Exception.StudentNotFoundException;
import com.StudentDataManagement.StudentDataManagement.StudentService.StudentService;
import com.StudentDataManagement.StudentDataManagement.Entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
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
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Student>> addStudents(@Valid @RequestBody List<Student> students) {
        List<Student> addedStudents = studentService.addStudents(students);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedStudents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @Valid @RequestBody Student updatedStudent) {
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

    @GetMapping("/courses/{course}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable String course) {

        List<Student> students = studentService.getStudentsByCourse(course);

        if (students.isEmpty()) {
            throw new StudentNotFoundException("No Student is learning this course : "+course);
        }

        return ResponseEntity.ok(students);
    }


    @GetMapping("/courses")
    public ResponseEntity<List<String>> getUniqueCourses() {
        List<Student> students = studentService.getAllStudents();
        List<String> uniqueCourses = new ArrayList<>();

        for (Student student : students) {
            String course = student.getCourse();
            if (course != null && !course.isEmpty() && !uniqueCourses.contains(course)) {
                uniqueCourses.add(course);
            }
        }

        return ResponseEntity.ok(uniqueCourses);
    }

    @GetMapping("/top/{n}")
    public ResponseEntity<List<Student>> getTopRankers(@PathVariable int n) {
        List<Student> topRankers = studentService.getTopRankers(n);
        return ResponseEntity.ok(topRankers);
    }

}