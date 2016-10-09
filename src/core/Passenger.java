package core;

import java.util.*;

/**
 * Class -- Passenger - represent a Passenger in the Carmelit
 * @author Shahaf Hazan ~ Java Summer Course 2015
 *	~University Of Haifa
 */
public class Passenger {
	
	/**
	 * the passenger's ID
	 * Primary Key
	 */
	private Integer id;
	/**
	 * the passenger's full name
	 */
	private String name;
	/**
	 * set of all the tickets this passenger owns
	 */
	private Set<Pass> tickets;
	
	/**
	 * full constructor
	 * @param id
	 * @param name
	 */
	public Passenger(Integer id, String name) {
		setId(id);
		this.name = name;
		tickets = new HashSet<Pass>();
	}
	
	/**
	 * partial constructor
	 * @param id
	 */
	public Passenger(Integer id) {
		setId(id);
	}
	
	/*============================================ Getters & Setters ============================================*/
	
	public Integer getId() {
		return id;
	}
	private void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Pass> getTickets() {
		return tickets;
	}
	
	/*============================================ Methods ======================================================*/
	/**
	 * add a new ticket for this set IFF it's not already exist and
	 * IFF the given ticket's code is valid! (not null)
	 * notice you can get here a ticket which its code not valid.
	 * @param newTicket
	 * @return
	 */
	public boolean addTicket(Pass newTicket){
		if(newTicket.getTicketCode()!=null){
			if(!this.tickets.contains(newTicket)){ //not exist
				this.tickets.add(newTicket);  //add
				return true;
			}
			return false;
		}
		return false;
		// TODO Auto-generated method stub

	}
	
	/**
	 * remove a ticket from this passenger
	 * @param ticketToRemove
	 * @return
	 */
	public boolean removeTicket(Pass ticketToRemove){
		if(ticketToRemove!=null)
			return tickets.remove(ticketToRemove);
		return false;
	}
	
	/*============================================ Equals & toString ============================================*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Passenger other = (Passenger) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + "]";
	}

}//END OF ~ class Passenger
