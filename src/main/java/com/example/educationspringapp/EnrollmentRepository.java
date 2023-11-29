package com.example.educationspringapp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author saxDev
 * studentnumber 20188141
 **/
public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {
    List<Enrollment> findByCourseId(Integer courseId);

    List<Enrollment> findByStudentId(Integer studentId);
}
