package com.example.educationspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody String addNewCourse (@RequestParam String courseName,
                                               @RequestParam String courseNumber,
                                               @RequestParam Integer capacity) {
        Course c = new Course();
        c.setCourseName(courseName);
        c.setCourseNumber(courseNumber);
        c.setCapacity(capacity);

        courseRepository.save(c);
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
