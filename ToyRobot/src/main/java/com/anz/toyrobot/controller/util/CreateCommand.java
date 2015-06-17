package com.anz.toyrobot.controller.util;

import com.anz.toyrobot.controller.command.Command;
import com.anz.toyrobot.controller.command.MoveCommand;
import com.anz.toyrobot.controller.command.PlaceCommand;
import com.anz.toyrobot.controller.command.ReportCommand;
import com.anz.toyrobot.controller.command.TurnLeftCommand;
import com.anz.toyrobot.controller.command.TurnRightCommand;
import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;

/**
 * This class handles the creation of Command objects.
 * 
 * @author Neetika
 * 
 */
public class CreateCommand {

	final private static String MOVE = "MOVE";
	final private static String LEFT = "LEFT";
	final private static String RIGHT = "RIGHT";
	final private static String REPORT = "REPORT";
	final private static String PLACE = "PLACE";
	private RobotModel robotModel;

	public CreateCommand(final RobotModel robot) {
		this.robotModel = robot;
	}

	/**
	 * Creates the command object from the String input
	 * 
	 * @param strCommand
	 *            as read from the input file.
	 * @return command object
	 */
	public Command createCommand(final String strCommand) {
		if (MOVE.equals(strCommand)) {
			return new MoveCommand(robotModel);
		} else if (LEFT.equals(strCommand)) {
			return new TurnLeftCommand(robotModel);
		} else if (RIGHT.equals(strCommand)) {
			return new TurnRightCommand(robotModel);
		} else if (REPORT.equals(strCommand)) {
			return new ReportCommand(robotModel);
		} else if (strCommand.startsWith(PLACE)) {
			return parsePlaceCommand(strCommand);
		} else {
			throw new IllegalArgumentException("Unknown command :" + strCommand);
		}
	}

	/**
	 * This method validates and then returns the PLACE command.
	 * 
	 * @param strPlaceCommand
	 *            string PLACE command as input
	 * @return PLACE Command object if valid otherwise throws exception.
	 */
	private Command parsePlaceCommand(final String strPlaceCommand) {
		final String[] halves = strPlaceCommand.split(" ");

		if (halves.length == 2) {
			final String secondPartOfCommandLine = halves[1];
			final String[] parts = secondPartOfCommandLine.split(",");

			if (parts.length == 3) {
				final String x = parts[0];
				final String y = parts[1];
				final String direction = parts[2];

				final Position position = new Position(Integer.valueOf(x),
						Integer.valueOf(y), direction);
				if (robotModel.getTabletop().isValidPosition(
						position)) {
					robotModel.setCurrentPosition(position);
				} else {
					System.out.println(
							"Boundry Reached so PLACE ignored to "
									+ position.getDirection());
				}
				

				return new PlaceCommand(robotModel);
			} else {
				throw new IllegalArgumentException(
						"Place command line doesn't split into three:"
								+ strPlaceCommand);
			}
		} else {
			throw new IllegalArgumentException(
					"Place command line doesn't split into two:"
							+ strPlaceCommand);
		}
	}

}
