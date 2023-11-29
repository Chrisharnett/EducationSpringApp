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
        Optional<Student> addedStudent = studentRepository.findById(student.getStudentId());
        if (addedStudent.isPresent()){
            return String.format("Student %d Saved", student.getStudentId());
        } else{
            return String.format("Error adding %s %s", student.getFirstName(), student.getLastName());
        }

    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/view")
    public @ResponseBody Optional<Student> getStudentById(@RequestParam Integer id) {
        return studentRepository.findById(id);
    }

    @PutMapping(path="/modify")
    public @ResponseBody String modifyStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student Updated";
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
