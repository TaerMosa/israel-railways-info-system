package gui;

import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import core.Activity;
import core.Station;
import core.TheCarmelit;

public class numOfActivitiesMadeInEachStationFrame {

	public numOfActivitiesMadeInEachStationFrame() {
		 JFrame frame = new JFrame();
		 Map<Station, Integer> map = TheCarmelit.createInstance().numOfActivitiesMadeInEachStation();
		    Object rowData[][] =new Object[map.keySet().size()][3];
		    Object columnNames[] = { "Station Code", "Station Name", "Number Of Activities" };
		    
		    int i=0;
		    for(Station station:map.keySet()){
		    	rowData[i][0]=station.getStationNumber();
		    	rowData[i][1]=station.getName();
		    	rowData[i][2]=map.get(station);
		    	i++;
		    }
		    JTable table = new JTable(rowData, columnNames);

		    JScrollPane scrollPane = new JScrollPane(table);
		    frame.add(scrollPane, BorderLayout.CENTER);
		    frame.setBounds(300,300, 400, 300);
		    frame.setVisible(true);
	}

}
