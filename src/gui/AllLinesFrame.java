package gui;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import core.Line;
import core.Station;
import core.TheCarmelit;

public class AllLinesFrame {

	public AllLinesFrame() {
		JFrame frame = new JFrame();
		
		Map<Integer, Line> map = new HashMap<Integer, Line>();
		map = TheCarmelit.createInstance().getLines();
	    Object rowData[][] =new Object[map.keySet().size()][2];
	    Object columnNames[] = { "Line Number", "Line Color"};
	    
	    int i=0;
	    for(Integer Num:map.keySet()){
	    	rowData[i][0]=Num;
	    	rowData[i][1]=map.get(Num).getLineColor();
	    	
	    	i++;
	    }
	    JTable table = new JTable(rowData, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setBounds(400, 150, 300, 150);
	    frame.setVisible(true);
	}

}
