package com.fixturebuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Team {

	private int id;
	private String name;
	
	private Set<Team> matchedTeams;
	
	public Team(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		matchedTeams = new HashSet<Team>();
	}
	
	public void addMathcedTeam(Team team) {
		this.matchedTeams.add(team);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Team> getMatchedTeams() {
		return matchedTeams;
	}

	public void setMatchedTeams(Set<Team> matchedTeams) {
		this.matchedTeams = matchedTeams;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
