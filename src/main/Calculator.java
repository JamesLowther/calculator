package main;

import main.gui.MainGUI;
import main.logicHandler;

public class Calculator {

	public static void main (String[] args) {
		
		// create GUI object
		
		logicHandler lh = new logicHandler();
		
		MainGUI gui = new MainGUI(lh);
		
		lh.setMainGUI(gui);
		
		
		
		
	}
	
}
