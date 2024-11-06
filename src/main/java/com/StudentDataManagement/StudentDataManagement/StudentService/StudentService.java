package com.StudentDataManagement.StudentDataManagement.StudentService;
import com.StudentDataManagement.StudentDataManagement.Exception.*;
import com.StudentDataManagement.StudentDataManagement.Entity.Student;
import com.StudentDataManagement.StudentDataManagement.Repository.StudentRepository;
import jakarta.validation.Valid;
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
        Optional<Student> student=studentRepository.findById(id);
        if(!student.isPresent())
        {
            throw new StudentNotFoundException("Student with id "+id+" is not present ");
        }
       return student;


    }


    public Student addStudent(Student student) {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new StudentCreationException("Error occurred while creating the student record.");
        }
    }

    public List<Student> addStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Optional<Student> updateStudent(Integer id, Student updatedStudent) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new StudentNotFoundException("Student with id " + id + " is not present");
        }

        student.get().setName(updatedStudent.getName());
        student.get().setAge(updatedStudent.getAge());
        student.get().setCourse(updatedStudent.getCourse());
        student.get().setMarks(updatedStudent.getMarks());
        student.get().setFeesPaid(updatedStudent.getFeesPaid());


        return Optional.of(studentRepository.save(student.get()));
    }


    public boolean deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            throw new StudentDeletionException("Failed to delete Student. Student with ID " + id + " does not exist.");
        }
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
