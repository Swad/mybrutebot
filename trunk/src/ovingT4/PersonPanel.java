package ovingT4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PersonPanel extends JPanel implements PropertyChangeListener {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField NamePropertyComponent, EmailPropertyComponent, DateOfBirthPropertyComponent;
	private JComboBox GenderPropertyComponent;
	private JSlider HeightPropertyComponent;
	private Person model;
	
	public PersonPanel(){
				
		JLabel name = new JLabel("Name:");
		
		NamePropertyComponent = new JTextField();
		NamePropertyComponent.setColumns(25);
		NamePropertyComponent.setName("NamePropertyComponent");
		NamePropertyComponent.addKeyListener(new TextLineListener());

		JLabel email = new JLabel("Email:");

		EmailPropertyComponent = new JTextField();
		EmailPropertyComponent.setColumns(25);
		EmailPropertyComponent.setName("EmailPropertyComponent");
		EmailPropertyComponent.addKeyListener(new TextLineListener());

		JLabel birthday = new JLabel("Birthday:");

		DateOfBirthPropertyComponent = new JTextField();
		DateOfBirthPropertyComponent.setColumns(25);
		DateOfBirthPropertyComponent.setName("DateOfBirthPropertyComponent");
		DateOfBirthPropertyComponent.addKeyListener(new TextLineListener());
		
		JLabel gender = new JLabel("Gender:");

		//GenderPropertyComponent = new JComboBox(new Person().toStringArray());
		GenderPropertyComponent = new JComboBox(Gender.values());
		GenderPropertyComponent.setPreferredSize(new Dimension(266, 23));
		GenderPropertyComponent.setName("GenderPropertyComponent");
		GenderPropertyComponent.addActionListener(new DropboxListener());
		
		JLabel height = new JLabel("Height:");
		height.setPreferredSize(new Dimension(39, 16));
		
		HeightPropertyComponent = new JSlider(150, 200, 175);
		HeightPropertyComponent.setMajorTickSpacing(10);
		HeightPropertyComponent.setMinorTickSpacing(1);
		HeightPropertyComponent.setPaintTicks(true);
		HeightPropertyComponent.setPaintLabels(true);
		HeightPropertyComponent.setSnapToTicks(true);
		HeightPropertyComponent.setPreferredSize(new Dimension(272, 43));
		HeightPropertyComponent.setMinimum(120);
		HeightPropertyComponent.setName("HeightPropertyComponent");
		HeightPropertyComponent.addChangeListener(new SliderListener());
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(300,300);
		add(name);
		
		add(NamePropertyComponent);
		add(email);
		add(EmailPropertyComponent);
		add(birthday);
		add(DateOfBirthPropertyComponent);
		add(gender);
		add(GenderPropertyComponent);
		add(height);
		add(HeightPropertyComponent);
		
	}
	
	public Gender getGender(){
		if(GenderPropertyComponent.getSelectedItem() == Gender.male) return Gender.male;
		else return Gender.female;
	}
	
	public void setModel(Person model){
		model.setName(NamePropertyComponent.getText());
		model.setEmail(EmailPropertyComponent.getText());
		model.setHeight(HeightPropertyComponent.getValue());
		model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
//		model.setGender(getGender());
		this.model = model;
//		model.addPropertyChangeListener(this);

	}
	
	public Person getModel(){
		NamePropertyComponent.setText(model.getName());
		EmailPropertyComponent.setText(model.getEmail());
		DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
		HeightPropertyComponent.setValue(model.getHeight());
		if(model.getGender() == Gender.male) GenderPropertyComponent.setSelectedItem(Gender.male);
		else GenderPropertyComponent.setSelectedItem(Gender.female);
		
		return model;
	}

	public void setPersonAsModel(Person person) {
		model = person;
//		model.addPropertyChangeListener(this);
	}
	
	public class TextLineListener implements KeyListener{

		public void keyPressed(KeyEvent arg0) {
		}

		public void keyReleased(KeyEvent arg0) {
			setModel(model);
		}

		public void keyTyped(KeyEvent arg0) {
		}
		
	}
	
	public class DropboxListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			model.setGender(getGender());
		}
		
	}
	
	public class SliderListener implements ChangeListener{

		public void stateChanged(ChangeEvent e) {
			model.setHeight(HeightPropertyComponent.getValue());
		}
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Personalia");
		PersonPanel panel = new PersonPanel();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(300,300);
		Person model = new Person();
		panel.setModel(model);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if(propertyName == Person.NAME){
			NamePropertyComponent.setText(model.getName());
		}
		else if(propertyName == Person.DATE){
			DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
		}
		else if(propertyName == Person.MAIL){
			EmailPropertyComponent.setText(model.getEmail());
		}
		else if(propertyName == Person.HEIGHT){
			HeightPropertyComponent.setValue(model.getHeight());
		}
		else if(propertyName == Person.GENDER){
			GenderPropertyComponent.setSelectedItem(model.getGender());
		}
		
		
		
		
		
	}
	public void setAsEnabled(boolean value) {
		NamePropertyComponent.setEnabled(value);
		DateOfBirthPropertyComponent.setEnabled(value);
		EmailPropertyComponent.setEnabled(value);
		HeightPropertyComponent.setEnabled(value);
		GenderPropertyComponent.setEnabled(value);
	}

}
