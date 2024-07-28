package com.example.Gym.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gym.Entity.Equipment;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment, Long> {
}
