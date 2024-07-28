package com.example.Gym.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gym.Entity.GymProgram;
import com.example.Gym.Entity.Workout;
import com.example.Gym.Service.WorkoutService;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin("*")
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;

	/**
	 * Adds a new workout entry for a user and saves it to the database.
	 * 
	 * @param request Workout request data
	 * @return The created Workout entity
	 */
	@PostMapping("/addWorkout")
	public ResponseEntity<Workout> createWorkout(@RequestParam("userId") Long userId,
			@RequestParam("programId") Long programId, @RequestParam("details") String details) {
		Workout workout = workoutService.createWorkout(userId, programId, details);
		return ResponseEntity.ok(workout);
	}

	@GetMapping("/getWorkout")
	public ResponseEntity<?> getWorkout(@RequestParam("id") Long id) {
		List<GymProgram> gymProgList = new ArrayList<GymProgram>();
		try {
			gymProgList = workoutService.getWorkout(id);

			return ResponseEntity.ok(gymProgList);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Difficulty in fetching workout programs");
		}

	}

	@GetMapping("/getWorkoutDetails")
	public ResponseEntity<?> getWorkoutDetails(@RequestParam("id") Long id) {
		List<Workout> workouts = new ArrayList<>();
		try {
			workouts = workoutService.getWorkoutDetails(id);

			return ResponseEntity.ok(workouts);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Difficulty in fetching workout programs");
		}

	}
}
