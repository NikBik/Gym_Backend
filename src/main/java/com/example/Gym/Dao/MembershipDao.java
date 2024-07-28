package com.example.Gym.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gym.Entity.Membership;

@Repository
public interface MembershipDao extends JpaRepository<Membership, Long> {
	List<Membership> findByUserId(Long userId);
}
