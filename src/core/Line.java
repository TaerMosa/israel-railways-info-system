package core;

import java.util.*;

import utils.Constants;

/**
 * Class -- Line - represents a line in The Carmelit
 * 
 * @author Shahaf Hazan ~ Java Summer Course 2015 ~University Of Haifa
 */
public class Line {

	/**
	 * the line number Primary Key
	 */
	private Integer lineNumber;
	/**
	 * the line color must be one of the colors in - Constants.lineColors
	 */
	private String lineColor;
	/**
	 * Map of stations that the line go through and for each station the
	 * value(Double) is the fare(ride-cost) for the ride in this line from a
	 * certain station.
	 */
	private Map<Station, Double> fares;

	/**
	 * full constructor
	 * 
	 * @param lineNumber
	 * @param lineColor
	 */
	public Line(Integer lineNumber, String lineColor) {
		setLineNumber(lineNumber);
		setLineColor(lineColor);
		this.fares = new HashMap<Station, Double>();
	}

	/**
	 * partial constructor
	 * 
	 * @param lineNumber
	 */
	public Line(Integer lineNumber) {
		setLineNumber(lineNumber);
	}

	/*
	 * ============================================ Getters & Setters
	 * ============================================
	 */

	public Integer getLineNumber() {
		return lineNumber;
	}

	private void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getLineColor() {
		return lineColor;
	}

	/**
	 * set the line color IFF the given color equals to one of the possibilities
	 * in Constants.lineColors otherwise set the global lineColor to null
	 * 
	 * @param lineColor
	 */
	public void setLineColor(String lineColor) {
		if (lineColor.equals(Constants.lineColors[0])
				|| lineColor.equals(Constants.lineColors[1])
				|| lineColor.equals(Constants.lineColors[2])) {
			this.lineColor=lineColor;  //Set To Constant Colors
		}
		else{
			this.lineColor=null;
		}
		// TODO Auto-generated method stub
	}

	public Map<Station, Double> getFares() {
		return fares;
	}

	/*
	 * ============================================ Methods
	 * ======================================================
	 */

	/**
	 * this method add a new station which this line go through and save the
	 * given fare for the ride in this line from this station notice that a Map
	 * cannot hold 2 identical keys notice to check if the given station is not
	 * already in this line Map if you won't check it, then the new Key will ran
	 * over the current station Key and the "old" fare will be lost. return true
	 * if succeed to add the new Mapping for this station & fare return false
	 * otherwise Conditions: fare must be more than 0 station must be not null
	 * and not exist already in the Map.
	 * 
	 * @param station
	 * @param fareInStation
	 * @return
	 */
	public boolean addStationAndRideFare(Station station, Double fareInStation) {
		if(station!=null&&fareInStation>0){
			if(!this.fares.containsKey(station)){  //not Exist
				this.fares.put(station, fareInStation);  //add
				return true;
			}
			return false;
		}
		return false;
		
		// TODO Auto-generated method stub

	}

	/**
	 * removes a station from the map use this for ROLLBACK situations.
	 * 
	 * @param stationToRemove
	 * @return
	 */
	public boolean removeStation(Station stationToRemove) {
		if (stationToRemove != null) {
			if (fares.containsKey(stationToRemove)) {
				fares.remove(stationToRemove);
				return true;
			}
		}
		return false;
	}

	/*
	 * ============================================ Equals & toString
	 * ============================================
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lineNumber == null) ? 0 : lineNumber.hashCode());
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
		Line other = (Line) obj;
		if (lineNumber == null) {
			if (other.lineNumber != null)
				return false;
		} else if (!lineNumber.equals(other.lineNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Line [lineNumber=" + lineNumber + ", lineColor=" + lineColor
				+ "]";
	}

}// END OF ~ class Line
