package gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.Pass;
import core.Passenger;
import core.TheCarmelit;
import exceptions.EmptyFeildExcp;

public class passengerLoadTicketBalanceFrame extends JFrame implements ActionListener {
	private JLabel Passengerlabel ;
	private JLabel TicketLabel ;
	private JLabel Balancelabel;
	private TextField  passenger;
	private TextField Tcode;
	private TextField Balance;
	private JButton Load;
	public passengerLoadTicketBalanceFrame() {
		super("Passenger Load Ticket");
		Passengerlabel = new JLabel("Insert Passenger Code");
		TicketLabel = new JLabel("Passenger Ticket Code Format (AAA-123) ");
		Balancelabel = new JLabel("Balance To Add");
		passenger = new TextField(20);
		Tcode = new TextField(20);
		Balance = new TextField(20);
		Load = new JButton("Load");
		Load.addActionListener(this);
		initialize();
	}

	private void initialize() {
		
		JPanel jPanel = new JPanel();
		jPanel.add(Passengerlabel);
		jPanel.add(passenger);
		jPanel.add(TicketLabel);
		jPanel.add(Tcode);
		jPanel.add(Balancelabel);
		jPanel.add(Balance);
		jPanel.setLayout(new GridLayout(0,2));
		this.add(jPanel,BorderLayout.NORTH);
		JLabel jLabel = new JLabel(new ImageIcon("src/Pictures/LoadTicket.jpg"));
		this.add(jLabel,BorderLayout.CENTER);
		JPanel jPanel2 = new JPanel();
		jPanel2.add(Load);
		jPanel2.setBackground(Color.ORANGE);
		this.add(jPanel2,BorderLayout.SOUTH);
		this.setBounds(400, 150, 550, 400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(passenger.getText().equals("")||Tcode.getText().equals("")||Balance.getText().equals("")){
		JOptionPane.showMessageDialog(null,"Load Faild:Empty Fields Insert Data", "ErrorMsg",JOptionPane.ERROR_MESSAGE);
	}
		int result = TheCarmelit.createInstance().passengerLoadTicketBalance(Integer.parseInt(passenger.getText())
				,Tcode.getText(),Double.parseDouble(Balance.getText()));
		switch (result) {
		case 1:
			JOptionPane.showMessageDialog(null,"Balance Load successfully","Add Balance", JOptionPane.OK_CANCEL_OPTION);
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"Load Faild:Ticket not exist or Passenger not exist", "ErrorMsg",JOptionPane.ERROR_MESSAGE);
			break;
		case 3:
			JOptionPane.showMessageDialog(null,"Load Faild:Wrong details", "ErrorMsg",JOptionPane.ERROR_MESSAGE);
			break;

		}
	
	}

}
