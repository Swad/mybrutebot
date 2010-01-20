package oving3;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Person {
	public final static String NAME_PROPERTY = "NamePropertyComponent";
	public final static String EMAIL_PROPERTY = "EmailPropertyComponent";
	public final static String DATEOFBIRTH_PROPERTY = "DateOfBirthPropertyComponent";
	public final static String GENDER_PROPERTY = "GenderPropertyComponent";
	public final static String HEIGHT_PROPERTY = "HeightPropertyComponent";
	
	private enum Gender {
		male, female;
	}
	private String name;
	private String dateOfBirth;
	private Gender gender;
	private PropertyChangeSupport pcs;
	private String email;
	private int height;
	
	
	public String[] toStringArray() {
		String[] array = new String[Gender.values().length];
		int count = 0;
		for (Gender each : Gender.values()) {
			array[count] = each.toString();
			count++;
		}
		return array;
	}
	
	public Person(){
		pcs = new PropertyChangeSupport(this);
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		pcs.firePropertyChange(NAME_PROPERTY, oldValue, name);
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		String oldValue = this.email;
		this.email = email;
		pcs.firePropertyChange(EMAIL_PROPERTY, oldValue, email);
	}

	public String getEmail() {
		return email;
	}

	public void setHeight(int height) {
		int oldValue = this.height;
		this.height = height;
		pcs.firePropertyChange(HEIGHT_PROPERTY, oldValue, height);
	}

	public int getHeight() {
		return height;
	}

	public void setDateOfBirth(String dateOfBirth) {
		String oldValue = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(DATEOFBIRTH_PROPERTY, oldValue, dateOfBirth);
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public String toString(){
		return name+", "+email+", "+dateOfBirth+", "+height;
	}

	public void setGender(Gender gender) {
		Gender oldValue = this.gender;
		this.gender = gender;
		pcs.firePropertyChange(GENDER_PROPERTY, oldValue, gender);
	}

	public Gender getGender() {
		return gender;
	}
}
