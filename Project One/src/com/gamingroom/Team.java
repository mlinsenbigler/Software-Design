package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	/*
	 * List of teams
	 */
	private List<Player>players = new ArrayList<Player>();
	
	/*
	 * Public constructor
	 */
	public Team(long id, String name) {
		super(id, name);
	}
	
	/**
	* Uses iterator pattern to find existing player with same name or
	* adds unique named player to list
	*
	* @param name
	* @return Player instance
	*/
	public Player addPlayer(String name) {

	Player player = null;  			 // local teams instance

	Iterator<Player> playersIterator = players.iterator();   // instance iterator

	while (playersIterator.hasNext()) {   				// iterate over players list
		Player playerInstance = playersIterator.next();    // set local player to next item in list

		 if (playerInstance.getName().equalsIgnoreCase(name)) {
			 player = playerInstance;     				// if player name exists, return the player instance
		 } else {
			 players.add(player);     					 // else add the player to the players list
		 }
	}

	return player;
}

	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
