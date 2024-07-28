package com.example.Gym.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gym.DTO.SubscriptionRequest;
import com.example.Gym.Dao.MembershipDao;
import com.example.Gym.Entity.Membership;

@Service
public class MembershipService {

    @Autowired
    private MembershipDao membershipDao;

    /**
     * Creates a new membership entry and saves it to the database.
     * @param request Subscription request data
     * @return The created Membership entity
     */
    public Membership subscribe(SubscriptionRequest request) {
        Membership membership = new Membership();
        membership.setUserId(request.getUserId());
        membership.setPlanId(request.getPlanId());
        membership.setStartDate(LocalDate.now());
        return membershipDao.save(membership);
    }

    /**
     * Retrieves a membership from the database by its ID.
     * @param id Membership ID
     * @return The Membership entity
     * @throws Exception 
     * @throws ResourceNotFoundException If membership is not found
     */
    public Membership getMembership(Long id) throws Exception {
        return membershipDao.findById(id).orElseThrow(() -> new Exception("Membership not found"));
    }
}
