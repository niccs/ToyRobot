package com.anz.toyrobot.controller.command;

import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;

/**
 * This class handles the execution and processing of REPORT command.
 * 
 * @author Neetika
 * 
 */
public class ReportCommand implements Command {
	private RobotModel robotModel;

	public ReportCommand(final RobotModel robot) {
		robotModel = robot;
	}

	/**
	 * REPORT will announce the X,Y and F of the robot as Standard output.
	 */
	@Override
	public void execute() {
		Position currPos = robotModel.getCurrentPosition();
		System.out.println(currPos.getX() + "," + currPos.getY() + ","
				+ currPos.getDirection());

	}

	@Override
	public String toString() {
		return ("REPORT " + robotModel.toString());
	}

}
