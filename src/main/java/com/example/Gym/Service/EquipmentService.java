package com.example.Gym.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gym.DTO.EquipmentRequest;
import com.example.Gym.Dao.EquipmentDao;
import com.example.Gym.Entity.Equipment;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;

    /**
     * Adds a new equipment entry and saves it to the database.
     * @param request Equipment request data
     * @return The created Equipment entity
     */
    public Equipment addEquipment(EquipmentRequest request) {
        Equipment equipment = new Equipment();
        equipment.setName(request.getName());
        equipment.setStatus(request.getStatus());
        return equipmentDao.save(equipment);
    }

    /**
     * Retrieves equipment from the database by its ID.
     * @param id Equipment ID
     * @return The Equipment entity
     * @throws Exception 
     * @throws ResourceNotFoundException If equipment is not found
     */
    public List<Equipment> getEquipments() throws Exception {
        return equipmentDao.findAll();
    }
}
