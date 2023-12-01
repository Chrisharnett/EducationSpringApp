package com.example.educationspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        Optional<Enrollment> enrollmentToModify = enrollmentRepository.findById(enrollment.getEid());
        if (enrollmentToModify.isPresent()) {
            enrollmentRepository.save(enrollment);
            return String.format("Enrollment %d updated", enrollment.getEid());
        }
        else{
            return String.format("Enrollment %s not found.", enrollment.getEid());
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteEnrollment(@PathVariable Integer id){
        Optional<Enrollment> enrollmentToModify = enrollmentRepository.findById(id);
        if(enrollmentToModify.isEmpty()){
            return String.format("Enrollment %d not found.", id);
        } else{
            enrollmentRepository.deleteById(id);
            return String.format("Enrollment %d deleted", id);
        }
    }
}
