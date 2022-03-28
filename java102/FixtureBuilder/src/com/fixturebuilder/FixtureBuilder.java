package com.fixturebuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FixtureBuilder {

	public static void main(String[] args) {
		
		System.out.println("FIXTURE BUILDER\n");
		
		String[] teamInStringArray = null;
		Scanner input = new Scanner(System.in);
		System.out.println("1-Even team count scenario");
		System.out.println("2-Odd team count scenario");
		System.out.print("Which scenario? : ");
		int selectedScenario = input.nextInt();
		input.close();
		switch (selectedScenario) {
			case 1: {
				teamInStringArray = new String[] {
						"Galatasaray",
						"Bursaspor",
						"Fenerbahce",
						"Besiktas",
						"Basaksehir",
						"Trabzonspor"
					};
				break;
			}
			case 2: {
				teamInStringArray = new String[] {
						"Galatasaray",
						"Bursaspor",
						"Fenerbahce",
						"Besiktas",
						"Basaksehir",
						"Trabzonspor",
						"Boluspor"
					};
				break;
			}
		}
		
		int teamCount = teamInStringArray.length; 
		List<Team> teams = new LinkedList<Team>();
		for(int i=0; i<teamCount; i++) {
			teams.add(new Team(i+1, teamInStringArray[i]));
		}
		if(teamCount % 2 != 0) {
			teams.add(new Team(teamCount+1, "PassBy"));
		}
		
		Fixture fixture = new Fixture(teams, 2);
		fixture.build();
	}
}
