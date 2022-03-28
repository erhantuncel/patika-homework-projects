package com.fixturebuilder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fixture {

	private List<Team> teams;
	
	private int halfTimeCount;

	public Fixture(List<Team> teams, int halfTimeCount) {
		this.teams = teams;
		this.halfTimeCount = halfTimeCount;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	public int getHalfTimeCount() {
		return halfTimeCount;
	}

	public void setHalfTimeCount(int halfTimeCount) {
		this.halfTimeCount = halfTimeCount;
	}

	public void build() {
		printTeams(this.teams);
		System.out.println("\n");
		
		LinkedList<Team> copyTeams = new LinkedList<Team>();
		copyTeams.addAll(this.teams);
		Collections.shuffle(copyTeams);
		
		int countOfTeams = copyTeams.size();
		LinkedList<LinkedList<Match>> rounds = new LinkedList<LinkedList<Match>>();
		for(int w=0; w<countOfTeams-1; w++) {
			LinkedList<Match> round = new LinkedList<Match>();
			for(int i=0; i<countOfTeams/2; i++) {
				Match match = new Match(copyTeams.get(i), copyTeams.get(countOfTeams-(i+1)));
				round.add(match);
			}
			LinkedList<Team> rotatedTeams = new LinkedList<Team>();
			rotatedTeams.addAll(copyTeams);
			rotatedTeams.set(1, copyTeams.get(countOfTeams-1));
			for(int k=2; k<countOfTeams; k++) {
				rotatedTeams.set(k, copyTeams.get(k-1));
			}
			copyTeams = rotatedTeams;
			rounds.add(round);
		}
		
		int roundNumber = 1;
		for(int i=0; i<this.halfTimeCount; i++) {			
			for(LinkedList<Match> round : rounds) {
				if(i%2 == 0) {					
					printRound(roundNumber, round, false);
				} else {					
					printRound(roundNumber, round, true);
				}
				roundNumber++;
			}
		}
	}

	private void printRound(int roundNumber, LinkedList<Match> round, boolean isSecondHalf) {
		System.out.println("Round " + roundNumber);
		System.out.println("------------------------------");
		for(Match m : round) {
			if(!isSecondHalf) {				
				System.out.println(m.getHomeTeam() + " - " + m.getAwayTeam());
			} else {				
				System.out.println(m.getAwayTeam() + " - " + m.getHomeTeam());
			}
		}
		System.out.println();
	}

	private void printTeams(List<Team> teamsToPrint) {
		System.out.println();
		for(Team t : teamsToPrint) {
			System.out.println(t);
		}
	}
}
