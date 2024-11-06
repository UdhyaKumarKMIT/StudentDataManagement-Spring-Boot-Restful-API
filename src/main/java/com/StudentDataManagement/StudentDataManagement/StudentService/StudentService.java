package com.StudentDataManagement.StudentDataManagement.StudentService;

import com.StudentDataManagement.StudentDataManagement.Entity.Student;
import com.StudentDataManagement.StudentDataManagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> addStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Optional<Student> updateStudent(Integer id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setCourse(updatedStudent.getCourse());
            student.setMarks(updatedStudent.getMarks());
            student.setFeesPaid(updatedStudent.getFeesPaid());
            return studentRepository.save(student);
        });
    }

    public boolean deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Student> getStudentsByMarkGreaterThan(double mark) {
        return studentRepository.findByMarksGreaterThan(mark);
    }

    public List<Student> getStudentsByMarkLessThan(double mark) {
        return studentRepository.findByMarksLessThan(mark);
    }

    public List<Student> getStudentsByMarkBetween(double minMark, double maxMark) {
        return studentRepository.findByMarksBetween(minMark, maxMark);
    }

    public List<Student> getStudentByPaid() {
        return studentRepository.findByFeesPaidTrue();
    }

    public List<Student> getStudentByNotPaid() {
        return studentRepository.findByFeesPaidFalse();
    }
}
