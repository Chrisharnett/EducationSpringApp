package com.example.educationspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author saxDev
 * studentnumber 20188141
 **/
@Controller
@RequestMapping(path="/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @PostMapping(path="/add")
    public @ResponseBody Enrollment addNewEnrollment (@RequestBody Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @GetMapping(path = "/list/student/{studentId}")
    public @ResponseBody List<Enrollment> getEnrollmentByStudentId(@PathVariable Integer studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    @GetMapping(path="/list/course/{courseId}")
    public @ResponseBody List<Enrollment> getEnrollmentByCourseId(@PathVariable Integer courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    @PutMapping(path="/modify")
    public @ResponseBody Enrollment modifyEnrollment(@RequestBody Enrollment enrollment){
        return enrollmentRepository.save(enrollment);
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void deleteEnrollment(@PathVariable Integer id){
        enrollmentRepository.deleteById(id);
    }
}
