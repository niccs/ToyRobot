package com.anz.toyrobot.controller.command;

import static com.anz.toyrobot.controller.util.Constants.EAST;
import static com.anz.toyrobot.controller.util.Constants.NORTH;
import static com.anz.toyrobot.controller.util.Constants.SOUTH;
import static com.anz.toyrobot.controller.util.Constants.WEST;

import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;

/**
 * This class handles the execution and processing of RIGHT command.
 * 
 * @author Neetika
 * 
 */
public class TurnRightCommand implements Command {
	private RobotModel robotModel;

	public TurnRightCommand(final RobotModel robot) {
		robotModel = robot;
	}

	/**
	 * RIGHT will rotate the robot 90 degrees in the right direction without
	 * changing the position of the robot.
	 */
	@Override
	public void execute() {

		Position currPos = robotModel.getCurrentPosition();
		String currDirection = currPos.getDirection();
		switch (currDirection) {
		case EAST:
			currPos.setDirection(SOUTH);
			break;
		case WEST:
			currPos.setDirection(NORTH);
			break;
		case SOUTH:
			currPos.setDirection(WEST);
			break;
		case NORTH:
			currPos.setDirection(EAST);
			break;
		}

	}

	@Override
	public String toString() {
		return ("RIGHT " + robotModel.toString());
	}
}