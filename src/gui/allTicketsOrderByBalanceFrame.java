package gui;

import java.awt.BorderLayout;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import core.Activity;
import core.Pass;
import core.TheCarmelit;

public class allTicketsOrderByBalanceFrame {

	public allTicketsOrderByBalanceFrame() {
		 JFrame frame = new JFrame();
		 TreeSet<Pass> passes = TheCarmelit.createInstance().allTicketsOrderByBalance();
		    Object rowData[][] =new Object[passes.size()][3];
		    Object columnNames[] = { "Ticket Code", "Ticket Owner", "Ticket Balance" };
		    
		    int i=0;
		    for(Pass pass:passes){
		    	rowData[i][0]=pass.getTicketCode();
		    	rowData[i][1]=pass.getOwner().getName();
		    	rowData[i][2]=pass.getBalance();
		    	i++;
		    }
		    JTable table = new JTable(rowData, columnNames);

		    JScrollPane scrollPane = new JScrollPane(table);
		    frame.add(scrollPane, BorderLayout.CENTER);
		    
		    frame.setBounds(500,200,300, 350);
		    frame.setVisible(true);
	}

}
