package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javafx.scene.image.Image;

import javax.swing.*;

import core.TheCarmelit;







@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {
	
	private JButton addStation;
	private JButton addPassenger;
	private JButton addLine;
	private JButton associateLineToStation;
	private JButton passengerBuyTicket;
	private JButton passengerLoadTicketBalance;
	private JButton passengerMakeActivityWithTicket;
	private JButton allActivitiesBetweenGivenDates;
	private JButton numOfActivitiesMadeInEachStation;
	private JButton allTicketsOrderByBalance;
	private JButton AllStations; //show all Stations table
	private JButton AllLines; //show all lines Table
	private JButton AttractionsInIsrael; //A presentation of tourist sites in Israel close to Israel Railways  
	private JButton GoogleStationMap;  //open Html File Browser Thats show Israel googleMAp with stations Lines Marks
	private JLabel Footer;
	
	
	public MainFrame(){
		
		super("Carmelit");
		addStation = new JButton("Add Station");
		addPassenger = new JButton("Add Passenger");
		addLine = new JButton("Add Line");
		associateLineToStation = new JButton("Associate Line To Station");
		passengerBuyTicket = new JButton("Passenger Buy Pass");
		passengerLoadTicketBalance = new JButton("Passenger Load Pass Balance");
		passengerMakeActivityWithTicket = new JButton("Passenger Make Activity With Pass");
		allActivitiesBetweenGivenDates = new JButton("show All Activities Between Given Dates");
		numOfActivitiesMadeInEachStation = new JButton("show Num Of Activities Made In Each Station");
		allTicketsOrderByBalance = new JButton("show All Passes Ordered By Balance");
		AttractionsInIsrael = new JButton("Show Israel tourist sites SlidShow");
		GoogleStationMap = new JButton("Google Map Israel Stations Cities");
		AllStations = new JButton("Show All Stations");
		AllLines = new JButton("Show All Lines");
		addListeners();
		initialize();
		
		
	}
	
	public void addListeners(){
		
		addStation.addActionListener(this);
		addPassenger.addActionListener(this);
		addLine.addActionListener(this);
		associateLineToStation.addActionListener(this);
		passengerBuyTicket.addActionListener(this);
		passengerLoadTicketBalance.addActionListener(this);
		passengerMakeActivityWithTicket.addActionListener(this);
		allActivitiesBetweenGivenDates.addActionListener(this);
		numOfActivitiesMadeInEachStation.addActionListener(this);
		allTicketsOrderByBalance.addActionListener(this);
		AttractionsInIsrael.addActionListener(this);
		GoogleStationMap.addActionListener(this);
		AllStations.addActionListener(this);
		AllLines.addActionListener(this);
	}
	
	public void initialize(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//head Panel
		JPanel head = new JPanel();
		head.setLayout(new FlowLayout());
		JLabel label = new JLabel("The Carmelit");
		Font font = new Font("SansSerif", Font.BOLD, 40);
		label.setFont(font);
		label.setForeground(Color.RED);
		head.add(label);
		// new Color(R,G,B)
		head.setBackground(Color.YELLOW);
		
		//design buttons
			//set font
			font = new Font("SansSerif", Font.BOLD, 11);
			Dimension d = new Dimension(270,50);
			addStation.setFont(font);
			passengerLoadTicketBalance.setFont(font);
			addPassenger.setFont(font);
			passengerMakeActivityWithTicket.setFont(font);
			addLine.setFont(font);
			allActivitiesBetweenGivenDates.setFont(font);
			associateLineToStation.setFont(font);
			numOfActivitiesMadeInEachStation.setFont(font);
			passengerBuyTicket.setFont(font);
			allTicketsOrderByBalance.setFont(font);
			AttractionsInIsrael.setFont(font);
			GoogleStationMap.setFont(font);
			AllStations.setFont(font);
			AllLines.setFont(font);
			//set size
			addStation.setPreferredSize(d);
			passengerLoadTicketBalance.setPreferredSize(d);
			addPassenger.setPreferredSize(d);
			passengerMakeActivityWithTicket.setPreferredSize(d);
			addLine.setPreferredSize(d);
			allActivitiesBetweenGivenDates.setPreferredSize(d);
			associateLineToStation.setPreferredSize(d);
			numOfActivitiesMadeInEachStation.setPreferredSize(d);
			passengerBuyTicket.setPreferredSize(d);
			allTicketsOrderByBalance.setPreferredSize(d);
			AttractionsInIsrael.setPreferredSize(d);
			GoogleStationMap.setPreferredSize(d);
			AllStations.setPreferredSize(d);
			AllLines.setPreferredSize(d);
			//Set Buttons Color
			addStation.setBackground(Color.MAGENTA);
			passengerLoadTicketBalance.setBackground(Color.GREEN);
			addPassenger.setBackground(Color.MAGENTA);
			passengerMakeActivityWithTicket.setBackground(Color.GREEN);
			addLine.setBackground(Color.MAGENTA);
			allActivitiesBetweenGivenDates.setBackground(Color.GREEN);
			associateLineToStation.setBackground(Color.MAGENTA);
			numOfActivitiesMadeInEachStation.setBackground(Color.GREEN);
			passengerBuyTicket.setBackground(Color.MAGENTA);
			allTicketsOrderByBalance.setBackground(Color.GREEN);
			AllStations.setBackground(Color.CYAN);
			AllLines.setBackground(Color.CYAN);
			AttractionsInIsrael.setBackground(Color.ORANGE);
			GoogleStationMap.setBackground(Color.ORANGE);
			
		//buttons Panel
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(0,2));
		buttons.add(buttonPanel(addStation));
		buttons.add(buttonPanel(passengerLoadTicketBalance));
		buttons.add(buttonPanel(addPassenger));
		buttons.add(buttonPanel(passengerMakeActivityWithTicket));
		buttons.add(buttonPanel(addLine));
		buttons.add(buttonPanel(allActivitiesBetweenGivenDates));
		buttons.add(buttonPanel(associateLineToStation));
		buttons.add(buttonPanel(numOfActivitiesMadeInEachStation));
		buttons.add(buttonPanel(passengerBuyTicket));
		buttons.add(buttonPanel(allTicketsOrderByBalance));
		buttons.add(buttonPanel(AllStations));
		buttons.add(buttonPanel(AllLines));
		buttons.add(buttonPanel(AttractionsInIsrael));
		buttons.add(buttonPanel(GoogleStationMap));
		
		//add panels to main frame
		this.setLocationRelativeTo(null);
		this.setBounds(90, 50, 1250, 550);
		this.setLayout(new BorderLayout());
		this.add(head,BorderLayout.NORTH);
		this.add(buttons,BorderLayout.CENTER);
		ImageIcon FooterIcon = new ImageIcon("src/Pictures/passengers.jpg");
		Footer = new JLabel(FooterIcon);
		this.add(Footer,BorderLayout.WEST);
		

	}
	
	public JPanel buttonPanel(JButton btn){
		JPanel p = new JPanel();
		p.setBackground(new Color(246,249,252));
		p.setLayout(new FlowLayout());
		p.add(btn);
		return p;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addStation){
		 new AddStationFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == addPassenger){
			new AddPassengerFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == addLine){
			new AddLineFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == associateLineToStation){
			new associateLineToStationFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == passengerBuyTicket){
			new passengerBuyTicketFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == passengerLoadTicketBalance){
			new passengerLoadTicketBalanceFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == passengerMakeActivityWithTicket){
			new passengerMakeActivityWithTicketFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == allActivitiesBetweenGivenDates){
			new allActivitiesBetweenGivenDatesFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == numOfActivitiesMadeInEachStation){
			new numOfActivitiesMadeInEachStationFrame();
			// TODO Auto-generated method stub
		}
		if(e.getSource() == allTicketsOrderByBalance){
			new allTicketsOrderByBalanceFrame();
			// TODO Auto-generated method stub
		}
		//New Button thats show all stations in the system very useful to the user
		if(e.getSource() == AllStations){
			new AllStationsFrame();
			// TODO Auto-generated method stub
		}
		//New Button thats show all Lines in the system very useful to the user
		if(e.getSource() == AllLines){
			new AllLinesFrame();
			// TODO Auto-generated method stub
		}
		//new Button thats show a SlideShow of Tourists sites closed to IsraelRailways
		if(e.getSource() == AttractionsInIsrael){
			new AttractionsInIsraelFrame();
		}
		//Open a Html File Browser "The File Is in the project Name:GoogleMap.html"
		if(e.getSource()==GoogleStationMap){
			try {
				Desktop.getDesktop().open(new File("GoogleMap.html"));
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		
	}


}