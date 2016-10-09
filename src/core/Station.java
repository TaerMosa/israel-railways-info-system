package core;

import java.util.*;
/**
 * Class -- Station - represent a station in the Carmelit
 * @author Shahaf Hazan ~ Java Summer Course 2015
 *	~University Of Haifa
 */
public class Station {
	
	/**
	 * the station's Number
	 * Primary Key
	 */
	private Integer stationNumber;
	/**
	 * the station's name
	 */
	private String name;
	/**
	 * set of all lines go through this station
	 */
	private Set<Line> lines;
	
	/**
	 * full constructor
	 * @param stationNumber
	 * @param name
	 */
	public Station(Integer stationNumber, String name) {
		setStationNumber(stationNumber);
		this.name = name;
		lines = new HashSet<Line>();
	}
	
	/**
	 * partial constructor
	 * @param stationNumber
	 */
	public Station(Integer stationNumber) {
		setStationNumber(stationNumber);
	}
	
	/*============================================ Getters & Setters ============================================*/
	
	public Integer getStationNumber() {
		return stationNumber;
	}

	private void setStationNumber(Integer stationNumber) {
		this.stationNumber = stationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Line> getLines() {
		return lines;
	}
	
	/*============================================ Methods ======================================================*/
	
	/**
	 * add new line to this station
	 * @param lineToAdd
	 * @return
	 */
	public boolean addLine(Line lineToAdd){
		if(lineToAdd!=null){
			return lines.add(lineToAdd);
		}
		return false;
	}
	
	/**
	 * remove a line from this station
	 * @param lineToRemove
	 * @return
	 */
	public boolean removeLine(Line lineToRemove){
		if(lineToRemove!=null){
			return lines.remove(lineToRemove);
		}
		return false;
	}
	
	/*============================================ Equals & toString ============================================*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((stationNumber == null) ? 0 : stationNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (stationNumber == null) {
			if (other.stationNumber != null)
				return false;
		} else if (!stationNumber.equals(other.stationNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Station Number: " + stationNumber + ", Name: " + name;
	}
	

}//END OF ~ class Station
