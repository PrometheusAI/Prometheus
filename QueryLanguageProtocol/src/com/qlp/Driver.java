package com.qlp;

import java.io.File;
import java.util.Scanner;

import com.qlp.functions.Function;
import com.qlp.handlers.MathHandler;

public class Driver {

	public static void main(String[] args) throws Exception {
		File functions = new File(System.getProperty("user.dir") + "\\functions.txt");
		Scanner reader = new Scanner(functions);
		String line;
		while (reader.hasNext()) {
			line = reader.nextLine();
//			System.out.println("Function registered: " + line);
			Function.registerFunction(Class.forName(line));
		}

		reader.close();

		String function = "pow(144,0.5)";

		System.out.println(MathHandler.computeIndividualFunction(function));

	}

}