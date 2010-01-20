package oving1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ButtonsNText extends JPanel {
	private JTextField TextLine = new JTextField();
	private boolean continious = false; 
	private boolean uppercase = false;
	private JCheckBox ContinuousButton = new JCheckBox("Continious?");

	
	public ButtonsNText() {
		
		TextLine.setColumns(30);
		TextLine.setBackground(Color.white);
		TextLine.addKeyListener(new converter());
		
		JToggleButton UpperCaseButton = new JToggleButton("Uppercase");
		JToggleButton LowerCaseButton = new JToggleButton("Lowercase");
		
		UpperCaseButton.addActionListener(new toUpperCase());
		LowerCaseButton.addActionListener(new toLowerCase());
		ContinuousButton.addActionListener(new checked());
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(UpperCaseButton);
		buttonGroup.add(LowerCaseButton);
		
		
		
		
		add(UpperCaseButton);
		add(LowerCaseButton);
		add(TextLine);
		add(ContinuousButton);
	}

	private void toUpperCase() {
		TextLine.setText(TextLine.getText().toUpperCase());
		uppercase = true;
		
	}
	
	private void toLowerCase(){
		TextLine.setText(TextLine.getText().toLowerCase());
		uppercase = false;
	}
	
	public class toUpperCase implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			toUpperCase();
			
			
		}
	}
	
	public class toLowerCase implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			toLowerCase();
			
		}
		
	}
	
	public class checked implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ContinuousButton.isSelected()) {
				continious = true;
			
			}
			else {
				continious = false;
				
			}
			
		}
		
	}
	
	public class converter implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			if (continious || e.getKeyCode() == 10) {
				if (uppercase) {
					TextLine.setText(TextLine.getText().toUpperCase());
				}
				else {
					TextLine.setText(TextLine.getText().toLowerCase());
				}
			}
			
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
			
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ButtonsNText());
		
		frame.setBackground(Color.gray);
		frame.setSize(new Dimension(400,150));
		frame.setVisible(true);
		
		
		
		
		
	}
	
	
}
