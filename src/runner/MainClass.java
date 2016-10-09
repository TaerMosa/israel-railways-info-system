package runner;

import gui.MainFrame;
import core.TheCarmelit;

public class MainClass {
	
	public static TheCarmelit carmelit;
	
	public static void main(String[] args) {
		
		carmelit = TheCarmelit.createInstance();
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);

	}
}