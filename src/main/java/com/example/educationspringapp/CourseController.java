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
        return String.format("%s saved.", course.getCourseName());
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
    public @ResponseBody String modifyCourse(@RequestBody Course course){
        Optional<Course> courseToModify = courseRepository.findById(course.getCourseID());
        if (courseToModify.isPresent()) {
            courseRepository.save(course);
            return String.format("Course %d updated", course.getCourseID());
        }
        else{
            return String.format("Course %s not found.", course.getCourseID());
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteCourse(@PathVariable Integer id){
        Optional<Course> courseToDelete = courseRepository.findById(id);
        if(courseToDelete.isEmpty()){
            return String.format("Course %d not found.", id);
        } else{
            courseRepository.deleteById(id);
            return String.format("Course %d deleted", id);
        }

    }
}
