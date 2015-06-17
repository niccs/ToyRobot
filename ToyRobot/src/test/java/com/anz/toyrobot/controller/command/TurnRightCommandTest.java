package com.anz.toyrobot.controller.command;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.anz.toyrobot.controller.command.ReportCommand;
import com.anz.toyrobot.controller.command.TurnRightCommand;
import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;
import com.anz.toyrobot.model.TableTop;

public class TurnRightCommandTest {

	private TurnRightCommand TurnRightCmd;
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
	public void testTurnRight1() {
		RobotModel testRobot = robotModels.get(0);
		TurnRightCmd = new TurnRightCommand(testRobot);
		report = new ReportCommand(testRobot);
		TurnRightCmd.execute();
		report.execute();
		assertEquals(1, testRobot.getCurrentPosition().getX());
		assertEquals(2, testRobot.getCurrentPosition().getY());
		assertEquals("SOUTH", testRobot.getCurrentPosition().getDirection());

	}

	@Test
	public void testTurnRight2() {
		RobotModel testRobot = robotModels.get(1);
		TurnRightCmd = new TurnRightCommand(testRobot);
		report = new ReportCommand(testRobot);
		TurnRightCmd.execute();
		report.execute();
		assertEquals(1, testRobot.getCurrentPosition().getX());
		assertEquals(2, testRobot.getCurrentPosition().getY());
		assertEquals("EAST", testRobot.getCurrentPosition().getDirection());

	}

	@Test
	public void testTurnRight3() {
		RobotModel testRobot = robotModels.get(2);
		TurnRightCmd = new TurnRightCommand(testRobot);
		report = new ReportCommand(testRobot);
		TurnRightCmd.execute();
		report.execute();
		assertEquals(4, testRobot.getCurrentPosition().getX());
		assertEquals(4, testRobot.getCurrentPosition().getY());
		assertEquals("WEST", testRobot.getCurrentPosition().getDirection());
	}

	@Test
	public void testTurnRight4() {
		RobotModel testRobot = robotModels.get(3);
		TurnRightCmd = new TurnRightCommand(testRobot);
		report = new ReportCommand(testRobot);
		TurnRightCmd.execute();
		report.execute();
		assertEquals(4, testRobot.getCurrentPosition().getX());
		assertEquals(3, testRobot.getCurrentPosition().getY());
		assertEquals("NORTH", testRobot.getCurrentPosition().getDirection());
	}

}
