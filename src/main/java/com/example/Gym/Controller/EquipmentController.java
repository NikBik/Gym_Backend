package com.example.Gym.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gym.DTO.EquipmentRequest;
import com.example.Gym.Entity.Equipment;
import com.example.Gym.Service.EquipmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * Adds a new piece of gym equipment and saves it to the database.
     * @param request Equipment request data
     * @return The created Equipment entity
     */
    @PostMapping("/addEquipment")
    public ResponseEntity<Equipment> addEquipment(@RequestBody EquipmentRequest request) {
        Equipment equipment = equipmentService.addEquipment(request);
        return ResponseEntity.ok(equipment);
    }

    /**
     * Retrieves equipment details by its ID from the database.
     * @param id Equipment ID
     * @return The Equipment entity
     */
    @GetMapping("/equipment")
    public ResponseEntity<List<Equipment>> getEquipments() {
        List<Equipment> equipment = null;
		try {
			equipment = equipmentService.getEquipments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.ok(equipment);
    }
}
