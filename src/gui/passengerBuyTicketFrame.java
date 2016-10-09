package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import core.Pass;
import core.TheCarmelit;
import exceptions.EmptyFeildExcp;
import exceptions.TicketCodeExcp;

public class passengerBuyTicketFrame extends JFrame implements ActionListener {
	private JLabel passengers;
	private JTable passengersT;
	private JLabel CodeLable;
	private TextField TicketCode;
	private JLabel BalancLable;
	private TextField TicketBalance;
	String[] TableTitle ={"Passenger ID","Passenger Name"};
	Object[][] PassengersMatrix = new Object[TheCarmelit.createInstance().getPassengers().keySet().size()][2];
	private JButton BuyTicket;

	public passengerBuyTicketFrame() {
		super("Passenger By Ticket");
		passengers = new JLabel("Select  Passenger:");
		CodeLable = new JLabel("Insert Ticket Code Forrmat(AAA-123):");
		TicketCode = new TextField(20);
		BalancLable = new JLabel("Insert Ticket Balance:");
		TicketBalance = new TextField(20);
		BuyTicket = new JButton("Buy Ticket");
		BuyTicket.addActionListener(this);
		initialize();
	}

	private void initialize() {
		int i=0;
		
		this.add(passengers);
		for(Integer Key:TheCarmelit.createInstance().getPassengers().keySet()){
			PassengersMatrix[i][0]=Key;
			PassengersMatrix[i][1]=TheCarmelit.createInstance().getPassengers().get(Key).getName();
			i++;
		}
		passengersT = new JTable(PassengersMatrix, TableTitle);
		passengersT.setBackground(Color.ORANGE);
		JPanel jPanel = new JPanel();
		jPanel.add(passengersT);
		jPanel.setLayout(new GridLayout(0,1));
		this.add(jPanel,BorderLayout.WEST);
		JPanel jPanel2 = new JPanel();
		jPanel2.add(CodeLable);
		jPanel2.add(TicketCode);
		jPanel2.add(BalancLable);
		jPanel2.add(TicketBalance);
		jPanel2.add(passengers);
		jPanel2.setLayout(new GridLayout(0,2));
		this.add(jPanel2,BorderLayout.NORTH);
		JPanel jPanel3 = new JPanel();
		jPanel3.add(BuyTicket);
		this.add(jPanel3,BorderLayout.SOUTH);
		JLabel jLabel = new JLabel(new ImageIcon("src/Pictures/BuyTicket.jpg"));
		this.add(jLabel,BorderLayout.CENTER);
		this.setBounds(400, 200, 470, 400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TicketCode.getText().equals("")||TicketBalance.getText().equals("")){
			try {
				throw new EmptyFeildExcp("Exception: Please insert Tiket code and balance");
			} catch (EmptyFeildExcp e1) {
				e1.printStackTrace();
			}
		}
		if(passengersT.getSelectedRow()<0){
			JOptionPane.showMessageDialog(null,"Buy Ticket Faild:Please Select passenger Code","Error Msg",JOptionPane.ERROR_MESSAGE);
			
		}
		
		Pass pass = new Pass(this.TicketCode.getText(),Double.parseDouble(TicketBalance.getText()));
		if(pass.getTicketCode()==null){
			try {
				throw new TicketCodeExcp(TicketCode.getText());
			} catch (TicketCodeExcp e1) {
				e1.printStackTrace();
			}
		}
		int result=TheCarmelit.createInstance().passengerBuyTicket((Integer)(PassengersMatrix[passengersT.getSelectedRow()][0]),pass);
		switch (result) {
		case 1:
			JOptionPane.showMessageDialog(null,"Buy Ticket successfully","Buy Ticket Msg",JOptionPane.OK_CANCEL_OPTION);
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"Buy Ticket Faild: Set owner Error","Error Msg",JOptionPane.ERROR_MESSAGE);
			break;
		case 3:
			JOptionPane.showMessageDialog(null,"Buy Ticket Faild:Cant add ticket to this passenger","Error Msg",JOptionPane.ERROR_MESSAGE);
			break;
		case 4:
			JOptionPane.showMessageDialog(null,"Buy Ticket Faild:Passenger not exist","Error Msg",JOptionPane.ERROR_MESSAGE);
			break;
		case 5:
			JOptionPane.showMessageDialog(null,"Buy Ticket Faild: Wrong Details","Error Msg",JOptionPane.ERROR_MESSAGE);
			break;
		}
		
		
		
	}

}
