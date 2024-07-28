package com.example.Gym.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gym.DTO.ClassRequest;
import com.example.Gym.Dao.ClassDao;
import com.example.Gym.Entity.GymClass;

@Service
public class ClassService {

    @Autowired
    private ClassDao classDao;

    /**
     * Creates a new gym class and saves it to the database.
     * @param request Class creation request data
     * @return The created GymClass entity
     */
    public GymClass createClass(ClassRequest request) {
        GymClass gymClass = new GymClass();
        gymClass.setName(request.getName());
        gymClass.setSchedule(request.getSchedule());
        return classDao.save(gymClass);
    }

    /**
     * Retrieves all gym classes from the database.
     * @return List of GymClass entities
     */
    public List<GymClass> getAllClasses() {
        return classDao.findAll();
    }
}
