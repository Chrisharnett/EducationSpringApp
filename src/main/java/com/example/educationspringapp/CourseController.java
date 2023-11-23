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
    public @ResponseBody String addNewCourse (@RequestBody Course course) {
        courseRepository.save(course);
        return "Saved";
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/view")
    public @ResponseBody Optional<Course> getCourseById(@RequestParam Integer id) {
        return courseRepository.findById(id);
    }
}
