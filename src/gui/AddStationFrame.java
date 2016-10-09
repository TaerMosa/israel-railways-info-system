package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.TheCarmelit;
import exceptions.EmptyFeildExcp;
import exceptions.WrongDetailsException;


public class AddStationFrame extends JFrame implements ActionListener {
	

	private JButton Add;
	private JLabel label1;
	private JLabel label2;
	private TextField field1;
	private TextField field2;
	
	public AddStationFrame(){
		super("Add New Station");
		label1=new JLabel("Station Number:");
		label2 = new  JLabel("Station Name:");
		field1 = new TextField(20);
		field2 = new TextField(20);
		Add = new JButton("Add");
		initialize();
		
	}

	private void initialize() {
		
		this.setSize(270,350 );
		JPanel Head = new JPanel();
		JPanel Center = new JPanel();
		JLabel Footer = new JLabel();
		Head.add(label1);
		Head.add(field1);
		Head.add(label2);
		Head.add(field2);
		Center.add(Add);
		Head.setLayout(new GridLayout(0,2));
		Center.setBackground(Color.ORANGE);
		this.add(Head,BorderLayout.NORTH);
		this.add(Center,BorderLayout.CENTER);
		ImageIcon StationImg = new ImageIcon("src/Pictures/Station.jpg");
		Footer.setIcon(StationImg);
		this.add(Footer,BorderLayout.SOUTH);
		Add.addActionListener(this);
		this.setBounds(400, 150, 275, 350);
     	this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int result;
		try {
		if(this.field1.getText().equals("")||this.field2.getText().equals("")){
				throw new EmptyFeildExcp("Add Station Exception: Empty Field, Please insert rigth Data");}
			
		
		result=TheCarmelit.createInstance().addStation(Integer.parseInt(field1.getText()),field2.getText());
		
switch (result) {

case 1:
			JOptionPane.showMessageDialog(null,"Station Added successfully","Add Msg", JOptionPane.OK_CANCEL_OPTION);
			break;
case 2:			
			JOptionPane.showMessageDialog(null, "Station number must be more than 0", "Error", JOptionPane.ERROR_MESSAGE);
			break;
case 3:
			JOptionPane.showMessageDialog(null, "Error! Station is already exist", "Error", JOptionPane.ERROR_MESSAGE);
			break;
case 4:
			throw new WrongDetailsException("Wrong Details Exception!!Add Station Faild");

	         
}
		} catch (EmptyFeildExcp e1) {
			e1.printStackTrace();
		} catch (WrongDetailsException e1) {
			e1.printStackTrace();
		}

			}
		
	
	

}
