package core;

import java.util.*;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.NEW;

import exceptions.EmptyFeildExcp;
import utils.Constants;

/**
 * Class -- TheCarmelit - represent all the Carmelit DB and Logic Methods
 * 
 * @author Shahaf Hazan ~ Java Summer Course 2015 ~University Of Haifa
 */
public class TheCarmelit {

	/**
	 * instance of this class for the singleton design pattern
	 */
	private static TheCarmelit instance;
	/**
	 * Map of all Carmelit Stations
	 */
	private Map<Integer, Station> stations;
	/**
	 * Map of all Carmelit Lines
	 */
	private Map<Integer, Line> lines;
	/**
	 * Map of all Carmelit Passengers
	 */
	private Map<Integer, Passenger> passengers;

	/**
	 * private full constructor, part of the singleton design pattern
	 */
	private TheCarmelit() {
		this.stations = new HashMap<Integer, Station>();
		this.lines = new HashMap<Integer, Line>();
		this.passengers = new HashMap<Integer, Passenger>();
	}

	/**
	 * the SingleTone Method Design Pattern
	 * 
	 * @return
	 */
	public static TheCarmelit createInstance() {
		if (instance == null) {
			instance = new TheCarmelit();
			return instance;
		} else
			return instance;
	}

	/*--------------------------------------------------- Add Methods -------------------------------------------------------*/

	/**
	 * This method creates and adds a new Station to the Carmelit IFF it is not
	 * already exist and IFF all station details are valid (not null and more
	 * than 0)
	 * 
	 * @param stationNumber
	 * @param name
	 * @return true if succeed, otherwise false
	 */
	public int addStation(Integer stationNumber, String name) throws EmptyFeildExcp  {
		
		if (stationNumber > 0 && name != null) {
			if (!stations.containsKey(stationNumber)) {
				Station stationToAdd = new Station(stationNumber, name);
				if (stationToAdd.getStationNumber() != 0) {
					this.stations.put(stationToAdd.getStationNumber(),
							stationToAdd);
					return 1;
				}
				return 2;
			}
			return 3;
		}
		return 4;
			
		}
	

	/**
	 * This method creates and adds a new Passenger to the Carmelit IFF it is
	 * not already exist and IFF all passengers details are valid (not null and
	 * more than 0)
	 * 
	 * @param stationNumber
	 * @param name
	 * @return true if succeed, otherwise false
	 */
	public int addPassenger(Integer id, String name) {
	
		if (id > 0 && name != null) {
			if (!passengers.containsKey(id)) {
				Passenger passengerToAdd = new Passenger(id, name);
				if (passengerToAdd.getId() != 0) {
					this.passengers.put(passengerToAdd.getId(), passengerToAdd);
					return 1;
				}
				return 2;
				
			}
			return 3;
		}
		return 4;
	
	
	
	}

	/**
	 * This method creates and adds a new Line to the Carmelit IFF it is not
	 * already exist and IFF all line details are valid (not null and more than
	 * 0) and IFF line color is valid (check the line color after creating the
	 * new Line if not null)
	 * 
	 * @param stationNumber
	 * @param name
	 * @return true if succeed, otherwise false
	 */
	public int addLine(Integer lineNumber, String lineColor) {
		if (lineNumber > 0 && lineColor != null) {
			if (!this.lines.containsKey(lineNumber)) {  //not exist
				Line newLine = new Line(lineNumber, lineColor);
				if (newLine.getLineColor() != null) {  //check color
					this.lines.put(newLine.getLineNumber(), newLine);  //add
					return 1;
				}
				return 2;
			}
			return 3;
		}
		return 4;
		// TODO Auto-generated method stub

	}

	/*------------------------------------------------ Connection Methods ---------------------------------------------------*/

	/**
	 * This method associate Line To Station IFF all details are valid (not null
	 * and more than 0) and IFF the Carmelit contains the given stationNumber &
	 * lineNumber and IFF this line and station are not already connected (the
	 * 'add' method succeed) and Notice: to roll-back (and remove) if one of the
	 * 'adds' fails
	 * 
	 * @param stationNumber
	 * @param lineNumber
	 * @param rideFare
	 * @return true if succeed, otherwise false
	 */
	public int associateLineToStation(Integer stationNumber,
			Integer lineNumber, Double rideFare) {
		if (stationNumber > 0 && lineNumber > 0 && rideFare > 0) {
			if (this.lines.containsKey(lineNumber)
					&& this.stations.containsKey(stationNumber)) {  //check exist
				Station station = this.stations.get(stationNumber);
				Line line = this.lines.get(lineNumber);
				if (line.addStationAndRideFare(station, rideFare)) {
					if (station.addLine(line)) {
						return 1;
					} else {
						// rollback
						line.removeStation(station);
						return 2;
					}
				}
				return 3;
			}
			return 4;
		}
		return 5;
		// TODO Auto-generated method stub

	}

	/**
	 * This method connect between a given ticket to a passenger IFF all
	 * ticket's details are valid (include the ticket's code) and IFF the
	 * passenger id is exist in the Carmelit DB and IFF this ticket don't have a
	 * previous owner and IFF this passenger not already bought this ticket
	 * Notice: to roll-back (and remove) if one of the 'adds' or 'set' fails
	 * 
	 * @param id
	 * @param ticket
	 * @return true if succeed, otherwise false
	 */
	public int passengerBuyTicket(Integer id, Pass ticket) {
		if (id > 0 && ticket != null && ticket.getTicketCode() != null) {
			if (this.passengers.containsKey(id)) {   //check exist
				Passenger passenger = this.passengers.get(id);  
				if (passenger.addTicket(ticket)) {  //add ticket
					if (ticket.setOwner(passenger)) {  //set owner
						return 1;
					} else {
						// rollback
						passenger.removeTicket(ticket);

						return 2;

					}
				}

				return 3;
			}

			return 4;
		}

		return 5;
		// TODO Auto-generated method stub

	}

	/**
	 * This method load the balance of the given ticket code which belongs to
	 * the given passenger's id. IFF both passenger and ticket exist and IFF the
	 * balanceToAdd is more than 0 set the new ticket balance to be the current
	 * ticket's balance + balanceToAdd
	 * 
	 * @param id
	 * @param ticketCode
	 * @param balanceToAdd
	 * @return true if succeed, otherwise false
	 */
	public int passengerLoadTicketBalance(Integer id, String ticketCode,
			Double balanceToAdd) {
		if (id > 0 && balanceToAdd > 0 && ticketCode != null) {
			Pass Ticket = new Pass(ticketCode);
			if (this.passengers.containsKey(id)
					&& this.passengers.get(id).getTickets().contains(Ticket)) { //check passenger
				Passenger passenger = this.passengers.get(id);
				for (Pass pass : passenger.getTickets()) {
					if (pass != null && pass.equals(Ticket)) { 
						pass.setBalance(pass.getBalance() + balanceToAdd); //add balance
						return 1;
					}
				}
			}
			return 2;
		}
		return 3;
		// TODO Auto-generated method stub

	}

	/**
	 * Add activity to a passenger's ticket IFF the ticket exist in passengre's
	 * DB and IFF this is the first activity of a certain ticket it must be 'IN'
	 * activity and IFF the last Activity date&time made, was before the current
	 * activity to be add and IFF the given line is connected to the given
	 * station and IFF the passenger has enough balance to do this activity
	 * >Notice: that only 'IN' action of the activity is charged from the
	 * ticket's balance and IFF the activity's action is set correctly (got only
	 * 'IN' or 'OUT) >Don't forget to set the ticket's balance appropriately
	 * 
	 * Notice:: IFF the passenger do 'IN' or 'OUT' activity twice a row,
	 * meaning: do 'IN' after the last activity was 'IN' OR do 'OUT' after the
	 * last activity was 'OUT' - then the ticket is charged with a Fine of 5
	 * NIS. and the Activity is add to the ticket's activities.
	 * 
	 * @param ticketCode
	 * @return the Passenger object who Made the activity - if the activity
	 *         added successfully, otherwise return null
	 */

	public int passengerMakeActivityWithTicket(String ticketCode, String action, Date activityDateAndTime,
			Integer stationNumber, Integer lineNumber){
		// TODO Auto-generated method stub
		if(stations.containsKey(stationNumber) && lines.containsKey(lineNumber)){
			for(Passenger pass : passengers.values()){
				for(Pass tick : pass.getTickets()){
					if(tick.getTicketCode().equals(ticketCode)){
						int index = tick.getActivities().size();
						if(index > 0){
							if (tick.getActivities().get(index-1).getActivityDateAndTime().after(activityDateAndTime))
								return 1;
						}
						else if(index==0){
							if(action.equals(Constants.activityActions[1]))
								return 2;
						}
						Station station = stations.get(stationNumber);
						Line line = lines.get(lineNumber);
						for(Line l : station.getLines()){
							if(l.equals(line)){
								Activity act = new Activity(tick, action, activityDateAndTime, station, line);
								if(act.getAction()!=null){
									if (tick.addActivity(act)){
										if(index > 0){
											if(action.equals(Constants.activityActions[0]))
												if (tick.getActivities().get(index-1).getAction().equals(Constants.activityActions[0])){
													tick.setBalance(tick.getBalance()-5.0);
												}
											if(action.equals(Constants.activityActions[1]))
												if (tick.getActivities().get(index-1).getAction().equals(Constants.activityActions[1])){
													tick.setBalance(tick.getBalance()-5.0);
												}
										}
										if(act.getAction().equals(Constants.activityActions[0])){
											double newBalance = tick.getBalance()-line.getFares().get(station);
											if(newBalance<0){
												tick.removeActivity(act);
												return 3;
											}
											tick.setBalance(newBalance);
										}
										return 0;
									}
								}
							}
						}
					}
				}
			}
		}
		return 4;
	}


	/*----------------------------------------------------- Queries ---------------------------------------------------------*/

	/**
	 * This query return a list of all Activities made Between 2 Given Dates
	 * accordingly to the startDate and endDate given, return a list only of the
	 * activities happened between this dates.
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Activity> allActivitiesBetweenGivenDates(Date startDate,
			Date endDate) {
		// TODO Auto-generated method stub
		List<Activity> activities = new ArrayList<Activity>();  //saver list 
		for (Passenger passenger : this.passengers.values()) {
			if (passenger != null) {
				for (Pass pass : passenger.getTickets()) {
					if (pass != null) {
						for (Activity activity : pass.getActivities()) {
							if (activity != null) {
								if (activity.getActivityDateAndTime().after(
										startDate)
										&& activity.getActivityDateAndTime()
												.before(endDate)) {  //check date
									activities.add(activity);   //add activity
								}
							}
						}
					}
				}
			}
		}
		return activities;

	}

	/**
	 * This query return a Map of Key=Station, Value=number of activities made
	 * in the key station for each station calculate the number of activities
	 * happened in this station and put in the Map the station and the number.
	 * **Hint: Map structure do not accept duplicate keys. if a duplicate key is
	 * put in the map, then the "old" value of the key is ran over by the new
	 * value put. think of a way to use this feature in order to implement this
	 * query
	 * 
	 * @return
	 */
	public Map<Station, Integer> numOfActivitiesMadeInEachStation() {
		Map<Station, Integer> stationMap = new HashMap<Station, Integer>(); 
		int[] serv = new int[this.stations.size()];  //to save number of activities for each station
		int i = 0;  //serv index
		for (Station station : this.stations.values()) {
			if (station != null) {
				for (Passenger passenger : this.passengers.values()) {
					if (passenger != null) {
						for (Pass Ticket : passenger.getTickets()) {
							if (Ticket != null) {
								for (Activity activity : Ticket.getActivities()) {
									if (activity != null
											&& station.equals(activity
													.getStation())) {  //check station activity
										serv[i]++;  //count the serv array 
									}
								}
							}
						}
					}
				}
				i++;  //move to the next station
			}
		}
		i = 0; 
		for (Station station : this.stations.values()) {
			if (station != null) {
				stationMap.put(station, serv[i++]);  //add stations and activities
			}
		}
		return stationMap;

		// TODO Auto-generated method stub

	}

	/**
	 * This Query return a TreeSet of all tickets in use, ordered by their
	 * balance from the higher balance to the lowest balance (Descending order)
	 * 
	 * @implement the compareTo(Ticket t) method in class Ticket - this will
	 *            decide the order of elements in the TreeSet **Notice: TreeSet
	 *            is a structure which the elements organized inside it by their
	 *            natural order. >>the natural order of an Object is decided by
	 *            the compareTo() Method implementation in the Object's Class.
	 * @return
	 */
	public TreeSet<Pass> allTicketsOrderByBalance() {
		TreeSet<Pass> allTickets = new TreeSet<Pass>();  
		for (Passenger passenger : this.passengers.values()) {
			if (passenger != null) {
				for (Pass pass : passenger.getTickets()) {
					if (pass != null) {
						allTickets.add(pass);  //add 
					}
				}
			}
		}
		return allTickets;
		// TODO Auto-generated method stub

	}
	//---------------------Getters ---------------------------------------------

	public Map<Integer, Station> getStations() {
		return stations;
	}

	public Map<Integer, Line> getLines() {
		return lines;
	}

	public Map<Integer, Passenger> getPassengers() {
		return passengers;
	}

	

}// END OF ~ class TheCarmelit
