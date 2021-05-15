package com.practice.iplDashboard.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.practice.iplDashboard.Model.Team;

public interface TeamRepository extends CrudRepository<Team,Long> {
	public Team findByName(String name);
	public List<Team> findAll();
}
