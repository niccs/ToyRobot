package com.anz.toyrobot.controller.command;

import com.anz.toyrobot.model.RobotModel;

/**
 * This class handles the execution and processing of PLACE command.
 * 
 * @author Neetika
 * 
 */
public class PlaceCommand implements Command {
	private RobotModel robotModel;

	public PlaceCommand(final RobotModel robot) {
		robotModel = robot;
	}

	/**
	 * PLACE will put the toy robot on the table in position X,Y and facing
	 * NORTH, SOUTH, EAST or WEST where the origin (0,0) is considered to be the
	 * SOUTH WEST most corner.
	 */
	@Override
	public void execute() {
		if (robotModel.getTabletop().isValidPosition(
				robotModel.getCurrentPosition())) {
		} else {
			System.out.println(
					"Boundry Reached so PLACE ignored to "
							+ robotModel.getCurrentPosition().getDirection());
		}

	}

	@Override
	public String toString() {
		return ("PLACE " + robotModel.toString());
	}

}
