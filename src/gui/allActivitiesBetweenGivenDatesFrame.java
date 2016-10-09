package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.TheCarmelit;
import exceptions.EmptyFeildExcp;

public class allActivitiesBetweenGivenDatesFrame extends JFrame {
	JLabel label1 = new JLabel("Select Start Date:");
	JLabel label2 = new JLabel("Select End Date:");
	final JFrame f = new JFrame();
	JLabel jLabel = new JLabel(new ImageIcon("src/Pictures/Ticket.jpg"));
	final JTextField text1 = new JTextField(10);
	final JTextField text2 = new JTextField(10);
	JButton b1 = new JButton("Calendar");
	JButton b2 = new JButton("Calendar");
	JButton show = new JButton("Show");
    JPanel p = new JPanel();

	public allActivitiesBetweenGivenDatesFrame() {
		p.add(label1);
	      p.add(text1);
	      p.add(b1);
	      p.add(label2);
	      p.add(text2);
	      p.add(b2); 
	      b1.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent ae) {
	            text1.setText(new DatePicker(f).setPickedDate());
	          }
	        });
	      b2.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent ae) {
	            text2.setText(new DatePicker(f).setPickedDate());
	          }
	        });
	      p.setLayout(new GridLayout(0,3));
	      f.add(p,BorderLayout.NORTH);
	      f.add(jLabel,BorderLayout.CENTER);
	      JPanel panel = new JPanel();
	      panel.add(show);
	      panel.setBackground(Color.BLACK);
	      f.add(panel,BorderLayout.SOUTH);
	      f.setBounds(400, 150, 300, 300);
	      f.setVisible(true);
	      show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
				java.util.Date date1 = null;
				java.util.Date date2 = null;
				if(text1.getText().equals("")||text2.getText().equals("")){
					try {
						throw new EmptyFeildExcp("Empty Fields Exception:Please Select Dates");
					} catch (EmptyFeildExcp e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					date1 = sdf.parse(text1.getText());
					date2 = sdf.parse(text2.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new JTableActivityDates(TheCarmelit.createInstance().allActivitiesBetweenGivenDates(date1, date2));
				
			}
		});
	}

}

