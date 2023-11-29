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
    public @ResponseBody String addNewPrograms (@RequestBody Programs programs) {
        programsRepository.save(programs);
        return "Program Saved";
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Programs> getAllPrograms() {
        return programsRepository.findAll();
    }

    @GetMapping(path = "/view")
    public @ResponseBody Optional<Programs> getProgramsById(@RequestParam Integer id) {
        return programsRepository.findById(id);
    }

    @PutMapping(path="/modify")
    public @ResponseBody String modifyPrograms(@RequestBody Programs programs){
        programsRepository.save(programs);
        return "Programs Updated";
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deletePrograms(@PathVariable Integer id){
        programsRepository.deleteById(id);
        return "Programs Deleted";
    }

}
