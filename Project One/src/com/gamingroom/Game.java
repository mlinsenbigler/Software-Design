package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	/**
	 * List of teams
	 */
	private List<Team>teams = new ArrayList<Team>();
	
	/**
	 * Public constructor
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	* Uses iterator pattern to find existing team with same name or
	* adds unique named team to list
	*
	* @param name
	* @return Team instance
	*/
	public Team addTeam(String name) {

	Team team = null;     // local team instance

	Iterator<Team> teamsIterator = teams.iterator();  //iInstance iterator

	while (teamsIterator.hasNext()) {     // iterate over teams list

		Team teamInstance = teamsIterator.next();     // set local Team var to next item in list

		if (teamInstance.getName().equalsIgnoreCase(name)) {
			team = teamInstance;      // if team name exists, return the team instance
		} else {
			teams.add(team);        // else add the team to the teams list
		}
	}

	return team;
	}

	@Override
	public String toString() {
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
