package oving2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PersonPanel extends JPanel {
	private JTextField NamePropertyComponent;
	private JTextField EmailPropertyComponent;
	private JTextField DateOfBirthPropertyComponent; 
	private JSlider HeightPropertyComponent;
	private JComboBox GenderPropertyComponent;
	
	private Person model;
	
	public PersonPanel() {
		NamePropertyComponent = new JTextField(); 
		EmailPropertyComponent = new JTextField();
		DateOfBirthPropertyComponent = new JTextField(); 
		HeightPropertyComponent = new JSlider(0, 250, 1);
		HeightPropertyComponent.setMajorTickSpacing(50);
		HeightPropertyComponent.setMinorTickSpacing(10);
		HeightPropertyComponent.setPaintTicks(true);
		HeightPropertyComponent.setPaintLabels(true);
		HeightPropertyComponent.setValue(150);
		GenderPropertyComponent = new JComboBox(new Person().toStringArray());
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel emailLabel = new JLabel("Email:");
		JLabel bornLabel = new JLabel("Born");
		JLabel heightLabel = new JLabel("Height:");
		
		NamePropertyComponent.setColumns(20);
		EmailPropertyComponent.setColumns(20);
		DateOfBirthPropertyComponent.setColumns(20);
		
		NamePropertyComponent.addKeyListener(new textInputListener());
		EmailPropertyComponent.addKeyListener(new textInputListener());
		DateOfBirthPropertyComponent.addKeyListener(new textInputListener());
		GenderPropertyComponent.addActionListener(new dropboxListener());
		HeightPropertyComponent.addMouseListener(new SliderListener());
		
		
		add(nameLabel);
		add(NamePropertyComponent);
		add(emailLabel);
		add(EmailPropertyComponent);
		add(bornLabel);
		add(DateOfBirthPropertyComponent);
		add(heightLabel);
		add(HeightPropertyComponent);
		add(new JLabel("Gender:"));
		add(GenderPropertyComponent);

//		add(nameLabel);
//		nameLabel.add(name);
//		add(emailLabel);
//		emailLabel.add(email);
//		add(bornLabel);
//		bornLabel.add(dateOfBirth);
//		add(heightLabel);
//		heightLabel.add(height);
//		
		
	}
	public void setModel(Person model) {
		model.setName(NamePropertyComponent.getText());
		model.setEmail(EmailPropertyComponent.getText());
		model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
		model.setHeight(HeightPropertyComponent.getValue());
		this.model = model;
		
		
	}
	public Person getModel() {
//		name.setText(model.getName());
//		email.setText(model.getEmail());
//		dateOfBirth.setText(model.getDateOfBirth());
//		height.setValue(model.getHeight());
		return model;
	}
	public class dropboxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setModel(model);
			
		}
		
	}
	public class textInputListener implements KeyListener {
		
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// model.setName(name.getText());
			setModel(model);
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
//			getModel();
			
		}
	
	}
	public class SliderListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			setModel(model);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		PersonPanel panel = new PersonPanel();
		frame.setContentPane(panel);
		frame.setSize(new Dimension(300,200));
		frame.setVisible(true);
		Person model = new Person();
		panel.setModel(model);
		
	}



	
}
