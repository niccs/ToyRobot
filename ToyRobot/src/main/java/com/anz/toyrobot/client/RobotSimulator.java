package com.anz.toyrobot.client;

import com.anz.toyrobot.controller.util.ProcessInput;

/**
 * This is the client class to start the toyrobot simulator.
 * 
 * @author Neetika
 * 
 */
public class RobotSimulator {

	public static void main(String[] args) {

		if (args.length == 0 || args[0] == null) {
			throw new IllegalArgumentException("Invalid input arguments");
		}
		// take file name as first param
		final String fileName = args[0];
		ProcessInput processInput = new ProcessInput();
		processInput.initializeModel();
		processInput.processCommandsFromFile(fileName);
	}

}
