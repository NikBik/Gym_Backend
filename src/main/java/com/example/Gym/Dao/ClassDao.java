package com.example.Gym.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gym.Entity.GymClass;

@Repository
public interface ClassDao extends JpaRepository<GymClass, Long> {
}
