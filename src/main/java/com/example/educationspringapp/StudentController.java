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
@RequestMapping(path="/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewStudent (@RequestBody Student student) {
        studentRepository.save(student);
        return "Saved";
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/view")
    public @ResponseBody Optional<Student> getStudentById(@RequestParam Integer id) {
        return studentRepository.findById(id);
    }
}
