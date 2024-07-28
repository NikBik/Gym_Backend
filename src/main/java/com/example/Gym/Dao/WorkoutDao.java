package com.example.Gym.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gym.Entity.Workout;

@Repository
public interface WorkoutDao extends JpaRepository<Workout, Long> {
}
