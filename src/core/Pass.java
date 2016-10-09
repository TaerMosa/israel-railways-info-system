package core;

import java.util.*;

import utils.Constants;
/**
 * Class -- Ticket - represent a passenger's ticket
 * @author Shahaf Hazan ~ Java Summer Course 2015
 * 	~University Of Haifa
 */
public class Pass implements Comparable<Pass> {
	/**
	 * the ticket's code
	 * Primary Key
	 * @see setTicketCode()
	 */
	private String ticketCode;
	/**
	 * the ticket's owner
	 * @see setOwner()
	 */
	private Passenger owner;
	/**
	 * the ticket's balance
	 * must be more than or equal to 0
	 */
	private Double balance;
	/**
	 * the ticket's List of activities History
	 */
	private List<Activity> activities;
	
	/**
	 * full constructor
	 * @param ticketCode
	 * @param balance
	 */
	public Pass(String ticketCode, Double balance) {
		setTicketCode(ticketCode);
		setBalance(balance);
		activities = new ArrayList<Activity>();
	}
	
	/**
	 * partial constructor
	 * @param ticketCode
	 */
	public Pass(String ticketCode) {
		setTicketCode(ticketCode);
	}

	/*============================================ Getters & Setters ============================================*/
	public String getTicketCode() {
		return ticketCode;
	}

	/**
	 * Ticket's code length must be equal to Constants.TICKET_CODE_LENGTH
	 * the 3 first chars must be a letter between 'A' and 'Z'
	 * the 4 char must be '-'
	 * the last 3 chars must be a digit between '0' and '9'
	 * example for a correct ticket's code format is >  'ABC-123' , 'AAA-111'
	 * example for an incorrect ticket's code is > 'ABCD-11' , 'A2A-111', 'AA2244B'
	 * IFF the given ticket code from the constructor is not valid then the global ticketCode get null value.
	 * @param ticketCode
	 */
	private void setTicketCode(String ticketCode) {
		int num = Constants.TICKET_CODE_LENGTH;
		if(ticketCode.length()==num
			&& ticketCode.charAt(0)<='Z' &&ticketCode.charAt(0)>='A' 
			&&ticketCode.charAt(1)<='Z'&&ticketCode.charAt(1)>='A'
			&&ticketCode.charAt(2)<='Z'&&ticketCode.charAt(2)>='A'
			&&ticketCode.charAt(3)=='-'
			&&Character.getNumericValue(ticketCode.charAt(num-1))<=9&&Character.getNumericValue(ticketCode.charAt(num-1))>=0
			&&Character.getNumericValue(ticketCode.charAt(num-2))<=9&&Character.getNumericValue(ticketCode.charAt(num-2))>=0
			&&Character.getNumericValue(ticketCode.charAt(num-3))<=9&&Character.getNumericValue(ticketCode.charAt(num-3))>=0){
			this.ticketCode=ticketCode;  //Set to code
			
		}
		else{
		this.ticketCode=null;}
		// TODO Auto-generated method stub
	}
	
	public Double getBalance() {
		return balance;
	}
	
	/**
	 * balance must be more than or equal to 0
	 * if this is not the case then global balance get 0 value
	 * @param balance
	 */
	public void setBalance(Double balance) {
		if(balance>=0){
			this.balance=balance;
		}
		else{
		this.balance=0.0;}
		// TODO Auto-generated method stub

	}

	public List<Activity> getActivities() {
		return activities;
	}

	public Passenger getOwner() {
		return owner;
	}

	/**
	 * a ticket's owner can be set only if it doesn't belongs yet to another owner.
	 * check if this ticket's owner is null and only if it is null, set a new owner and return true.
	 * otherwise return false.
	 * @param owner
	 * @return
	 */
	public boolean setOwner(Passenger owner){
		if(this.owner==null){  //check owner
			this.owner=owner;
			return true;
		}
		return false;
		// TODO Auto-generated method stub

	}
	
	/*============================================ Methods ======================================================*/
	
	/**
	 * Add a new activity for this ticket
	 * @param newActivity
	 * @return
	 */
	public boolean addActivity(Activity newActivity){
		return activities.add(newActivity);
	}
	
	/**
	 * remove activity from this ticket
	 * @param actToRemove
	 * @return
	 */
	public boolean removeActivity(Activity actToRemove){
		return activities.remove(actToRemove);
	}
	
	/*============================================ Equals & toString ============================================*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ticketCode == null) ? 0 : ticketCode.hashCode());
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
		Pass other = (Pass) obj;
		if (ticketCode == null) {
			if (other.ticketCode != null)
				return false;
		} else if (!ticketCode.equals(other.ticketCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [ ticketCode: " + ticketCode + ", owner: " + owner.getName() + ", balance: " + balance + " ]";
	}
	
	/*============================================ Compare To ===================================================*/

	/**
	 * this method compare between one ticket to another based on ticket's BALANCE
	 * the order returns suppose to be from the highest balance to the lowest balance
	 */
	@Override
	public int compareTo(Pass t) { //compare by balance
		if(this.getBalance()<t.getBalance()){
			return 1;
		}
		else{
		if(this.getBalance()==t.getBalance()){
			return 0;
		}
		return -1;
		}
		// TODO Auto-generated method stub

	}

}//END OF ~ class Ticket
