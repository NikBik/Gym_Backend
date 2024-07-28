package com.example.Gym.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Gym.Entity.GymProgram;

public interface GymServiceRepositoryDao extends JpaRepository<GymProgram, Long>{

}
