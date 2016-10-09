package gui;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import core.Activity;
import core.Station;
import core.TheCarmelit;

public class AllStationsFrame {

	public AllStationsFrame() {
		JFrame frame = new JFrame();
		Map<Integer, Station> map = new HashMap<Integer, Station>();
		map = TheCarmelit.createInstance().getStations();
	    Object rowData[][] =new Object[map.keySet().size()][2];
	    Object columnNames[] = { "Station Code", "Station Name"};
	    
	    int i=0;
	    for(Integer Num:map.keySet()){
	    	rowData[i][0]=Num;
	    	rowData[i][1]=map.get(Num).getName();
	    	
	    	i++;
	    }
	    JTable table = new JTable(rowData, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setBounds(400, 150, 300, 150);
	    
	    frame.setVisible(true);
	}

}
