package com.example.Gym.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gym.DTO.WorkoutRequest;
import com.example.Gym.Entity.GymProgram;
import com.example.Gym.Entity.Workout;
import com.example.Gym.Service.WorkoutService;

@RestController
@RequestMapping("/api/workouts")
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
	public ResponseEntity<Workout> createWorkout(@RequestBody WorkoutRequest request) {
		Workout workout = workoutService.createWorkout(request);
		return ResponseEntity.ok(workout);
	}

	/**
	 * Retrieves a workout record by its ID from the database.
	 * 
	 * @param id Workout ID
	 * @return The Workout entity
	 */
	@GetMapping("/getWorkout")
	public ResponseEntity<?> getWorkout(@RequestParam("id") Long id) {
		List<GymProgram> gymProgList = new ArrayList<GymProgram>();
		try {
			gymProgList = workoutService.getWorkout(id);
			if (gymProgList.size() > 0) {
				return ResponseEntity.ok(gymProgList);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("No subsctiption found. Please subscribe to some work plan to track your progress.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Difficulty in fetching workout programs");
		}

	}
}
