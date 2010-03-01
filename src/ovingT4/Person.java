package ovingT4;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Person {
	
	private String name, dateOfBirth, email;
	private int height;
	private Gender gender;
	private PropertyChangeSupport pcs;
	
	public final static String NAME = "NamePropertyComponent";
	public final static String DATE = "DateOfBirthPropertyComponent";
	public final static String MAIL = "EmailPropertyComponent";
	public final static String GENDER = "GenderPropertyComponent";
	public final static String HEIGHT = "HeightPropertyComponent";
	
	public Person(){
		this.pcs = new PropertyChangeSupport(this);
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		String oldDate = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(NAME, oldDate, dateOfBirth);
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String oldMail = this.email;
		this.email = email;
		pcs.firePropertyChange(MAIL, oldMail, email);
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		int oldHeight = this.height;
		this.height = height;
		pcs.firePropertyChange(HEIGHT, oldHeight, height);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		pcs.firePropertyChange(NAME, oldName, name);
	}
	
	public void setGender(Gender gender){
		Gender oldGender = this.gender;
		this.gender = gender;
		pcs.firePropertyChange(GENDER, oldGender, gender);
	}
	
	public Gender getGender(){
		return this.gender;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener){
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener){
		pcs.removePropertyChangeListener(listener);
	}
	
	public String toString(){
		return getName();
	
	}
}