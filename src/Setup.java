/*****************************************
 *                                  
 * @author Connor Thompson-Hebert
 * 
 * Sets up a basic 4 function calculator 
 * GUI and functionality, created and 
 * displayed as a JFrame, with the
 * help of private classes for the
 * functions
 * 
 * 
 *****************************************/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Setup extends JFrame{
	JTextField text = new JTextField("0.0");
	JPanel panel = new JPanel();
	JButton[] numbers = new JButton[10];
	NumAction[] numActions = new NumAction[10];
	
	JButton mult = new JButton("x");
	JButton div = new JButton("/");
	JButton dec = new JButton(".");
	JButton equals = new JButton("=");
	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton clr = new JButton("C");
	JButton del = new JButton("Del");
	
	Operator op = new Operator();
	double operand1 = 0;
	double operand2 = 0;
	int operator = -1;
	
	public Setup(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 600);
		setTitle("Calculator");
		setResizable(false);
		panel.setLayout(null);
	
		//initialize number buttons with text and actions
		for(int i=0; i<10; i++){
			numbers[i] = new JButton((Integer.toString(i)));
			numbers[i].setFont(new Font("Arial", Font.BOLD, 40));
			numActions[i] = new NumAction(numbers[i]);
			numbers[i].addActionListener(numActions[i]);
			panel.add(numbers[i]);
		}
		
		//add everything to the panel
		panel.add(dec);
		panel.add(div);
		panel.add(equals);
		panel.add(sub);
		panel.add(mult);
		panel.add(add);
		panel.add(text);
		panel.add(clr);
		panel.add(del);
				
		//manually position elements within panel
		numbers[7].setBounds(15, 100, 75, 100);
		numbers[8].setBounds(100, 100, 75, 100);
		numbers[9].setBounds(185, 100, 75, 100);
		numbers[4].setBounds(15, 215, 75, 100);
		numbers[5].setBounds(100, 215, 75, 100);
		numbers[6].setBounds(185, 215, 75, 100);
		numbers[1].setBounds(15, 330, 75, 100);
		numbers[2].setBounds(100, 330, 75, 100);
		numbers[3].setBounds(185, 330, 75, 100);
		numbers[0].setBounds(15, 445, 75, 100);
		add.setBounds(270, 330, 75, 100);
		sub.setBounds(355, 330, 75, 100);
		mult.setBounds(270, 445, 75, 100);
		div.setBounds(355, 445, 75, 100);
		dec.setBounds(100, 445, 75, 100);
		clr.setBounds(270, 215, 75, 100);
		del.setBounds(355, 215, 75, 100);
		equals.setBounds(185, 445, 75, 100);
		text.setBounds(20, 20, 400, 60);
		
		//set all fonts
		mult.setFont(new Font("Arial", Font.BOLD, 40));
		div.setFont(new Font("Arial", Font.BOLD, 40));
		add.setFont(new Font("Arial", Font.BOLD, 40));
		sub.setFont(new Font("Arial", Font.BOLD, 40));
		equals.setFont(new Font("Arial", Font.BOLD, 40));
		dec.setFont(new Font("Arial", Font.BOLD, 40));
		clr.setFont(new Font("Arial", Font.BOLD, 40));
		del.setFont(new Font("Arial", Font.BOLD, 24));
		text.setFont(new Font("Arial", Font.BOLD, 24));
		
		//set button colors
		equals.setBackground(new Color(0, 210, 0));
		mult.setBackground(new Color(0, 194, 252));
		div.setBackground(new Color(0, 194, 252));
		add.setBackground(new Color(0, 194, 252));
		sub.setBackground(new Color(0, 194, 252));
		clr.setBackground(new Color(254, 123, 0));
		del.setBackground(new Color(244, 37, 0));
		
		//add function actions
		ClearAction cAction = new ClearAction();
		clr.addActionListener(cAction);
		AddAction aAction = new AddAction();
		add.addActionListener(aAction);
		SubAction sAction = new SubAction();
		sub.addActionListener(sAction);
		MultAction mAction = new MultAction();
		mult.addActionListener(mAction);
		DivAction dAction = new DivAction();
		div.addActionListener(dAction);
		EqualsAction eAction = new EqualsAction();
		equals.addActionListener(eAction);
		DecAction decAction = new DecAction();
		dec.addActionListener(decAction);
		DelAction delAction = new DelAction();
		del.addActionListener(delAction);
		
		//add panel to frame
		add(panel);
		setVisible(true);
	}
	
	 private class NumAction implements ActionListener{
		 private String num;
		 
		 public NumAction(JButton button) {
		        this.num = button.getText();
		    }
		@Override
		public void actionPerformed(ActionEvent e) {
			if (text.getText().equals("") || Double.parseDouble(text.getText())!=0.0) {
				text.setText(text.getText() + num);
			} 
			else{
				text.setText("");
				actionPerformed(e);
			}	
		}
		
	}
	 
	private class EqualsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			operand2 = Double.parseDouble(text.getText());
			double result = op.result(operand1, operand2, operator);
			text.setText(Double.toString(result));
			operand1 = 0;
			operand2 = 0;
			operator = -1;
		}
		
	}
	 
	private class ClearAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			text.setText("0.0");
			operator = -1;
			operand1 = 0;
			operand2 = 0;
		}
	}
	 
	private class AddAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			operator = 1;
			operand1 = Double.parseDouble(text.getText());
			text.setText("");
		} 
	}
	 
	private class SubAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			operator = 2;
			operand1 = Double.parseDouble(text.getText());
			text.setText("");
		} 
	}
	 
	private class MultAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			operator = 3;
			operand1 = Double.parseDouble(text.getText());
			text.setText("");
		} 
	}
	 
	private class DivAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			operator = 4;
			operand1 = Double.parseDouble(text.getText());
			text.setText("");
		} 
	}
	
	private class DecAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			text.setText(text.getText() + '.');	
		}
		
	}
	
	private class DelAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = text.getText();
			s = s.substring(0, s.length()-1);
			text.setText(s);
		}
		
	}
}
