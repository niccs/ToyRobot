package com.anz.toyrobot.controller.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The file handles the reading of input file or stream.
 * 
 * @author Neetika
 * 
 */
public class ReadFile {

	/**
	 * Processes the input stream to List of String objects.
	 * 
	 * @param iStream
	 *            the inputStream to be processed.
	 * @return List of commands as String objects
	 */
	public List<String> readToyRobotCommands(InputStream iStream) {
		final List<String> lines = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(iStream);
			while (sc.hasNextLine()) {
				final String line = sc.nextLine();
					if(line!=null && !("".equals(line.trim()))&&(line.startsWith("PLACE"))){
						lines.add(line);
					}
			}
			sc.close();
		} catch (Exception ex) {
			throw new IllegalArgumentException(
					"Error in processing input file read.");
		} finally {
			if (sc != null)
				sc.close();
		}
		return lines;
	}
}