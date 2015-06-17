package com.anz.toyrobot.client;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.anz.toyrobot.controller.util.ReadFile;

public class ReadFileTest {
	private ReadFile readFile;
	InputStream iStream;

	@Before
	public void setup() {

		readFile = new ReadFile();
		// Obtains the folder of /src/test/resources
		iStream = this.getClass().getClassLoader()
				.getResourceAsStream("testCmds.txt");
		if (iStream == null) {
			throw new IllegalArgumentException("Invalid input file ");
		}

	}

	@Test
	public void testInputFileReading() {

		List<String> lines = readFile.readToyRobotCommands(iStream);
		assertEquals("PLACE 1,2,NORTH", lines.get(0));
		assertEquals("MOVE", lines.get(1));
		assertEquals("RIGHT", lines.get(2));
		assertEquals("LEFT", lines.get(3));
		assertEquals("REPORT", lines.get(4));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInputFileNull() {
		readFile.readToyRobotCommands(null);

	}

}
