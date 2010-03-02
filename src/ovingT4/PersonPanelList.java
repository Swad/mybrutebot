package ovingT4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonPanelList extends JPanel implements ListSelectionListener {
	private PersonPanel personPanel;
	private JList list;
	private DefaultListModel listModel;
	
	/**
	 * 
	 */
	public PersonPanelList() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.weightx = 0.5;
		
		personPanel = new PersonPanel();
		constraint.fill = GridBagConstraints.VERTICAL;
		constraint.weightx = 0.5;
		constraint.gridx = 3;
		constraint.gridy = 0;
		constraint.gridwidth = 0;
		constraint.gridheight = 2;
		add(personPanel, constraint);
		
		list = new JList();
		listModel = new DefaultListModel();
//		list.setModel(listModel);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(15);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        JScrollPane listScrollPane = new JScrollPane(list);
        
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.weightx = 0.5;
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.gridwidth = 2;
		constraint.gridheight = 2;
		add(listScrollPane, constraint);
		
		JButton NewPersonButton = new JButton("Add Person");
		NewPersonButton.setName("NewPersonButton");
		NewPersonButton.addActionListener(new AddPerson());
		JButton RemovePersonButton = new JButton("Remove Person");
		RemovePersonButton.setName("DeletePersonButton");
		RemovePersonButton.addActionListener(new RemovePerson());
		
		JPanel buttonGroup = new JPanel();
		buttonGroup.add(NewPersonButton);
		buttonGroup.add(RemovePersonButton);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.weightx = 0.5;
		constraint.gridx = 0;
		constraint.gridy = 3;
		add(buttonGroup, constraint);
		
		personPanel.setAsEnabled(false);
		
		
	}
	
	public void setModel(DefaultListModel model) {
		list.setModel(model);
	}
	
	public DefaultListModel getModel(){
		return (DefaultListModel) list.getModel();
	}
	private class AddPerson implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Person newperson = new Person("Unknown Person");
			listModel = (DefaultListModel) list.getModel();
			listModel.addElement(newperson);
//			list.setModel(listModel);
			
		}
		
	}
	private class RemovePerson implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Person person = (Person) list.getSelectedValue();
			listModel = (DefaultListModel) list.getModel();
			// MÅ UNSELECTE LISTEN!
			list.setSelectedIndex(0);
			listModel.removeElement(person);
//			list.setModel(listModel);
			
			
		}
		
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Person chosenPerson = (Person) list.getSelectedValue();
//		System.out.println(chosenPerson.getName()+", "+chosenPerson.getDateOfBirth()+", "+chosenPerson.getHeight()+", "+chosenPerson.getEmail());
//		personPanel.setModel(chosenPerson);
		personPanel.setPersonAsModel(chosenPerson);
		personPanel.getModel();
		disablePersonPanelIfNeeded();
		
	}
	
	private void disablePersonPanelIfNeeded() {
		if (list.getSelectedValue() != null) {
			personPanel.setAsEnabled(true);
		}
		else {
			personPanel.setAsEnabled(false);
		}
	}
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		PersonPanelList personPanelList = new PersonPanelList();
		personPanelList.setOpaque(true);
		frame.setContentPane(personPanelList);
		frame.setSize(800,400);
		
		Person person1 = new Person("Petar");
		Person person2 = new Person("Rullan");
		Person person3 = new Person("Betchn");
		
	
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement(person1);
		listModel.addElement(person2);
		listModel.addElement(person3);
		personPanelList.setModel(listModel);
		
		
		
		
	
	}


}
