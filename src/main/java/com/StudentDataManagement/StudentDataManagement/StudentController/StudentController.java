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

    //Get all the student details
    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // Get Specific Student details by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping // This handles POST requests to /students
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PostMapping("/bulk")
    public ResponseEntity<Student[]> addStudents(@RequestBody Student[] students) {
        Student[] addedStudents = studentService.addStudents(students);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedStudents);
    }

    // PUT /students/{id} - Update an existing student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        Optional<Student> student = studentService.updateStudent(id, updatedStudent);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // DELETE /students/{id} - Delete a student profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/marks/gt/{mark}")
    public ResponseEntity<List<Student>> getStudentsWithMarksGreaterThan(@PathVariable double mark) {
        List<Student> students = studentService.getStudentsByMarkGreaterThan(mark);

        return ResponseEntity.ok(students);
    }

    @GetMapping("/marks/lt/{mark}")
    public ResponseEntity<List<Student>> getStudentsWithMarksLessThan(@PathVariable double mark) {
        List<Student> students = studentService.getStudentsByMarkLessThan(mark);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/fees/paid")
    public ResponseEntity<List<Student>> getStudentByPaid()
    {
        List<Student> students = studentService.getStudentByPaid();
        System.out.println("Calling Fees Paid");
        return ResponseEntity.ok(students);
    }
    @GetMapping("/fees/notpaid")
    public ResponseEntity<List<Student>> getStudentByNotPaid()
    {
        List<Student> students = studentService.getStudentByNotPaid();
        return ResponseEntity.ok(students);
    }

}
