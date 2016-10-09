package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import core.TheCarmelit;
import exceptions.EmptyFeildExcp;





public class associateLineToStationFrame extends JFrame implements ActionListener{
	private JButton Connect;
	private JLabel Stations;
	private JLabel Lines;
	private JLabel rideFare;
	private JTable StationsT;
	private JTable LinesT;
	private JTextField Fare;
	private JScrollPane pane;
	Object[] Stationcol = {"Station Number","Station Name"};
	Object[] LineCol = {"Line Number","Line Name"};
	Object[][] stationData = new Object[TheCarmelit.createInstance().getStations().keySet().size()][2];
	Object[][] LineData = new Object[TheCarmelit.createInstance().getLines().keySet().size()][2];

	public associateLineToStationFrame() {
		super("Connect Line To Station");
	Stations = new JLabel("Choose Stations Table ");
	Lines = new JLabel("Choose Lines Table ");
	Connect = new JButton("Connect");
	rideFare = new JLabel("Insert Ride Fare :");
	Fare = new JTextField(20);
	initialize();
	}

	private void initialize() {
		
		int i=0;
		Connect.addActionListener(this);
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
	
	StationsT= new JTable(stationData,Stationcol);
	LinesT= new JTable(LineData, LineCol);
	StationsT.setBackground(Color.GREEN);
	LinesT.setBackground(Color.ORANGE);
	JLabel jLabel = new JLabel(new ImageIcon("src/Pictures/Connect.jpg"));
	
	add(jLabel);
	add(Stations);
	add(StationsT);
	add(Lines);
	add(LinesT);
	JPanel jPanel = new JPanel();
	jPanel.add(rideFare);
	jPanel.add(Fare);
	jPanel.setLayout(new FlowLayout());
	add(jPanel,BorderLayout.AFTER_LAST_LINE);
	JPanel  jPanel2 = new JPanel();
	jPanel2.add(Connect);
	add(jPanel2,BorderLayout.AFTER_LAST_LINE);
	setLayout(new GridLayout(0,1));
	setBounds(400, 100, 450, 600);
	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Fare.getText().equals("")){
			try {
				throw new EmptyFeildExcp("Connect Line to station exception! Please add Fare");
			} catch (EmptyFeildExcp e1) {
				e1.printStackTrace();
			}
		}
		if(LinesT.getSelectedRow()<0&&StationsT.getSelectedRow()<0){
			JOptionPane.showMessageDialog(null,"Error!!please select line and station from the lists", "Error Msg",JOptionPane.ERROR_MESSAGE);
		}else{
			if(LinesT.getSelectedRow()<0&&StationsT.getSelectedRow()>=0){
				JOptionPane.showMessageDialog(null,"Error!!please select line list", "Error Msg",JOptionPane.ERROR_MESSAGE);
			}else{
				if(LinesT.getSelectedRow()>=0&&StationsT.getSelectedRow()<0){
					JOptionPane.showMessageDialog(null,"Error!!please select station from the list", "Error Msg",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		int result =TheCarmelit.createInstance().associateLineToStation((Integer)(stationData[StationsT.getSelectedRow()][0]),
				(Integer)(LineData[LinesT.getSelectedRow()][0]),Double.parseDouble(Fare.getText()));
				switch (result) {
				case 1:
					JOptionPane.showMessageDialog(null,"Station and Line Connected successfully","Connect Msg",JOptionPane.OK_CANCEL_OPTION);
					break;
				case 2:
					JOptionPane.showMessageDialog(null,"Connect Faild Station already connect to this line", "Error Msg",JOptionPane.ERROR_MESSAGE);
					break;
				case 3:
					JOptionPane.showMessageDialog(null,"Error to add station number and rideFare to this line", "Error Msg",JOptionPane.ERROR_MESSAGE);
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Error: Station or line dose not exist", "Error Msg",JOptionPane.ERROR_MESSAGE);
					break;
				case 5:
					JOptionPane.showMessageDialog(null,"Error: Wrong Details", "Error Msg",JOptionPane.ERROR_MESSAGE);
					break;

				}
			
		
		
	}

}
