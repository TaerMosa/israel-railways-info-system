package exceptions;

import javax.swing.JOptionPane;

public class EmptyFeildExcp extends Exception {

	/**
	 * Class for Empty Fields Exception
	 * @param str
	 */
	public EmptyFeildExcp(String str) {
		super(str);
		JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.ERROR_MESSAGE);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
