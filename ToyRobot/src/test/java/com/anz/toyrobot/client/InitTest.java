package com.anz.toyrobot.client;

import org.junit.Before;
import org.junit.Test;

import com.anz.toyrobot.controller.util.ProcessInput;

public class InitTest {
	ProcessInput initializeRobot;

	@Before
	public void setUp() throws Exception {
		initializeRobot = new ProcessInput();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPlaceCommand() {
		initializeRobot.validPlaceCommand("PLACE");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPlaceCommand1() {
		initializeRobot.validPlaceCommand("PLACE X");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPlaceCommand2() {
		initializeRobot.validPlaceCommand("PLACE 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPlaceCommand3() {
		initializeRobot.validPlaceCommand("INVALID");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPlaceCommand4() {
		initializeRobot.validPlaceCommand("PLACE 1,2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPlaceCommand5() {
		initializeRobot.validPlaceCommand("PLACE 1,2 NORTH");
	}

}
