package com.anz.toyrobot.controller.command;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.anz.toyrobot.controller.command.ReportCommand;
import com.anz.toyrobot.controller.command.TurnLeftCommand;
import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;
import com.anz.toyrobot.model.TableTop;

public class TurnLeftCommandTest {

	private TurnLeftCommand TurnLeftCmd;
	private ReportCommand report;
	List<RobotModel> robotModels = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(1, 2,
				"EAST")));
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(1, 2,
				"NORTH")));
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(4, 4,
				"SOUTH")));
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(4, 3,
				"WEST")));
	}

	@Test
	public void testTurnLeft1() {
		RobotModel testRobot = robotModels.get(0);
		TurnLeftCmd = new TurnLeftCommand(testRobot);
		report = new ReportCommand(testRobot);
		TurnLeftCmd.execute();
		report.execute();
		assertEquals(1, testRobot.getCurrentPosition().getX());
		assertEquals(2, testRobot.getCurrentPosition().getY());
		assertEquals("NORTH", testRobot.getCurrentPosition().getDirection());

	}

	@Test
	public void testTurnLeft2() {
		RobotModel testRobot = robotModels.get(1);
		TurnLeftCmd = new TurnLeftCommand(testRobot);
		report = new ReportCommand(testRobot);
		TurnLeftCmd.execute();
		report.execute();
		assertEquals(1, testRobot.getCurrentPosition().getX());
		assertEquals(2, testRobot.getCurrentPosition().getY());
		assertEquals("WEST", testRobot.getCurrentPosition().getDirection());

	}

	@Test
	public void testTurnLeft3() {
		RobotModel testRobot = robotModels.get(2);
		TurnLeftCmd = new TurnLeftCommand(testRobot);
		report = new ReportCommand(testRobot);
		TurnLeftCmd.execute();
		report.execute();
		assertEquals(4, testRobot.getCurrentPosition().getX());
		assertEquals(4, testRobot.getCurrentPosition().getY());
		assertEquals("EAST", testRobot.getCurrentPosition().getDirection());
	}

	@Test
	public void testTurnLeft4() {
		RobotModel testRobot = robotModels.get(3);
		TurnLeftCmd = new TurnLeftCommand(testRobot);
		report = new ReportCommand(testRobot);
		TurnLeftCmd.execute();
		report.execute();
		assertEquals(4, testRobot.getCurrentPosition().getX());
		assertEquals(3, testRobot.getCurrentPosition().getY());
		assertEquals("SOUTH", testRobot.getCurrentPosition().getDirection());
	}

}
