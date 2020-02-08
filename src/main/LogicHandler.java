package main;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

import main.gui.MainGUI;

public class LogicHandler {

	private MainGUI gui;
	
	private DecimalFormat df = new DecimalFormat("##.######");
	
	private String c_display = "";
	private ArrayList<Object> exp_list = new ArrayList <>();
	
	private boolean comp_latest = false;
	
	public void setMainGUI (MainGUI gui) {
		
		this.gui = gui;
		
	}
	
	public void newCommand (String cmd) {
		
		if (cmd == "=") {
			computeResult();
		} 
		else if (cmd == "C") {
			resetDisplay();
		}
		else {
			updateDisplayString(cmd);
		}
		
		
	}
	
	private void computeResult () {
		
		String r = "-?\\d+.?\\d*(\\s[\\+/\\*-]\\s\\d+)*";
		
		if (!c_display.matches(r)) {
			logicError();
			return;
		}
		
		System.out.println("passed regex");
	
		shrinkExpList ();
		
		comp_latest = true;
		
		String result = df.format(exp_list.get(0));
		
		gui.setDisplayString(result);
		
		c_display = result;
		
	}
	
	private void shrinkExpList () {
		
		if (exp_list.size() == 1) {
			return;
		}
		
		else {
			
			int i;
			double op1, op2;
			
			if (exp_list.contains("/")) {
				i = exp_list.indexOf("/");
				op1 = (double) exp_list.get(i-1);
				op2 = (double) exp_list.get(i+1);
				exp_list.set(i, op1 / op2);
				
				exp_list.remove(i+1);
				exp_list.remove(i-1);
			}
			else if (exp_list.contains("*")) {
				i = exp_list.indexOf("*");
				op1 = (double) exp_list.get(i-1);
				op2 = (double) exp_list.get(i+1);
				exp_list.set(i, op1 * op2);
				
				exp_list.remove(i+1);
				exp_list.remove(i-1);
			}
			else if (exp_list.contains("+")) {
				i = exp_list.indexOf("+");
				op1 = (double) exp_list.get(i-1);
				op2 = (double) exp_list.get(i+1);
				exp_list.set(i, op1 + op2);
				
				exp_list.remove(i+1);
				exp_list.remove(i-1);
			}
			else {
				i = exp_list.indexOf("-");
				System.out.println(exp_list);
				op1 = (double) exp_list.get(i-1);
				op2 = (double) exp_list.get(i+1);
				exp_list.set(i, op1 - op2);
				
				exp_list.remove(i+1);
				exp_list.remove(i-1);
			}
		
			//System.out.println(exp_list);
			
			shrinkExpList();
			
		}
		
	}
	
	private void logicError() {
		c_display = "";
		exp_list.clear();
		gui.setDisplayString("ERROR");
		comp_latest = false;
		return;
	}
	
	private void resetDisplay () {
		c_display = "";
		exp_list.clear();
		gui.setDisplayString(c_display);
		comp_latest = false;
		return;
		
	}
	
	private void updateDisplayString (String text) {
		
		List<String> operators = Arrays.asList("+","-","/","*");
		
		if (operators.contains(text)) {
			c_display = c_display + " " + text + " ";
			exp_list.add(text);
			
			comp_latest = false;
			
		}
		
		else {
			
			if (comp_latest) {
				logicError();
				return;
			}
			
			c_display = c_display + text;
			
			if (exp_list.size() != 0 && !operators.contains(exp_list.get(exp_list.size()-1))) {
				exp_list.set(exp_list.size()-1, Double.parseDouble(Long.toString(Math.round((double)exp_list.get(exp_list.size()-1))) + text));
			}
			else {
				exp_list.add(Double.parseDouble(text));
			}
		} 
		
		gui.setDisplayString(c_display);
		
	}
	
	
}
