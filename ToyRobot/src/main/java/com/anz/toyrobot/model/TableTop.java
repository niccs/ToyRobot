package com.anz.toyrobot.model;

import java.util.Arrays;
import java.util.List;

import static com.anz.toyrobot.controller.util.Constants.*;

/**
 * Contains data about the tabletop.
 * 
 * @author Neetika
 * 
 */
public class TableTop {
	private int maxRowSize;
	private int maxColSize;
	List<String> possibleDirections = Arrays.asList(NORTH, EAST, WEST, SOUTH);

	public TableTop(final int row, final int col) {
		this.maxRowSize = row - 1;
		this.maxColSize = col - 1;
	}

	/**
	 * Validates the toyrobot position so that it must be prevented from falling
	 * to destruction.
	 * 
	 * @param position
	 * @return true if the toyrobot
	 */
	public boolean isValidPosition(final Position position) {
		if (position.getX() <= maxRowSize && position.getX() >= 0
				&& position.getY() <= maxColSize && position.getY() >= 0
				&& possibleDirections.contains(position.getDirection())) {
			return true;
		}

		return false;
	}

}
