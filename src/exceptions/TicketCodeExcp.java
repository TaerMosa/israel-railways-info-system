package exceptions;

import javax.swing.JOptionPane;

import core.Pass;

public class TicketCodeExcp extends Exception {
/**
 * Class For Ticket Code Check
 * @param TicketCode
 */
	public TicketCodeExcp(String TicketCode) {
		super("Ticket Code Exception");
		JOptionPane.showMessageDialog(null,"Ticket Code:"+TicketCode+"Exception:Code Must Be like AAA-123,and ticketCodeLenght=7 " , "Error", JOptionPane.ERROR_MESSAGE);
		
		}
		@Override
		public String getMessage() {
			return super.getMessage();
		}
	

}
