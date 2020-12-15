package com.gamingroom;

/**
 * A simple class to hold information about an entity
 * 
 * @author Michael Linsenbigler
 *
 */
public class Entity {

	/**
	 * Private attributes
	 */
	private long id;
	private String name;

	/**
	 * Default constructor
	 */
	private Entity() {
	}

	/**
	 * Public cconstructor
	 */
	public Entity(long id, String name) {
		this(); 				// call default constructor
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}
