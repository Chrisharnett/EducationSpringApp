package com.example.educationspringapp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author saxDev
 * studentnumber 20188141
 **/
public interface GradesRepository extends CrudRepository<Grades, Integer>{
    List<Grades> findByCourseId(Integer courseId);

    List<Grades> findByStudentId(Integer studentId);
}
