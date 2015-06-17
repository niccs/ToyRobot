package com.anz.toyrobot.controller.command;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.anz.toyrobot.controller.command.MoveCommand;
import com.anz.toyrobot.controller.command.ReportCommand;
import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;
import com.anz.toyrobot.model.TableTop;

public class MoveCommandTest {

	private MoveCommand moveCmd;
	private ReportCommand report;
	List<RobotModel> robotModels=new ArrayList<>();
	@Before
	public void setUp() throws Exception {
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(1, 2, "EAST")));
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(5, 5, "EAST")));
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(4, 4, "NORTH")));
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(4, 4, "SOUTH")));
		robotModels.add(new RobotModel(new TableTop(5, 5), new Position(4, 3, "WEST")));
	}

	@Test
	public void testMove1() {
		RobotModel testRobot =robotModels.get(0);
		moveCmd = new MoveCommand(testRobot);
		report=new ReportCommand(testRobot);
		moveCmd.execute();
		report.execute();
		assertEquals(2, testRobot.getCurrentPosition().getX());
		assertEquals(2, testRobot.getCurrentPosition().getY());
		assertEquals("EAST", testRobot.getCurrentPosition().getDirection());
		
	}
	
	@Test
	public void testMove2() {
		RobotModel testRobot =robotModels.get(1);
		moveCmd = new MoveCommand(testRobot);
		report=new ReportCommand(testRobot);
		moveCmd.execute();
		report.execute();
		assertEquals(5, testRobot.getCurrentPosition().getX());
		assertEquals(5, testRobot.getCurrentPosition().getY());
		assertEquals("EAST", testRobot.getCurrentPosition().getDirection());
	}
	
	@Test
	public void testMove3() {
		RobotModel testRobot =robotModels.get(2);
		moveCmd = new MoveCommand(testRobot);
		report=new ReportCommand(testRobot);
		moveCmd.execute();
		report.execute();
		assertEquals(4, testRobot.getCurrentPosition().getX());
		assertEquals(4, testRobot.getCurrentPosition().getY());
		assertEquals("NORTH", testRobot.getCurrentPosition().getDirection());
	}
	@Test
	public void testMove4() {
		RobotModel testRobot =robotModels.get(3);
		moveCmd = new MoveCommand(testRobot);
		report=new ReportCommand(testRobot);
		moveCmd.execute();
		report.execute();
		assertEquals(4, testRobot.getCurrentPosition().getX());
		assertEquals(3, testRobot.getCurrentPosition().getY());
		assertEquals("SOUTH", testRobot.getCurrentPosition().getDirection());
	}
	@Test
	public void testMove5() {
		RobotModel testRobot =robotModels.get(4);
		moveCmd = new MoveCommand(testRobot);
		report=new ReportCommand(testRobot);
		moveCmd.execute();
		report.execute();
		assertEquals(3, testRobot.getCurrentPosition().getX());
		assertEquals(3, testRobot.getCurrentPosition().getY());
		assertEquals("WEST", testRobot.getCurrentPosition().getDirection());
	}
}
