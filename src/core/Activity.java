package core;

import java.util.*;

import utils.Constants;
/**
 * Class -- Activity - represents a ticket's activity
 * @author Shahaf Hazan ~ Java Summer Course 2015
 *	~University Of Haifa
 */
public class Activity {
	
	/**
	 * the ticket made the activity
	 * Primary Key
	 */
	private Pass ticket;
	/**
	 * the activity date & time occur
	 * Primary Key
	 */
	private Date activityDateAndTime;
	/**
	 * the action of the activity - 'IN' / 'OUT'
	 * @see Constants.activityActions
	 *  
	 */
	private String action;
	/**
	 * the station of the activity 
	 */
	private Station station;
	/**
	 * the line of the activity
	 */
	private Line line;
	
	/**
	 * full constructor
	 * @param ticket
	 * @param action
	 * @param activityDateAndTime
	 * @param station
	 * @param line
	 */
	public Activity(Pass ticket, String action, Date activityDateAndTime,
			Station station, Line line) {
		this.ticket = ticket;
		setAction(action);
		this.activityDateAndTime = activityDateAndTime;
		this.station = station;
		this.line = line;
	}
	
	/*============================================ Getters & Setters ============================================*/

	public Pass getTicket() {
		return ticket;
	}

	public String getAction() {
		return action;
	}

	/**
	 * set the action of the activity only if it's equal to 'IN' or 'OUT'
	 * otherwise set to null
	 * @use Constants.activityActions
	 * @param action
	 */
	public void setAction(String action) {
		// TODO Auto-generated method stub to do here
		if(action.equals(Constants.activityActions[0])||action.equals(Constants.activityActions[1])){
			this.action=action;  //IN or Out
		}
		else{
		this.action=null;}

	}

	public Date getActivityDateAndTime() {
		return activityDateAndTime;
	}

	public Station getStation() {
		return station;
	}

	public Line getLine() {
		return line;
	}
	
	/*============================================ Equals & toString ============================================*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((activityDateAndTime == null) ? 0 : activityDateAndTime
						.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
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
		Activity other = (Activity) obj;
		if (activityDateAndTime == null) {
			if (other.activityDateAndTime != null)
				return false;
		} else if (!activityDateAndTime.equals(other.activityDateAndTime))
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "Activity [ ticket: " + ticket.getTicketCode() + ", action: '" + action
				+ "', activityDateAndTime: " + activityDateAndTime.toLocaleString() + ", station: "
				+ station.getName() + ", line: " + line.getLineNumber() + " ]";
	}

}//END OF ~ class Activity
