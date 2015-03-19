package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class nomal_JoinPage extends JPanel {
	
	private GUI_console gui;
	public nomal_JoinPage() {
		gui=GUI_console.getInstance();		
		setLayout(null);

		String temp=new String("기업회원");
		JButton btnBjoin = new JButton(temp);
		btnBjoin.setForeground(Color.white);
		btnBjoin.setFont(new Font("돋음", Font.PLAIN, 15));
		btnBjoin.setBackground(new Color(46, 204, 113));
		btnBjoin.setBounds(90, 370, 215, 47);
		
		JButton btnCjoin = new JButton("일반회원");
		btnCjoin.setForeground(new Color(255, 255, 255));
		btnCjoin.setBackground(new Color(241, 196, 15));
		btnCjoin.setFont(new Font("돋음", Font.PLAIN, 15));
		btnCjoin.setBounds(395, 370, 215, 47);

		// button Listener
		btnCjoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveCJoinPage();
			}
		});
		
		btnBjoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveBJoinPage();
			}
		});

		add(btnBjoin);
		add(btnCjoin);
		
		JLabel background = new JLabel();
//		background.setIcon(new ImageIcon("C:\\src\\join.png"));
		background.setIcon(new ImageIcon("./src/join.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
}
