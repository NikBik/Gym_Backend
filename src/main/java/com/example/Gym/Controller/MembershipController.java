package com.example.Gym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gym.DTO.SubscriptionRequest;
import com.example.Gym.Entity.Membership;
import com.example.Gym.Service.MembershipService;

@RestController
@RequestMapping("/api/memberships")
@CrossOrigin("*")
public class MembershipController {

	@Autowired
	private MembershipService membershipService;

	/**
	 * Processes a subscription request by creating a new membership entry and
	 * saving it to the database.
	 * 
	 * @param request Subscription request data
	 * @return The created Membership entity
	 */
	@PostMapping("/subscribe")
	public ResponseEntity<Membership> subscribe(@RequestParam("userId") Integer userId,
			@RequestParam("planId") Integer planId) {
		SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
		subscriptionRequest.setPlanId(Long.valueOf(planId));
		subscriptionRequest.setUserId(Long.valueOf(userId));
		Membership membership = membershipService.subscribe(subscriptionRequest);
		return ResponseEntity.ok(membership);
	}

	/**
	 * Retrieves a membership by its ID from the database.
	 * 
	 * @param id Membership ID
	 * @return The Membership entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Membership> getMembership(@PathVariable Long id) {
		Membership membership = null;
		try {
			membership = membershipService.getMembership(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(membership);
	}
}
