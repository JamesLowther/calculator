package main.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.logicHandler;

public class JButtonActionHandler implements ActionListener {
	
	private logicHandler lh;
	
	public JButtonActionHandler (logicHandler lh) {
		
		this.lh = lh;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(e.getActionCommand());
		lh.newCommand(e.getActionCommand());
	}
	
	
}
