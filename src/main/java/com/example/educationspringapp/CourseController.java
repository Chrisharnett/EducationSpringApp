package com.example.educationspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

/**
 * @author saxDev
 * studentnumber 20188141
 **/

@Controller
@RequestMapping(path="/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(path="/add")
    public @ResponseBody Course addNewCourse (@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/view/{id}")
    public @ResponseBody Optional<Course> getCourseById(@PathVariable Integer id) {
        return courseRepository.findById(id);
    }

    @PutMapping(path="/modify")
    public @ResponseBody Course modifyCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void deleteCourse(@PathVariable Integer id){
        courseRepository.deleteById(id);
    }
}
