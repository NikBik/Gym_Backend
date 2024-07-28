package com.example.Gym.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GYM_PROGRAMS")
public class GymProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long programId;

	private String programNames;
	private String description;
	private double charges;
	private String period;

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public String getProgramNames() {
		return programNames;
	}

	public void setProgramNames(String programNames) {
		this.programNames = programNames;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}
