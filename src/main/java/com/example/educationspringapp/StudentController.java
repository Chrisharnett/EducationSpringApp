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
    public @ResponseBody Student addNewStudent (@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/view/{id}")
    public @ResponseBody Optional<Student> getStudentById(@PathVariable Integer id) {
            return studentRepository.findById(id);
    }

    @PutMapping(path="/modify")
    public @ResponseBody Student modifyStudent(@RequestBody Student student){
            return studentRepository.save(student);
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
    }
}
