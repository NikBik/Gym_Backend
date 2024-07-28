package com.example.Gym.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gym.Dao.GymServiceRepositoryDao;
import com.example.Gym.Entity.GymProgram;

@Service
public class GymProgramService {

	@Autowired
	private GymServiceRepositoryDao gymServiceRepositoryDao;

	public List<GymProgram> getAllGymPrograms() {
		return gymServiceRepositoryDao.findAll();
	}
}
