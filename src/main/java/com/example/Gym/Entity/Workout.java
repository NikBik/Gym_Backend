package com.example.Gym.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="user_id")
    private Long userId;
    @Column(name="program_id")
    private Long programId;
    @Column(name="details")
    private String details;
    @Column(name="workout_date")
    private LocalDate workoutDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getWorkoutDate() {
		return workoutDate;
	}
	public void setWorkoutDate(LocalDate workoutDate) {
		this.workoutDate = workoutDate;
	}

}
