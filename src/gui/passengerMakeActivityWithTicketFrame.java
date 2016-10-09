package gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import utils.Constants;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import core.Line;
import core.Passenger;
import core.Station;
import core.TheCarmelit;
import exceptions.EmptyFeildExcp;

public class passengerMakeActivityWithTicketFrame extends JFrame  {
	private JLabel TCodelable;
	private TextField TcodeText;
	private JLabel Actionlable;
	private Choice  ActionCompo;
	private JLabel StationLable;
	JLabel label = new JLabel("Select Date:");
	final JTextField text = new JTextField(10);
	JButton Active = new JButton("Active");
	JButton b = new JButton("Calendar");
    JPanel p = new JPanel();
    final JFrame f = new JFrame();
	private JTable StationList;
	private JLabel LineLable;
	private JTable LinesList;
	JLabel imgJLabel = new JLabel(new ImageIcon("src/Pictures/ActiveTicket.png"));
	ScrollPane pane = new ScrollPane();
	Object[] Stationcol = {"Station Number","Station Name"};
	Object[] LineCol = {"Line Number","Line Name"};
	Object[][] stationData = new Object[TheCarmelit.createInstance().getStations().keySet().size()][2];
	Object[][] LineData = new Object[TheCarmelit.createInstance().getLines().keySet().size()][2];
	
	

	public passengerMakeActivityWithTicketFrame() {
		super("passenger Make Activity With Ticket");
		TCodelable = new JLabel("Insert Ticket Code:");
		TcodeText = new TextField(20);
		Actionlable = new JLabel("Select Action (In/Out)");
		ActionCompo = new Choice();
		ActionCompo.add(Constants.activityActions[0]);
		ActionCompo.add(Constants.activityActions[1]);
		StationLable = new JLabel("Select Station Number:");
		LineLable = new JLabel("Select Line Number:");
		Load();
	}

	private void Load() {
		int i=0;
	
	for(Integer keyStation:TheCarmelit.createInstance().getStations().keySet()){
		stationData[i][0]=keyStation;
		stationData[i][1]=TheCarmelit.createInstance().getStations().get(keyStation).getName();
		i++;
	}
	i=0;
	for(Integer keyLine:TheCarmelit.createInstance().getLines().keySet()){
		LineData[i][0]=keyLine;
		LineData[i][1]=TheCarmelit.createInstance().getLines().get(keyLine).getLineColor();
		i++;
	}
	
	StationList= new JTable(stationData,Stationcol);
	LinesList= new JTable(LineData, LineCol);
	StationList.setBackground(Color.GREEN);
	LinesList.setBackground(Color.ORANGE);
	JPanel jPanelA = new JPanel();
	JPanel jPanelB = new JPanel();
	jPanelA.add(StationLable);
	jPanelB.add(LineLable);
	jPanelA.add(StationList);
	jPanelB.add(LinesList);
	jPanelA.setLayout(new GridLayout(0,1));
	jPanelB.setLayout(new GridLayout(0,1));
	JPanel jPanel2 = new JPanel();
	jPanel2.add(Active);
	f.add(jPanel2,BorderLayout.PAGE_END);
	f.add(jPanelA,BorderLayout.WEST);
	f.add(jPanelB,BorderLayout.EAST);
	JPanel p2 = new JPanel();
	p2.add(TCodelable);
	p2.add(TcodeText);
	p2.add(Actionlable);
	p2.add(ActionCompo);
		p.add(label);
	      p.add(text);
	      p.add(b);
	      p.setLayout(new GridLayout(0,3));
	      p2.setLayout(new GridLayout(0,2));
	      p2.add(p);
	      f.add(p2,BorderLayout.NORTH);
	      b.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent ae) {
	            text.setText(new DatePicker(f).setPickedDate());
	          }
	        });
	      Active.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(TcodeText.getText().equals("")||ActionCompo.getSelectedIndex()<0||text.getText().equals("")){
					try {
						throw new EmptyFeildExcp("Empty Field ! Please Insert Data");
					} catch (EmptyFeildExcp e1) {
						e1.printStackTrace();
					}
				}
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
				
				
					java.util.Date date = null;
					try {
						date = sdf.parse(text.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				int result= TheCarmelit.createInstance().passengerMakeActivityWithTicket(TcodeText.getText(),ActionCompo.getSelectedItem(),
						date,(Integer)(stationData[StationList.getSelectedRow()][0]),(Integer)(stationData[StationList.getSelectedRow()][0]));
				switch (result) {
				case 0:
					JOptionPane.showMessageDialog(null, "Activity Added successfully", "Make Activity", JOptionPane.OK_CANCEL_OPTION);
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Cant Make Activity Date Before Last Activity Date", "Error Msg", JOptionPane.ERROR_MESSAGE);
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Activity Faild Cant Make Out Action In the First Activity", "Error Msg", JOptionPane.ERROR_MESSAGE);
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "Cant Make Activity Balance is Low", "Error Msg", JOptionPane.ERROR_MESSAGE);
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "Station Or Line Not Exist", "Error Msg", JOptionPane.ERROR_MESSAGE);
					break;
				
				}
			}
		});
	      f.add(imgJLabel,BorderLayout.CENTER);
	      f.setBounds(400, 100, 550, 550);
	      f.setVisible(true);
	}
	

}
