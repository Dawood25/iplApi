package com.practice.iplDashboard.controller;

import java.util.List;

import com.practice.iplDashboard.Model.Team;
import com.practice.iplDashboard.repository.MatchRepository;
import com.practice.iplDashboard.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class TeamController {
		private TeamRepository teamRepo;
		private MatchRepository matchRepo;
	
		@Autowired
		public  TeamController(TeamRepository teamRepo,MatchRepository matchRepository) {
			this.matchRepo=matchRepository;
			this.teamRepo=teamRepo;
		}
		@RequestMapping(value="/teams/{teamName}",method = RequestMethod.GET)
		public Team getTeam(@PathVariable String teamName) {
			Team team= this.teamRepo.findByName(teamName);
			team.setMatches(matchRepo.findLatestMatchByTeamName(teamName,5));
			return team;
		}
		@GetMapping(value="/Allteams")
		public List<Team> getMethodName() {
			
			return this.teamRepo.findAll();
		}
		
		
	
}
