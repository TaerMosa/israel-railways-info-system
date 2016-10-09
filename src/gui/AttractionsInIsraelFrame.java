package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class AttractionsInIsraelFrame extends JFrame {

	private JLabel pic;
	private JLabel Text;
    private JLabel Title;
    private JLabel TravlImg;
	private Timer tm;
	private int x = 0;

	private String[] Tlist = { "Old Aco", "Haifa City", "Carmel mountain",
			"Zikron yaakov", "Nathanea city", "Tel Aviv", "Mekorot Hayarkon",
			"Jerusalem Nigth", "Tamar River" };
	private String[] list = { "src/Pictures/OldAco.jpg",
			"src/Pictures/Haifa.jpg", "src/Pictures/Karmel.jpg",
			"src/Pictures/Zikronyaakov.jpg", "src/Pictures/Nathanea.jpg",
			"src/Pictures/TelAviv.jpg", "src/Pictures/MekorotHayarkon.jpg",
			"src/Pictures/Jerusalem1.jpg", "src/Pictures/Tamar.jpg" };

	public AttractionsInIsraelFrame() {
		super("Tourist sites Slide Show");
		pic = new JLabel();
		Text = new JLabel();
		Title =new  JLabel("טיולים עם הרכבת");
		TravlImg = new JLabel(new ImageIcon("src/Pictures/Travel.jpg"));
		pic.setBounds(50, 50, 400, 300);
		Text.setBounds(500, 50, 200, 50);
		Title.setBounds(300,-10, 300, 50);
		TravlImg.setBounds(500,90, 300, 300);
		Title.setForeground(Color.ORANGE);
		Title.setFont(new Font("SansSerif", Font.BOLD, 30));
		Font font = new Font("SansSerif", Font.ITALIC, 20);
		Text.setForeground(Color.WHITE);
		Text.setFont(font);
		setImageSize(8);
		tm = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setImageSize(x);
				x += 1;
				if (x >= list.length)
					x = 0;

			}
		});
		add(pic);
		add(Text);
		add(Title);
		add(TravlImg);
		tm.start();
		setLayout(null);
		setSize(820, 420);
		getContentPane().setBackground(Color.BLACK);
		setLocationRelativeTo(null);

		setVisible(true);

	}

	public void setImageSize(int i) {
		ImageIcon icon1 = new ImageIcon(list[i]);
		JLabel jLabel = new JLabel(Tlist[i]);
		Image img = icon1.getImage();
		Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		pic.setIcon(newImc);
		Text.setText(jLabel.getText());
	}

}
