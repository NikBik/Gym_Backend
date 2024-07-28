package com.example.Gym.DTO;

import java.time.LocalDateTime;

public class ClassRequest {

    private String name;
    private LocalDateTime schedule;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getSchedule() {
		return schedule;
	}
	public void setSchedule(LocalDateTime schedule) {
		this.schedule = schedule;
	}
}
