package com.anz.toyrobot.controller.command;

import static com.anz.toyrobot.controller.util.Constants.EAST;
import static com.anz.toyrobot.controller.util.Constants.NORTH;
import static com.anz.toyrobot.controller.util.Constants.SOUTH;
import static com.anz.toyrobot.controller.util.Constants.WEST;

import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;

/**
 * This class handles the execution and processing of LEFT command.
 * 
 * @author Neetika
 * 
 */
public class TurnLeftCommand implements Command {
	private RobotModel robotModel;

	public TurnLeftCommand(final RobotModel robot) {
		robotModel = robot;
	}

	/**
	 * LEFT will rotate the robot 90 degrees in the left direction without
	 * changing the position of the robot.
	 */
	@Override
	public void execute() {

		Position currPos = robotModel.getCurrentPosition();
		String currDirection = currPos.getDirection();
		switch (currDirection) {
		case EAST:
			currPos.setDirection(NORTH);
			break;
		case WEST:
			currPos.setDirection(SOUTH);
			break;
		case SOUTH:
			currPos.setDirection(EAST);
			break;
		case NORTH:
			currPos.setDirection(WEST);
			break;
		}

	}

	@Override
	public String toString() {
		return ("LEFT " + robotModel.toString());
	}
}
