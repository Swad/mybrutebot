

public class Person {
	private String name;
	private String dateOfBirth;
	
	private enum Gender {
		male, female;
		
		
	}
	public String[] toStringArray() {
		String[] array = new String[Gender.values().length];
		int count = 0;
		for (Gender each : Gender.values()) {
			array[count] = each.toString();
			count++;
		}
		return array;
	}
	private String email;
	
	private int height;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String toString(){
		return name+", "+email+", "+dateOfBirth+", "+height;
	}
}
