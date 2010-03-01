package ovingT4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
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
		constraint.gridx = 2;
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
	
		setOpaque(true);
		
		
		
	}
	
	public void setModel(DefaultListModel model) {
		list.setModel(model);
	}
	
	public DefaultListModel getModel(){
		return (DefaultListModel) list.getModel();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Person chosenPerson = (Person) list.getSelectedValue();
		personPanel.setModel(chosenPerson);
	}
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		PersonPanelList personPanelList = new PersonPanelList();
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
