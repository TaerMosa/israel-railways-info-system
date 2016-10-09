package gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.TheCarmelit;
import exceptions.EmptyFeildExcp;
import utils.Constants;

public class AddLineFrame extends JFrame implements ActionListener{
	private JLabel label1;
	private JLabel label2;
	private JTextField field1;
	private Choice colors;
	private JButton Add;

	public AddLineFrame() {
		super("Add New Line");
		label1= new JLabel("Line Number: ");
		label2 = new JLabel("select Line Color:");
		field1 = new JTextField(20);
		Add = new JButton("Add");
		colors= new Choice();
		colors.add(Constants.lineColors[0]);
		colors.add(Constants.lineColors[1]);
		colors.add(Constants.lineColors[2]);
		initialize();
	}

	private void initialize() {
		
		JPanel Head = new JPanel();
		JPanel Center = new JPanel();
		JLabel Footer = new JLabel(new ImageIcon("src/Pictures/Lines.jpg"));
		Center.setBackground(Color.ORANGE);
		Head.add(label1);
		Head.add(field1);
		Head.add(label2);
		Head.add(colors);
		Center.add(Add);
		Head.setLayout(new GridLayout(0,2));
		this.add(Head,BorderLayout.NORTH);
		this.add(Center,BorderLayout.CENTER);
		this.add(Footer,BorderLayout.SOUTH);
		Add.addActionListener(this);
		this.setBounds(400, 150, 250, 320);
     	this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int result;
		try {
		if(this.field1.getText().equals("")){
				throw new EmptyFeildExcp("Add Line Exception: Empty Field, Please insert rigth Data");}
			
		
		result=TheCarmelit.createInstance().addLine(Integer.parseInt(field1.getText()),colors.getSelectedItem());
		
switch (result) {

case 1:
			JOptionPane.showMessageDialog(null,"Line Added successfully","Add Msg", JOptionPane.OK_CANCEL_OPTION);
			break;
case 2:			
			JOptionPane.showMessageDialog(null, "Line color is null", "Error", JOptionPane.ERROR_MESSAGE);
			break;
case 3:
			JOptionPane.showMessageDialog(null, "Error! Line is already exist", "Error", JOptionPane.ERROR_MESSAGE);
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
