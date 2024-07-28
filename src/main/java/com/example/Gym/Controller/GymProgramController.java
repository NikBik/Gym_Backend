package com.example.Gym.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gym.Entity.GymProgram;
import com.example.Gym.Service.GymProgramService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GymProgramController {
	
	@Autowired
	private GymProgramService gymProgramService;
	/**
     * Retrieves a list of all gym programs from the database.
     * @return List of GymClass entities
     */
    @GetMapping("/programs")
    public ResponseEntity<List<GymProgram>> getAllClasses() {
        List<GymProgram> programs = gymProgramService.getAllGymPrograms();
        return ResponseEntity.ok(programs);
    }
}
