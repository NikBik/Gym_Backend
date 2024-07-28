package com.example.Gym.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gym.DTO.WorkoutRequest;
import com.example.Gym.Dao.MembershipDao;
import com.example.Gym.Dao.WorkoutDao;
import com.example.Gym.Entity.GymProgram;
import com.example.Gym.Entity.Membership;
import com.example.Gym.Entity.Workout;

@Service
public class WorkoutService {

	@Autowired
	private MembershipDao membershipDao;
	@Autowired
	private WorkoutDao workoutDao;
	@Autowired
	private GymProgramService gymProgramService;

	/**
	 * Creates a new workout entry and saves it to the database.
	 * 
	 * @param request Workout request data
	 * @return The created Workout entity
	 */
	public Workout createWorkout(Long userId, Long programId, String details) {
		Workout workout = new Workout();
		workout.setUserId(userId);
		workout.setProgramId(programId);
		workout.setDetails(details);
		workout.setWorkoutDate(LocalDate.now());
		return workoutDao.save(workout);
	}

	/**
	 * Retrieves a workout from the database by its ID.
	 * 
	 * @param id Workout ID
	 * @return The Workout entity
	 * @throws Exception
	 * @throws ResourceNotFoundException If workout is not found
	 */
	public List<GymProgram> getWorkout(Long id) throws Exception {
		List<Membership> membershipList = new ArrayList<Membership>();
		try {
			membershipList = membershipDao.findByUserId(id);
			List<GymProgram> gymPrograms = gymProgramService.getAllGymPrograms();
			List<GymProgram> filteredList = new ArrayList<GymProgram>();

			for (Membership m : membershipList) {
				for (GymProgram g : gymPrograms) {
					if (m.getPlanId().equals(g.getProgramId())) {
						System.out.println(g.toString());
						filteredList.add(g);
					}
				}
			}
			return filteredList;
		} catch (Exception e) {
			throw new Exception("Unable to find Out any memberships");
		}
	}

	public List<Workout> getWorkoutDetails(Long id) {
		List<Workout> workoutList = new ArrayList<Workout>();
		workoutList = workoutDao.findByUserId(id);
		return workoutList;
	}
}
