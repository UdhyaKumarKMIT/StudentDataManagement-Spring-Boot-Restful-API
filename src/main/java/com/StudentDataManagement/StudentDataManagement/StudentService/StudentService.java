package com.StudentDataManagement.StudentDataManagement.StudentService;

import com.StudentDataManagement.StudentDataManagement.Entity.Student;

        import org.springframework.stereotype.Service;

        import java.util.Collection;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Optional;
        import java.util.ArrayList;
        import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Integer, Student> studentRepository = new HashMap<>();
    private int currentId = 1;

    // Retrieve all students
    public Collection<Student> getAllStudents() {
        return studentRepository.values();
    }

    // Retrieve a student by ID
    public Optional<Student> getStudentById(Integer id) {
        return Optional.ofNullable(studentRepository.get(id));
    }


    public Student addStudent(Student student) {
        student.setId(currentId++);
        studentRepository.put(student.getId(), student);
        return student;
    }

    public Student[] addStudents(Student[] students) {
        Student[] addedStudents = new Student[students.length]; // Initialize an array of the same length
        for (int i = 0; i < students.length; i++) {
            addedStudents[i] = addStudent(students[i]); // Add each student and store in the array
        }
        return addedStudents; // Return the array directly
    }



    // Update an existing student by ID
    public Optional<Student> updateStudent(Integer id, Student updatedStudent) {
        if (studentRepository.containsKey(id)) {
            updatedStudent.setId(id);
            studentRepository.put(id, updatedStudent);
            return Optional.of(updatedStudent);
        } else {
            return Optional.empty();
        }
    }

    // Delete a student by ID
    public boolean deleteStudent(Integer id) {
        return studentRepository.remove(id) != null;
    }


    public List<Student> getStudentsByMarkGreaterThan(double mark) {
        return studentRepository.values().stream()
                .filter(student -> student.getMarks() >= mark)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByMarkLessThan(double mark) {
        return studentRepository.values().stream()
                .filter(student -> student.getMarks() <= mark)
                .collect(Collectors.toList());
    }
    public List<Student> getStudentsByMarkBetween(double minMark, double maxMark) {
        return studentRepository.values().stream()
                .filter(student -> student.getMarks() >= minMark && student.getMarks() <= maxMark)
                .collect(Collectors.toList());
    }


    public List<Student> getStudentByPaid() {
        return studentRepository.values().stream()
                .filter(student -> student.getFeesPaid())
                .collect(Collectors.toList());
    }


    public List<Student> getStudentByNotPaid()
    {
        return studentRepository.values().stream()
                .filter(student -> !student.getFeesPaid())
                .collect(Collectors.toList());
    }
}
