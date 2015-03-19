package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_menuPage extends JPanel {

	private GUI_console gui;
	public B_menuPage() {
		gui=GUI_console.getInstance();	
		setLayout(null);

		JButton btnInput = new JButton("회의실 등록");
		btnInput.setFont(new Font("돋움", Font.PLAIN, 15));
		btnInput.setBounds(80, 160, 120, 120);

		JButton btnList = new JButton("MY 회의실");
		btnList.setFont(new Font("돋움", Font.PLAIN, 15));
		btnList.setBounds(212, 160, 120, 120);

		JButton btnBookedRoom = new JButton("예약 확인");
		btnBookedRoom.setFont(new Font("돋움", Font.PLAIN, 15));
		btnBookedRoom.setBounds(344, 160, 120, 120);

		JButton btnInfo = new JButton("개인정보수정");
		btnInfo.setFont(new Font("돋움", Font.PLAIN, 15));
		btnInfo.setBounds(368, 310, 120, 120);

		JButton btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("돋움", Font.PLAIN, 15));
		btnLogout.setBounds(500, 310, 120, 120);

		// button Listener
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveInputPage();
			}
		});
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveBmyroomInfo();
			}
		});
		btnBookedRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveBmybookInfo();
			}
		});
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveBinfo();
			}
		});
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveMain();
			}
		});

		add(btnInput);
		add(btnList);
		add(btnBookedRoom);
		add(btnInfo);
		add(btnLogout);
		JLabel background = new JLabel();
//		background.setIcon(new ImageIcon("C:\\src\\bmenu.png"));
		background.setIcon(new ImageIcon("./src/bmenu.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}

}