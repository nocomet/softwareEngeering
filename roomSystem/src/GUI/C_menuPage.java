package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C_menuPage extends JPanel {

	private GUI_console gui;
	public C_menuPage() {
		gui=GUI_console.getInstance();
		
		setLayout(null);

		JButton btnSearch = new JButton("회의실검색");
		btnSearch.setFont(new Font("돋음", Font.PLAIN, 15));
		btnSearch.setBounds(80, 160, 120, 120);

		JButton btnList = new JButton("예약현황조회");
		btnList.setFont(new Font("돋음", Font.PLAIN, 15));
		btnList.setBounds(212, 160, 120, 120);

		JButton btnInfo = new JButton("개인정보수정");
		btnInfo.setFont(new Font("돋음", Font.PLAIN, 15));
		btnInfo.setBounds(350, 310, 120, 120);

		JButton btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("돋음", Font.PLAIN, 15));
		btnLogout.setBounds(482, 310, 120, 120);

		// button Listener
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveCsearch();
			}
		});
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveCmybookInfo();
			}
		});
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveCinfo();
			}
		});
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveMain();
			}
		});

		add(btnSearch);
		add(btnList);
		add(btnInfo);
		add(btnLogout);
		JLabel background = new JLabel();
//		background.setIcon(new ImageIcon("C:\\src\\cmenu.png"));
		background.setIcon(new ImageIcon("./src/cmenu.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
}