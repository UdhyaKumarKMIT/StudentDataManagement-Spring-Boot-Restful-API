package com.StudentDataManagement.StudentDataManagement.Repository;

import com.StudentDataManagement.StudentDataManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByMarksGreaterThan(double mark);
    List<Student> findByMarksLessThan(double mark);
    List<Student> findByMarksBetween(double minMark, double maxMark);
    List<Student> findByFeesPaidTrue();
    List<Student> findByFeesPaidFalse();
    List<Student> findByCourse(String course);
}
