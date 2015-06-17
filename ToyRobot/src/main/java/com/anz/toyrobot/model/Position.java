package com.anz.toyrobot.model;

/**
 * Contains data about the position of toyrobot.
 * 
 * @author Neetika
 * 
 */
public class Position {
	private int x;
	private int y;
	private String direction = "";

	public Position(final int x, final int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return ("Position: " + x + "," + y + "" + direction);
	}

}
