package com.example.educationspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public @ResponseBody String addNewEnrollment (@RequestBody Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
        return "Enrollment Saved";
    }

    @GetMapping(path = "/list/student/{studentId}")
    public @ResponseBody List<Enrollment> getEnrollmentByStudentId(@PathVariable Integer studentId) {
        List<Enrollment> studentEnrollment = enrollmentRepository.findByStudentId(studentId);
        if (studentEnrollment.isEmpty()){
            return Collections.emptyList();
        }
        return studentEnrollment;
    }

    @GetMapping(path="/list/course/{courseId}")
    public @ResponseBody List<Enrollment> getEnrollmentByCourseId(@PathVariable Integer courseId) {
        List<Enrollment> courseEnrollment = enrollmentRepository.findByCourseId(courseId);
        if (courseEnrollment.isEmpty()){
            return Collections.emptyList();
        }
        return courseEnrollment;
    }

    @PutMapping(path="/modify")
    public @ResponseBody String modifyEnrollment(@RequestBody Enrollment enrollment){
        enrollmentRepository.save(enrollment);
        return "Enrollment Updated";
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteEnrollment(@PathVariable Integer id){
        enrollmentRepository.deleteById(id);
        return "Enrollment Deleted";
    }
}
