package com.anz.toyrobot.controller.command;

import static com.anz.toyrobot.controller.util.Constants.EAST;
import static com.anz.toyrobot.controller.util.Constants.NORTH;
import static com.anz.toyrobot.controller.util.Constants.SOUTH;
import static com.anz.toyrobot.controller.util.Constants.WEST;

import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;

/**
 * This class handles the execution and processing of MOVE command.
 * 
 * @author Neetika
 * 
 */
public class MoveCommand implements Command {

	private RobotModel robotModel;

	public MoveCommand(final RobotModel robot) {
		robotModel = robot;
	}

	/**
	 * MOVE will move the toy robot one unit forward in the direction it is
	 * currently facing
	 */
	@Override
	public void execute() {

		final Position newPosition;
		Position pos = robotModel.getCurrentPosition();
		final int currentX = pos.getX();
		final int currentY = pos.getY();
		final String direction = pos.getDirection();
		switch (direction) {
		case EAST:
			newPosition = new Position(currentX + 1, currentY, direction);
			break;
		case NORTH:
			newPosition = new Position(currentX, currentY + 1, direction);
			break;
		case WEST:
			newPosition = new Position(currentX - 1, currentY, direction);
			break;
		case SOUTH:
			newPosition = new Position(currentX, currentY - 1, direction);
			break;
		default:
			throw new IllegalArgumentException("Unknown Direction"
					+ pos.getDirection());
		}
		if (robotModel.getTabletop().isValidPosition(newPosition)) {
			robotModel.setCurrentPosition(newPosition);
		} else {
			System.out.println("Boundry Reached so MOVE ignored to " + pos.getDirection());
		}

	}

	@Override
	public String toString() {
		return ("MOVE " + robotModel.toString());
	}

}
