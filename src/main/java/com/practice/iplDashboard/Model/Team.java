package com.practice.iplDashboard.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private long matchWon;
	@Transient
	private List<Match> matches;

	public Team() {

	}

	public Team(String name, long totalMatches) {
		super();
		this.name = name;
		this.totalMatches = totalMatches;
	}

	private long totalMatches;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMatchWon() {
		return matchWon;
	}

	public void setMatchWon(long matchWon) {
		this.matchWon = matchWon;
	}

	public long getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(long totalMatches) {
		this.totalMatches = totalMatches;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", matchWon=" + matchWon + ", totalMatches=" + totalMatches + "]";
	}

}
