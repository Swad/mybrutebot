package GraphicGraph;

// inneholder verdiene fra sensorne

public class Value {
	
	private int pollid;
	private String timestamp;
	private double pressure;
	private double resistance;
	private double temperature;
	private double changeInR;
	
	
	public Value(int pollid, String timestamp, double pressure, double resistance, double temperature, double changeInR){
		this.pollid = pollid;
		this.timestamp = timestamp;
		this.pressure = pressure;
		this.resistance = resistance;
		this.temperature = temperature;
		this.changeInR = changeInR;
		
	}
	public String[] toStringTable() {
		String pressureString = this.pressure+"";
		String temperatureString = this.temperature+"";
		String pressureShort = "";
		String temperatureShort = "";
		for (int i= 0; i < 15; i++) {
			pressureShort = pressureShort + pressureString.charAt(i);
			temperatureShort = temperatureShort + temperatureString.charAt(i);
		}
		String[] stringTable = {""+pollid, ""+timestamp, ""+pressureShort, ""+resistance, temperatureShort, ""+changeInR};
		return stringTable;
	}

	public int getPollid() {
		return pollid;
	}


	public void setPollid(int pollid) {
		this.pollid = pollid;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public double getPressure() {
		return pressure;
	}


	public void setPressure(double pressure) {
		this.pressure = pressure;
	}


	public double getResistance() {
		return resistance;
	}


	public void setResistance(double resistance) {
		this.resistance = resistance;
	}


	public double getTemperature() {
		return temperature;
	}


	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}


	public double getChangeInR() {
		return changeInR;
	}


	public void setChangeInR(double changeInR) {
		this.changeInR = changeInR;
	}

}
