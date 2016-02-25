package com.tylersenter.prometheus.launcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.qlp.functions.Function;
import com.tylersenter.prometheus.launcher.Console.Priority;

public class Initiator {

	public static void registerFunctions() {
		File functionFile = new File(System.getProperty("user.dir") + File.separator + "functions.txt");
		Scanner reader;
		
		LauncherMain.writeToConsole("Registering functions...");
		
		try {
			reader = new Scanner(functionFile);
		} catch (FileNotFoundException e) {
			LauncherMain.writeToConsole("Predefined function file not found!", Priority.HIGH);
			LauncherMain.writeToConsole(e, Priority.MEDIUM);
			return;
		}
		String line;
		while (reader.hasNext()) {
			line = reader.nextLine();
			LauncherMain.writeToConsole("Function registered: " + line);
			try {
				Function.registerFunction(Class.forName(line));
			} catch (ClassNotFoundException e) {
				LauncherMain.writeToConsole("Function class not found: " + line, Priority.MEDIUM);
			}
		}

		reader.close();
	}
	
	

}