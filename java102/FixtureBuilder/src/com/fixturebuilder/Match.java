package com.fixturebuilder;

public class Match {

	private Team homeTeam;
	private Team awayTeam;
	
	public Match(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		homeTeam.addMathcedTeam(awayTeam);
		awayTeam.addMathcedTeam(homeTeam);
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	
}
