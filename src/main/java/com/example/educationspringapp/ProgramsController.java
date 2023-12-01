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
        return String.format("%s saved.", programs.getProgramName());
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
    public @ResponseBody String modifyPrograms(@RequestBody Programs programs){
        Optional<Programs> programToModify = programsRepository.findById(programs.getPid());
        if (programToModify.isPresent()) {
            programsRepository.save(programs);
            return String.format("Program %d updated", programs.getPid());
        }
        else{
            return String.format("Program %s not found.", programs.getPid());
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deletePrograms(@PathVariable Integer id){
        Optional<Programs> programsToDelete = programsRepository.findById(id);
        if(programsToDelete.isEmpty()){
            return String.format("Program %d not found.", id);
        } else {
            programsRepository.deleteById(id);
            return String.format("Program %d deleted", id);
        }

    }

}
