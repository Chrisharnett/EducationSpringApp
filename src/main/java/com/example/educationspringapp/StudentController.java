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
        return String.format("Student %d Saved", student.getStudentId());
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
    public @ResponseBody String modifyStudent(@RequestBody Student student){
        Optional<Student> studentToModify = studentRepository.findById(student.getStudentId());
        if (studentToModify.isPresent()) {
            studentRepository.save(student);
            return String.format("Student %d updated", student.getStudentId());
        }
        else{
            return String.format("Student %s not found.", student.getStudentId());
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteStudent(@PathVariable Integer id){
        Optional<Student> studentToDelete = studentRepository.findById(id);
        if (studentToDelete.isEmpty()){
            return String.format("Student %d not found", id);
        } else {
            studentRepository.deleteById(id);
            return String.format("Student %d Deleted", id);
        }

    }
}
