package com.tylersenter.prometheus.launcher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Console {

	private static Console CURRENT;

	private Stage stage;
	private SimpleDateFormat dateFormat;

	private LinkedList<String> cmdHist;
	private int histIndex = 0;

	private boolean timestamps = false;

	public Console() {
		this.stage = new Stage();
		if (CURRENT != null) {
			CURRENT.stage.close();
		}
		CURRENT = this;

		cmdHist = new LinkedList<String>();

		ScrollPane scrollPane = new ScrollPane();
		VBox pane = new VBox();
		VBox box = new VBox();
		Scene scene = new Scene(pane, 500, 300);
		final TextField commandField = new TextField();

		scrollPane.setStyle("-fx-background-color: black;");
		box.setStyle("-fx-background-color: black;");
		box.setAlignment(Pos.BOTTOM_LEFT);

		scrollPane.setContent(box);

		VBox.setVgrow(scrollPane, javafx.scene.layout.Priority.ALWAYS);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);

		commandField.setOnKeyReleased(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ENTER) {
					if (commandField.getText() != null && !commandField.getText().isEmpty())
						Console.getConsole().handle(createCmd(commandField.getText()),
								createArgs(commandField.getText()), commandField.getText());
					cmdHist.add(commandField.getText());
					commandField.setText("");
					histIndex = 0;
				} else if (ke.getCode() == KeyCode.UP) {
					if (cmdHist.size() > (histIndex + 1)) {
						if (histIndex == 0)
							cmdHist.add(commandField.getText());
						commandField.setText(cmdHist.get(cmdHist.size() - (histIndex + 2)));
						commandField.positionCaret(commandField.getText().length());
						histIndex += 1;
						// System.out.println(cmdHist);
						// System.out.println("size=" + cmdHist.size());
						// System.out.println("index=" + histIndex);
						// System.out.println();
					}
				} else if (ke.getCode() == KeyCode.DOWN) {
					if (histIndex != 0) {
						commandField.setText(cmdHist.get(cmdHist.size() - histIndex));
						commandField.positionCaret(commandField.getText().length());
						histIndex -= 1;
						// System.out.println(cmdHist);
						// System.out.println("size=" + cmdHist.size());
						// System.out.println("index=" + histIndex);
						// System.out.println();
					}
				} else if (ke.getCode() == KeyCode.ENTER) {
					commandField.setText("");
				}
			}

			private String createCmd(String s) {
				return s.split(" ")[0];
			}

			private List<String> createArgs(String s) {
				List<String> args = new ArrayList<String>();

				for (int i = 0; i < s.split(" ").length - 1; i++)
					args.add(s.split(" ")[i + 1]);

				return args;
			}

		});
		commandField.focusedProperty().addListener(new ChangeListener<Boolean>() {

			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue)
					commandField.requestFocus();
			}
		});
		scene.widthProperty().addListener(new ChangeListener<Number>() {

			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				for (Node n : ((VBox) ((ScrollPane) ((VBox) stage.getScene().getRoot()).getChildren().get(0))
						.getContent()).getChildren()) {
					n.prefHeight(newValue.doubleValue());
				}
			}
		});
		scene.heightProperty().addListener(new ChangeListener<Number>() {

			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				for (Node n : ((VBox) ((ScrollPane) ((VBox) stage.getScene().getRoot()).getChildren().get(0))
						.getContent()).getChildren()) {
					n.prefWidth(newValue.doubleValue());

				}
			}
		});
		commandField.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		commandField.setStyle("-fx-text-fill: white;");

		pane.getChildren().addAll(scrollPane, commandField);

		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);

		stage.setScene(scene);
		stage.setTitle("Prometheus");

		dateFormat = new SimpleDateFormat("[HH:mm:ss] ");
		commandField.requestFocus();
	}

	public void write(String message) {
		if (timestamps)
			message = dateFormat.format(Calendar.getInstance().getTime()) + message;
		((VBox) ((ScrollPane) ((VBox) stage.getScene().getRoot()).getChildren().get(0)).getContent()).getChildren()
				.add(textBuilder(message));
	}

	public void write(String message, Priority priority) {
		write(message, priority.color);
	}

	private void write(String message, Color fontColor) {
		if (timestamps)
			message = dateFormat.format(Calendar.getInstance().getTime()) + message;
		((VBox) ((ScrollPane) ((VBox) stage.getScene().getRoot()).getChildren().get(0)).getContent()).getChildren()
				.add(textBuilder(message, null, null, 0, fontColor));
	}

	public void write(Exception exception, Priority priority) {
		write("--- Beginning of Exception ---", Priority.HIGH);
		write(exception.toString(), priority);
		StackTraceElement[] arrayOfStackTraceElement = exception.getStackTrace();
		Object localObject2;
		for (StackTraceElement ste : arrayOfStackTraceElement)
			write("\t at " + ste, priority);
		localObject2 = exception.getCause();
		if (localObject2 != null)
			write("Caused by: " + localObject2, priority);
		write("--- End of Exception ---", Priority.HIGH);
	}

	private void handle(String command, List<String> args, String wholeCmd) {
		// TODO Handle commands
		if (command.equalsIgnoreCase("clear")) {
			if (!args.contains("-c")) {
				write("Cleared the console of " + clear() + " items", Priority.LOW);
				return;
			} else if (args.contains("-c")) {
				clear();
				return;
			}
		} else if (command.equalsIgnoreCase("testex")) {
			write(new NullPointerException(), Priority.HIGH);
			return;
		} else if (command.equalsIgnoreCase("launch")) {
			write("Initiating Prometheus...", Priority.NORMAL);
			Initiator.registerFunctions();
			return;
		} else if (command.equalsIgnoreCase("timestamps")) {
			if (args.size() == 1) {
				String message = "";
				switch (args.get(0).toLowerCase()) {
				case "on":
					timestamps = true;
					message = "Timestamps have been enabled.";
					break;
				case "off":
					timestamps = false;
					message = "Timestamps have been disabled.";
					break;
				}
				write(message);
				return;
			}
		} else if (command.equalsIgnoreCase("help")) {
			constructMenu();
			return;
		}
		write(wholeCmd, Priority.LOW);
		write("Invalid command! Please check your spelling before continuing!", Priority.HIGH);
	}

	private HBox textBuilder(String text) {
		return textBuilder(text, null, null, 0, null);
	}

	@SuppressWarnings("deprecation")
	private HBox textBuilder(String text, FontWeight fontWeight, FontPosture fontPosture, double fontSize,
			Color fontColor) {
		HBox box = javafx.scene.layout.HBoxBuilder.create().children(

				javafx.scene.text.TextBuilder.create().text(text)
						.font(Font.font("Consolas", (fontWeight == null ? FontWeight.NORMAL : fontWeight),
								(fontPosture == null ? FontPosture.REGULAR : fontPosture),
								(fontSize <= 0 ? 13 : fontSize)))
						.wrappingWidth(((VBox) stage.getScene().getRoot()).getWidth() - 2)
						.fill((fontColor == null ? Color.WHITE : fontColor)).build())
				.build();
		((Text) box.getChildren().get(0)).wrappingWidthProperty()
				.bind(((Pane) stage.getScene().getRoot()).widthProperty().asObject());
		return box;
	}

	public void show(boolean show) {
		if (show)
			stage.show();
		else
			stage.hide();
	}

	public int clear() {
		int items = ((VBox) ((ScrollPane) ((VBox) stage.getScene().getRoot()).getChildren().get(0)).getContent())
				.getChildren().size();
		((VBox) ((ScrollPane) ((VBox) stage.getScene().getRoot()).getChildren().get(0)).getContent()).getChildren()
				.clear();
		return items;
	}

	public void close() {
		stage.close();
	}
	
	public void constructMenu() {
		
	}

	public static Console getConsole() {
		return CURRENT;
	}

	public static enum Priority {
		/**
		 * A message of no great importance
		 */
		LOW(Color.LIGHTGRAY),
		/**
		 * A message of standard importance, or something not necessary to be
		 * noticed
		 */
		NORMAL(Color.WHITE),
		/**
		 * A message of standard importance, but may need developer attention
		 */
		MILD(Color.YELLOW),
		/**
		 * A message needing attention, as something may have broken
		 */
		MEDIUM(Color.ORANGE),
		/**
		 * A message of great importance, something broke, an exception was
		 * thrown, ect.
		 */
		HIGH(Color.RED);

		private Color color;

		private Priority(Color color) {
			this.color = color;
		}

	}

}