package com.tylersenter.prometheus.launcher;

import com.tylersenter.prometheus.launcher.Console.Priority;
import com.tylersenter.prometheus.launcher.objects.ObjectWrapper;

import javafx.application.Application;
import javafx.stage.Stage;

public class LauncherMain extends Application {

	private static final ObjectWrapper<Console> console = new ObjectWrapper<>();

	public void start(Stage stage) {
		console.setObject(new Console());
		console.getObject().show(true);
	}

	public static void writeToConsole(String message) {
		console.getObject().write(message);
	}

	public static void writeToConsole(String message, Priority priority) {
		console.getObject().write(message, priority);
	}

	public static void writeToConsole(Exception exception, Priority priority) {
		console.getObject().write(exception, priority);
	}

	public static void main(String[] args) {
		launch(args);
	}

}