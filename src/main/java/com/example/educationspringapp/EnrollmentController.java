package com.example.educationspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author saxDev
 * studentnumber 20188141
 **/
@Controller
@RequestMapping(path="/api/cna/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
}
