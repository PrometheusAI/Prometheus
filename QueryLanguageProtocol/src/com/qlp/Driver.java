package com.qlp;

import java.io.File;
import java.text.NumberFormat;
import java.util.Scanner;

import com.qlp.functions.Function;
import com.qlp.handlers.MathHandler;

public class Driver {

	/**
	 * 		Question -> Interpreter 						   -> Query
	 * 					 + Determines the handler the be used      + Sends the query to the associated handler 
	 * 
	 * 		
	 * 		Question: 		"What is six cubed divided by 4?"		
	 * 		Interpreter: 	"math:six cubed divided by 4"
	 * 		MathHandler:    Six cubed divided by 4 is 54.
	 * 
	 * 
	 * 		
	 * 		
	 * 
	 **/
	
	public static void main(String[] args) throws Exception {
		File functionFile = new File(System.getProperty("user.dir") + File.separator + "functions.txt");
		Scanner reader = new Scanner(functionFile);
		String line;
		while (reader.hasNext()) {
			line = reader.nextLine();
			// System.out.println("Function registered: " + line);
			Function.registerFunction(Class.forName(line));
		}

		reader.close();

		String[] functions = new String[] { "add(2,2)" };

		for (String str : functions)
			System.out.println(NumberFormat.getNumberInstance().format(MathHandler.computeAllFunctions(str)));

	}

}