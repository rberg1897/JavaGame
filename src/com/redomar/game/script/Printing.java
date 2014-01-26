package com.redomar.game.script;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.redomar.game.lib.Time;
import com.redomar.game.script.PrintTypes;

public class Printing {

	private PrintTypes type;
	private Time time = new Time();
	private String message;
	private String outputText;
	private File log = new File("Log.txt");

	public static PrintWriter outputFile;
	
	public Printing() {
		
	}

	public void print(String message, PrintTypes type) {
		this.type = type;
		setMessage(message);
		printOut();		
	}
	
	private void printOut(){
		String msgTime = "[" + time.getTime() + "]";
		String msgType = "[" + type.toString() + "]";
		outputText = msgType + msgTime + getMessage();
		log();
		outputFile.println(outputText);
		outputFile.write("\r\n");
		outputFile.close();
		System.out.println(outputText);
	}
	
	private void log(){
		try {
			outputFile = new PrintWriter(log);
		} catch (FileNotFoundException e) {
			System.err.println("Failed to save log"+e.toString());
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
