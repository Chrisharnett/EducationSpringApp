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
@RequestMapping(path="/grades")
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping(path="/add")
    public @ResponseBody Grades addNewGrades (@RequestBody Grades grades) {
        return gradesRepository.save(grades);
    }

    @GetMapping(path="/list/course/{courseId}")
    public @ResponseBody List<Grades> getGradesByCourseId(@PathVariable Integer courseId) {
        return gradesRepository.findByCourseId(courseId);
    }

    @GetMapping(path = "/list/student/{studentId}")
    public @ResponseBody List<Grades> getGradesByStudentId(@PathVariable Integer studentId) {
        return gradesRepository.findByStudentId(studentId);
    }

    @PutMapping(path="/modify")
    public @ResponseBody Grades modifyGrades(@RequestBody Grades grades){
        return gradesRepository.save(grades);
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void deleteGrades(@PathVariable Integer id){
        gradesRepository.deleteById(id);
    }
}
