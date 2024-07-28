package com.example.Gym.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gym.DTO.ClassRequest;
import com.example.Gym.Entity.GymClass;
import com.example.Gym.Service.ClassService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ClassController {

    @Autowired
    private ClassService classService;

    /**
     * Creates a new gym class with the specified name and schedule
     * and saves it to the database.
     * @param request Class creation request data
     * @return The created GymClass entity
     */
    @PostMapping("/addClass")
    public ResponseEntity<GymClass> createClass(@RequestBody ClassRequest request) {
        GymClass gymClass = classService.createClass(request);
        return ResponseEntity.ok(gymClass);
    }

    /**
     * Retrieves a list of all gym classes from the database.
     * @return List of GymClass entities
     */
    @GetMapping("/classes")
    public ResponseEntity<List<GymClass>> getAllClasses() {
        List<GymClass> classes = classService.getAllClasses();
        return ResponseEntity.ok(classes);
    }
}
