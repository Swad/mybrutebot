package oving3;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;

import oving2.PersonPanel.dropboxListener;


public class PersonPanel extends JPanel implements PropertyChangeListener{
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
		model.addPropertyChangeListener(this);
		
		
	}
	public Person getModel() {
		NamePropertyComponent.setText(model.getName());
		EmailPropertyComponent.setText(model.getEmail());
		DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
		HeightPropertyComponent.setValue(model.getHeight());
		return model;
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
	
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if (propertyName == Person.NAME_PROPERTY) {
			NamePropertyComponent.setText(model.getName());
		}
		else if (propertyName == Person.EMAIL_PROPERTY) {
			EmailPropertyComponent.setText(model.getEmail());
		}
		else if(propertyName == Person.GENDER_PROPERTY) {
			GenderPropertyComponent.setSelectedItem(model.getGender());
		}
		else if (propertyName == Person.HEIGHT_PROPERTY) {
			HeightPropertyComponent.setValue(model.getHeight()); 
		}
		else if (propertyName == Person.DATEOFBIRTH_PROPERTY) {
			DateOfBirthPropertyComponent.setText(model.getName());
		}
	}
	
	public class dropboxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setModel(model);
			
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
