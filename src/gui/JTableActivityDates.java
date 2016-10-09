package gui;

import java.awt.BorderLayout;
import java.awt.List;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import core.Activity;
import core.TheCarmelit;

public class JTableActivityDates {
  public JTableActivityDates(java.util.List<Activity> allActivitiesList) {
	  JFrame frame = new JFrame();
	    Object rowData[][] =new Object[allActivitiesList.size()][6];
	    Object columnNames[] = { "Ticket Code", "Ticket Balance", "OwnerName","OwnerID","Action","Activity Date" };
	    java.util.List<Activity> list = allActivitiesList;
	    int i=0;
	    for(Activity activity:list){
	    	rowData[i][0]=activity.getTicket().getTicketCode();
	    	rowData[i][1]=activity.getTicket().getBalance();
	    	rowData[i][2]=activity.getTicket().getOwner().getName();
	    	rowData[i][3]=activity.getTicket().getOwner().getId();
	    	rowData[i][4]=activity.getAction();
	    	rowData[i][5]=activity.getActivityDateAndTime();
	    	i++;
	    }
	    JTable table = new JTable(rowData, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setBounds(400, 150, 900, 200);
	    frame.setVisible(true);
	}


}