package main.gui;

import javax.swing.*;
import main.logicHandler;
import javax.swing.border.Border;

import java.awt.*;

import main.gui.JButtonActionHandler;

public class MainGUI {
	
	private String window_title = "Calculator";
	
	private Dimension frame_dim = new Dimension(320, 500);
	
	private JFrame frame = new JFrame(window_title);
	private JPanel d_panel = new JPanel();
	private JPanel n_panel = new JPanel();
	
	private JLabel display = new JLabel();
	
	private JButtonActionHandler a_handler;
	
	private logicHandler lh;
	
	public MainGUI (logicHandler lh) {
		
		this.lh = lh;
		
		a_handler = new JButtonActionHandler(this.lh);
		
		// set frame attributes
		frame.setSize(frame_dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		
		// create button/display panels
		createDPanel();
		createNPanel();
		
		// create GridBagConstraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		// add panels to frame
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.getContentPane().add(d_panel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 4;
		frame.getContentPane().add(n_panel, gbc);
		
		// view frame
		frame.setVisible(true);

	}

	public void setDisplayString (String text) {
		
		display.setText(text);
		
	}
	
	public JButtonActionHandler getActionHandler () {
		return a_handler;
	}

	
	private void createDPanel() {
		
		// create layout elements
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		// display element
		d_panel.setLayout(new BorderLayout());
		
		// create display panel
		display.setFont(new Font("Verdana", Font.BOLD, 28));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setBorder(border);
		display.setPreferredSize(new Dimension(300, 100));
		
		d_panel.add(display);
		
	}
	
	private void createNPanel() {
		
		// create GridBagConstraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		// set panel layouts
		n_panel.setLayout(new GridBagLayout());
		
		// create number buttons
		
		
		JButton n_button;
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		n_button = new JButton("9");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		n_button = new JButton("8");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		n_button = new JButton("7");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		n_button = new JButton("4");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		n_button = new JButton("5");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		n_button = new JButton("6");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		n_button = new JButton("1");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		n_button = new JButton("2");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		n_button = new JButton("3");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		n_button = new JButton("0");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		n_button = new JButton("/");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		n_button = new JButton("*");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		n_button = new JButton("-");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		n_button = new JButton("+");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		n_button = new JButton("=");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		n_button = new JButton("C");
		n_button.addActionListener(a_handler);
		n_panel.add(n_button, gbc);
	}
	
	
	
}
