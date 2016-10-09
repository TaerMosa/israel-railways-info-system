package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import core.TheCarmelit;
import exceptions.EmptyFeildExcp;

public class AddPassengerFrame extends JFrame implements ActionListener {

	private JButton Add;
	private JLabel label1;
	private JLabel label2;
	private TextField field1;
	private TextField field2;
	
	public AddPassengerFrame() {
		super("Add New passenger");
		label1=new JLabel("Passenger ID:");
		label2 = new  JLabel("Passenger Name:");
		field1 = new TextField(20);
		field2 = new TextField(20);
		Add = new JButton("Add");
		initialize();
	}

	private void initialize() {
		
		JPanel Head = new JPanel();
		JPanel Center = new JPanel();
		JLabel Footer = new JLabel(new ImageIcon("src/Pictures/passen.jpg"));
		Head.add(label1);
		Head.add(field1);
		Head.add(label2);
		Head.add(field2);
		Center.add(Add);
		Center.setBackground(Color.ORANGE);
		Head.setLayout(new GridLayout(0,2));
		this.add(Head,BorderLayout.NORTH);
		this.add(Center,BorderLayout.CENTER);
		this.add(Footer,BorderLayout.SOUTH);
		Add.addActionListener(this);
		this.setBounds(400, 100, 250, 400);
     	this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int result;
		try {
		if(this.field1.getText().equals("")||this.field2.getText().equals("")){
				throw new EmptyFeildExcp("Add Passenger Exception: Empty Field, Please insert Rigth Data");}
			
		
		result=TheCarmelit.createInstance().addPassenger(Integer.parseInt(field1.getText()),field2.getText());
		
switch (result) {
case 1:
			JOptionPane.showMessageDialog(null,"Passenger Added successfully","Add Msg", JOptionPane.OK_CANCEL_OPTION);
			break;
case 2:			
			JOptionPane.showMessageDialog(null, "Passenger number must be more than 0", "Error", JOptionPane.ERROR_MESSAGE);
			break;
case 3:
			JOptionPane.showMessageDialog(null, "Error! Passenger is already exist", "Error", JOptionPane.ERROR_MESSAGE);
			break;
case 4:
			JOptionPane.showMessageDialog(null, "Wrong details", "Error", JOptionPane.ERROR_MESSAGE);
			break;
	         
}
		} catch (EmptyFeildExcp e1) {
			e1.printStackTrace();
		}
	}
}
