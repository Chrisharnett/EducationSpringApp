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
@RequestMapping(path="/programs")
public class ProgramsController {
    @Autowired
    private ProgramsRepository programsRepository;

    @PostMapping(path="/add")
    public @ResponseBody Programs addNewPrograms (@RequestBody Programs programs) {
        return programsRepository.save(programs);
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Programs> getAllPrograms() {
        return programsRepository.findAll();
    }

    @GetMapping(path = "/view/{id}")
    public @ResponseBody Optional<Programs> getProgramsById(@PathVariable Integer id) {
        return programsRepository.findById(id);
    }

    @PutMapping(path="/modify")
    public @ResponseBody Programs modifyPrograms(@RequestBody Programs programs){
        return programsRepository.save(programs);
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void deletePrograms(@PathVariable Integer id){
        programsRepository.deleteById(id);
    }
}
