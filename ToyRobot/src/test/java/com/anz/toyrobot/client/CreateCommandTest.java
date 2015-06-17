package com.anz.toyrobot.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.anz.toyrobot.controller.command.Command;
import com.anz.toyrobot.controller.command.MoveCommand;
import com.anz.toyrobot.controller.command.PlaceCommand;
import com.anz.toyrobot.controller.command.ReportCommand;
import com.anz.toyrobot.controller.command.TurnLeftCommand;
import com.anz.toyrobot.controller.command.TurnRightCommand;
import com.anz.toyrobot.controller.util.CreateCommand;
import com.anz.toyrobot.model.Position;
import com.anz.toyrobot.model.RobotModel;
import com.anz.toyrobot.model.TableTop;

public class CreateCommandTest {
	private CreateCommand createCommand;
	private RobotModel robotModel;
	@Before
	public void setUp() throws Exception {
		robotModel=new RobotModel(new TableTop(5, 5), new Position(0, 0, "NORTH"));
		createCommand = new CreateCommand(robotModel);
		
	}

	@Test
	public void testMoveCommand() {
		final Command cmd = createCommand.createCommand("MOVE");
		assertTrue(cmd instanceof MoveCommand);
	}
	@Test
	public void testReportCommand() {
		final Command cmd = createCommand.createCommand("REPORT");
		assertTrue(cmd instanceof ReportCommand);
	}
	@Test
	public void testTurnLeftCommand() {
		final Command cmd = createCommand.createCommand("LEFT");
		assertTrue(cmd instanceof TurnLeftCommand);
	}
	@Test
	public void testTurnTightCommand() {
		final Command cmd = createCommand.createCommand("RIGHT");
		assertTrue(cmd instanceof TurnRightCommand);
	}
	@Test()
	public void testPlaceCommand() {
		final Command cmd = createCommand.createCommand("PLACE 1,2,NORTH");
		assertTrue(cmd instanceof PlaceCommand);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidParseCommand() {
		 createCommand.createCommand("PLACE");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidParseCommand1() {
		 createCommand.createCommand("PLACE X");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidParseCommand2() {
		 createCommand.createCommand("PLACE 1");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidParseCommand3() {
		 createCommand.createCommand("INVALID");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidParseCommand4() {
		 createCommand.createCommand("PLACE 1,2");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidParseCommand5() {
		final Command cmd = createCommand.createCommand("PLACE 1,2 NORTH");
	}
}
