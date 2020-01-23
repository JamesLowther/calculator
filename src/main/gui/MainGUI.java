package main.gui;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import main.gui.JButtonActionHandler;

public class MainGUI {
	
	private String window_title = "Calculator";
	private Dimension frame_dim;
	private JButtonActionHandler action_handler;
	
	public MainGUI () {
		
		frame_dim = new Dimension(300, 500);
		action_handler = new JButtonActionHandler();
		
		// initialize frame
		JFrame frame = new JFrame(window_title);
		frame.setSize(frame_dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		
		// numbers element
		JPanel n_panel = new JPanel();
		n_panel.setLayout(new GridBagLayout());
		
		// create number buttons
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		n_panel.add(new JButton("9"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		n_panel.add(new JButton("8"), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		n_panel.add(new JButton("7"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		n_panel.add(new JButton("4"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		n_panel.add(new JButton("5"), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		n_panel.add(new JButton("6"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		n_panel.add(new JButton("1"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		n_panel.add(new JButton("2"), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		n_panel.add(new JButton("3"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		n_panel.add(new JButton("0"), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		n_panel.add(new JButton("/"), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		n_panel.add(new JButton("*"), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		n_panel.add(new JButton("-"), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		n_panel.add(new JButton("+"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		n_panel.add(new JButton("enter"), gbc);
		
		
		// create layout elements
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		// display element
		JPanel display_panel = new JPanel();
		display_panel.setLayout(new BorderLayout());
		
		JLabel display = new JLabel("Hello world");
		display.setBorder(border);
		display.setPreferredSize(new Dimension(300, 100));
		
		display_panel.add(display);
		
		
		// add panels
		
		gbc.gridwidth = 1;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.getContentPane().add(display_panel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 4;
		frame.getContentPane().add(n_panel, gbc);
		
		// view frame
		frame.setVisible(true);

	}
	
}
