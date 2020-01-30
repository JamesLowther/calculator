package main;

import main.gui.MainGUI;
import main.LogicHandler;

public class Calculator {

	public static void main (String[] args) {
		
		// create GUI object
		
		LogicHandler lh = new LogicHandler();
		
		MainGUI gui = new MainGUI(lh);
		
		lh.setMainGUI(gui);
		
		
		
		
	}
	
}
