package exceptions;

import javax.swing.JOptionPane;

public class WrongDetailsException extends Exception{
/**
 * class for Wrong Input Exception
 * @param str
 */
	public WrongDetailsException(String str) {
			super(str);
			JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.ERROR_MESSAGE);
		}
		@Override
		public String getMessage() {
			return super.getMessage();
		}
	}


