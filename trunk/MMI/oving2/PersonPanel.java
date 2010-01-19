

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PersonPanel extends JPanel {
	private JTextField name;
	private JTextField email;
	private JTextField dateOfBirth; 
	private JSlider height;
	private JComboBox gender;
	
	private Person model;
	
	public PersonPanel() {
		name = new JTextField(); 
		email = new JTextField();
		dateOfBirth = new JTextField(); 
		height = new JSlider(0, 250, 1);
		height.setMajorTickSpacing(50);
		height.setMinorTickSpacing(10);
		height.setPaintTicks(true);
		height.setPaintLabels(true);
		height.setValue(150);
		gender = new JComboBox(new Person().toStringArray());
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel emailLabel = new JLabel("Email:");
		JLabel bornLabel = new JLabel("Born");
		JLabel heightLabel = new JLabel("Height:");
		
		name.setColumns(20);
		email.setColumns(20);
		dateOfBirth.setColumns(20);
		
		name.addKeyListener(new textInputListener());
		email.addKeyListener(new textInputListener());
		dateOfBirth.addKeyListener(new textInputListener());
		gender.addKeyListener(new textInputListener());
		height.addMouseListener(new SliderListener());
		
		
		add(nameLabel);
		add(name);
		add(emailLabel);
		add(email);
		add(bornLabel);
		add(dateOfBirth);
		add(heightLabel);
		add(height);
		add(new JLabel("Gender:"));
		add(gender);

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
		model.setName(name.getText());
		model.setEmail(email.getText());
		model.setDateOfBirth(dateOfBirth.getText());
		model.setHeight(height.getValue());
		this.model = model;
		
		
	}
	public Person getModel() {
		name.setText(model.getName());
		email.setText(model.getEmail());
		dateOfBirth.setText(model.getDateOfBirth());
		height.setValue(model.getHeight());
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
