package main.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.LogicHandler;

public class JButtonActionHandler implements ActionListener {
	
	private LogicHandler lh;
	
	public JButtonActionHandler (LogicHandler lh) {
		
		this.lh = lh;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(e.getActionCommand());
		lh.newCommand(e.getActionCommand());
	}
	
	
}
