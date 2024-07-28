package com.example.Gym.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gym.Entity.Workout;

@Repository
public interface WorkoutDao extends JpaRepository<Workout, Long> {

	List<Workout> findByUserId(Long id);
}
