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
@RequestMapping(path="/grades")
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewGrades (@RequestBody Grades grades) {
        gradesRepository.save(grades);
        return "Grades Saved";
    }

    @GetMapping(path="/list/course/{courseId}")
    public @ResponseBody List<Grades> getGradesByCourseId(@PathVariable Integer courseId) {
        List<Grades> courseGrades = gradesRepository.findByCourseId(courseId);
        if (courseGrades.isEmpty()){
            return Collections.emptyList();
        }
        return courseGrades;
    }

    @GetMapping(path = "/list/student/{studentId}")
    public @ResponseBody List<Grades> getGradesByStudentId(@PathVariable Integer studentId) {
        List<Grades> studentGrades = gradesRepository.findByStudentId(studentId);
        if (studentGrades.isEmpty()){
            return Collections.emptyList();
        }
        return studentGrades;
    }

    @PutMapping(path="/modify")
    public @ResponseBody String modifyGrades(@RequestBody Grades grades){
        Optional<Grades> gradesToModify = gradesRepository.findById(grades.getStudentId());
        if (gradesToModify.isPresent()) {
            gradesRepository.save(grades);
            return String.format("Grades %d updated", grades.getGid());
        }
        else{
            return String.format("Student %s not found.", grades.getGid());
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteGrades(@PathVariable Integer id){
        Optional<Grades> gradesToDelete = gradesRepository.findById(id);
        if(gradesToDelete.isEmpty()){
            return String.format("Grades %d not found.", id);
        } else{
            gradesRepository.deleteById(id);
            return String.format("Grades %d deleted", id);
        }
    }
}
