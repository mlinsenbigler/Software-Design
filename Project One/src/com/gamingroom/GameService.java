package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/*
 * A singleton service for the game engine
 */
public class GameService {

	/*
	* List of the active games
	*/
	private static List<Game> games = new ArrayList<Game>();

	/*
	* Holds the next game identifier
	*/
	private static long nextGameId = 1;
	
	/*
	* Holds the next team identifier
	*/
	private static long nextPlayerId = 1;
	
	/*
	* Holds the next player identifier
	*/
	private static long nextTeamId = 1;

	/*
	* Private var to track existence of GameService
	*/
	private static GameService service;

	/*
	* Default constructor
	*/
	private GameService() {
	}

	/*
	* Check for existing instance of GameService
	* @return
	*/
	public static GameService getInstance() {

	if (service == null) {
	   service = new GameService();       // if no service, create a new instance
	   System.out.println("New Game Service created.");
	} else {
		System.out.println("Game Service already instantiated.");    // if it exists, output msg
	}

	return service;
	}
	
	/*
	* Construct a new game instance
	*
	* @param name the unique name of the game
	* @return the game instance (new or existing)
	*/
	public Game addGame(String name) {
		Game game = null;           // local game instance

		Iterator<Game> gamesIterator = games.iterator();     // instance iterator of type Game

		while (gamesIterator.hasNext()) {                // iterate over list of games
			Game gameInstance = gamesIterator.next();    // set Game var to next item in list

			if (gameInstance.getName().equalsIgnoreCase(name)) {
				return gameInstance;                     // if game name exists, return the game instance
			}
		}
		
	        if (game == null) {                         // if not, make a new game instance and add to list of games
	           game = new Game(nextGameId++, name);
	           games.add(game);
	        }

	     return game;                              // return the new/existing game instance to the caller
	 }
	
	 /*
	 * Returns the game instance with the specified id.
	 *
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	 public Game getGame(long id) {
		 Game game = null;                // local game instance

	     Iterator <Game> gamesIterator = games.iterator();    // instance iterator

	     while (gamesIterator.hasNext()) {             // iterate over list of games
	    	 Game gameInstance = gamesIterator.next();   // set Game var to next item in list

	    	 if (gameInstance.getId() == id) {
	    		 return gameInstance;            // if game id exists, return the game instance
	    	 }
	     }
	     return game;							// return the new/existing game instance to the caller
	 }
	
	 /*
	  * Returns the game instance with the specified name.
	  *
	  * @param name unique name of game to search for
	  * @return requested game instance
	  */
	  public Game getGame(String name) {
		  Game game = null;                  // local game instance

		  Iterator<Game> gamesIterator = games.iterator();      // instance iterator
	 
		  while (gamesIterator.hasNext()) {         // iterate over games list
			  Game gameInstance = gamesIterator.next();          // set Game var to next item in list

			  if (gameInstance.getName().equalsIgnoreCase(name)) {
				  game = gameInstance;           // if game name exists, return the game instance
			  }
		  }
		  return game;                       // return the new/existing game instance to the caller
	  }
	
	  /*
	  * Returns the number of games currently active
	  *
	  * @return the number of games currently active
	  */
	  public int getGameCount() {
	      return games.size();
	  }

	  /*
	  * Returns the player whose turn is next
	  *
	  * @return the player whose turn is next
	  */
	  public long getNextPlayerId() {
	     return nextPlayerId;
	  }

	  /*
	  * Returns the team whose turn is next
	  *
	  * @return the team whose turn is next
	  */
	  public long getNextTeamId() {
	  return nextTeamId;
	  }
}