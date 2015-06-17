package com.anz.toyrobot.controller.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.anz.toyrobot.controller.command.Command;
import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;
import com.anz.toyrobot.model.TableTop;

/**
 * This class handles the necessary setups and processes the input commands
 * file.
 * 
 * @author Neetika
 * 
 */
public class ProcessInput {
	RobotModel robotModel;

	/**
	 * This method will retrieve commands from the imput file and process it
	 * 
	 * @param fileName
	 *            the input file name containing toyrobot commands
	 */
	public void processCommandsFromFile(String fileName) {

		final List<Command> commands = new ArrayList<>();
		final CreateCommand commandCreator = new CreateCommand(robotModel);
		final ReadFile readFile = new ReadFile();
		InputStream iStream = this.getClass().getClassLoader()
				.getResourceAsStream(fileName);
		if (fileName == null || iStream == null) {
			throw new IllegalArgumentException("Invalid input file ");
		}
		final List<String> lines = readFile.readToyRobotCommands(iStream);

		if (lines.isEmpty()) {
			throw new IllegalArgumentException("Input file is empty");
		}
		if (validPlaceCommand(lines.get(0))) {
			for (String strCommand : lines) {
				if (strCommand == null || "".equals(strCommand.trim())) {
					continue;
				}
				if (!isAllowedCommandString(strCommand)) {
					System.out.println("Not a valid command so ignored "
							+ strCommand);
					continue;
				}
				final Command command = commandCreator
						.createCommand(strCommand);
				commands.add(command);
				command.execute();
				// System.out.println(command);
			}

		}

	}

	/**
	 * checks if commands in file are one from MOVE,PLACE,LEFT,RIGHT,REPORT
	 * 
	 * @param strCommand
	 * @return true if command read is allowed
	 */
	private boolean isAllowedCommandString(String strCommand) {
		return (strCommand.startsWith("PLACE") || "MOVE".equals(strCommand)
				|| "LEFT".equals(strCommand) || "RIGHT".equals(strCommand) || "REPORT"
					.equals(strCommand));
	}

	/**
	 * Initializes the model with default values
	 */
	public void initializeModel() {
		robotModel = new RobotModel(new TableTop(5, 5), new Position(0, 0,
				"NORTH"));
	}

	/**
	 * Checks the first input command should be PLACE and its valid format.
	 * 
	 * @param firstCommand
	 *            the first command read from the input file.
	 * @return true if the input is PLACE command and in valid format
	 */
	public boolean validPlaceCommand(String firstCommand) {
		boolean isValidPlaceCmd = false;
		if (null != firstCommand && firstCommand.startsWith("PLACE")) {
			final String[] splitBySpace = firstCommand.split(" ");
			if (splitBySpace.length == 2) {

				final String secondPartOfPLACECmd = splitBySpace[1];
				final String[] totalSplits = secondPartOfPLACECmd.split(",");
				if (totalSplits.length == 3) {
					isValidPlaceCmd = true;
				} else {
					isValidPlaceCmd = false;
					throw new IllegalArgumentException(
							"Place command is invalid" + firstCommand);
				}
			} else {
				isValidPlaceCmd = false;
				throw new IllegalArgumentException("Place command is invalid"
						+ firstCommand);
			}
		} else {
			isValidPlaceCmd = false;
			throw new IllegalArgumentException(
					"Valid PLACE command should be the starting command for toyrobot placing instead of "
							+ firstCommand);
		}
		return isValidPlaceCmd;
	}
}
