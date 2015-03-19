package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Foundation.roomList;
import ProblemDomain.conferenceRoom;


public class B_InputPage extends JPanel{

	private JPanel contentPane;
	private JTextField room_txt;
	private JTextField price_txt;
	private JTextField photo_txt;
	private JTextField addr_txt;
	private JTextField num_txt;
	private GUI_console gui;
	private roomList temp;
	public B_InputPage() {
		gui=GUI_console.getInstance();	
		setLayout(null);

		JLabel label = new JLabel("회의실등록");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(30, 46, 80, 24);
		add(label);

		JLabel lblRoom = new JLabel("회의실이름");
		lblRoom.setForeground(new Color(44, 62, 80));
		lblRoom.setFont(new Font("돋움", Font.PLAIN, 12));
		lblRoom.setBounds(94, 141, 60, 15);
		add(lblRoom);

		room_txt = new JTextField();
		room_txt.setBounds(166, 133, 225, 30);
		room_txt.setColumns(10);
		add(room_txt);

		JLabel lblAddr = new JLabel("위치");
		lblAddr.setForeground(new Color(44, 62, 80));
		lblAddr.setFont(new Font("돋움", Font.PLAIN, 12));
		lblAddr.setBounds(130, 181, 24, 15);
		add(lblAddr);

		JComboBox cbAddr1 = new JComboBox();
		cbAddr1.setBackground(Color.WHITE);
		cbAddr1.setFont(new Font("돋움", Font.PLAIN, 12));
		cbAddr1.setModel(new DefaultComboBoxModel(new String[] { "서울", "부산", "대구", "우리집" }));
		cbAddr1.setBounds(166, 173, 65, 30);
		add(cbAddr1);

		JComboBox cbAddr2 = new JComboBox();
		cbAddr2.setFont(new Font("돋움", Font.PLAIN, 12));
		cbAddr2.setBackground(Color.WHITE);
		cbAddr2.setBounds(243, 173, 65, 30);
		add(cbAddr2);

		addr_txt = new JTextField();
		addr_txt.setColumns(10);
		addr_txt.setBounds(320, 174, 253, 30);
		add(addr_txt);

		JLabel lblNum = new JLabel("수용인원");
		lblNum.setForeground(new Color(44, 62, 80));
		lblNum.setFont(new Font("돋움", Font.PLAIN, 12));
		lblNum.setBounds(106, 221, 48, 15);
		add(lblNum);

		num_txt = new JTextField();
		num_txt.setColumns(10);
		num_txt.setBounds(166, 213, 50, 30);
		add(num_txt);

		JLabel lblPrice = new JLabel("대여비용");
		lblPrice.setForeground(new Color(44, 62, 80));
		lblPrice.setFont(new Font("돋움", Font.PLAIN, 12));
		lblPrice.setBounds(106, 261, 48, 15);
		add(lblPrice);

		price_txt = new JTextField();
		price_txt.setColumns(10);
		price_txt.setBounds(166, 253, 90, 30);
		add(price_txt);

		JLabel lblPhoto = new JLabel("사진");
		lblPhoto.setForeground(new Color(44, 62, 80));
		lblPhoto.setFont(new Font("돋움", Font.PLAIN, 12));
		lblPhoto.setBounds(130, 301, 24, 15);
		add(lblPhoto);

		photo_txt = new JTextField("파일경로");
		photo_txt.setEnabled(false);
		photo_txt.setColumns(10);
		photo_txt.setBounds(166, 293, 335, 30);
		add(photo_txt);

		JButton btnfilesearch = new JButton("찾기");
		btnfilesearch.setBackground(Color.LIGHT_GRAY);
		btnfilesearch.setForeground(Color.WHITE);
		btnfilesearch.setFont(new Font("돋움", Font.PLAIN, 12));
		btnfilesearch.setBounds(513, 293, 60, 30);

		JButton btnMenu = new JButton("MENU");
		btnMenu.setForeground(Color.white);
		btnMenu.setFont(new Font("돋움", Font.PLAIN, 15));
		btnMenu.setBackground(new Color(52, 152, 219));
		btnMenu.setBounds(80, 368, 215, 47);

		JButton btnInsert = new JButton("등록");
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBackground(new Color(231, 76, 60));
		btnInsert.setFont(new Font("돋움", Font.PLAIN, 15));
		btnInsert.setBounds(405, 368, 215, 47);

		// button Listener
		btnfilesearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				photo_txt.setText(gui.searchFile());
			}
		});

		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveBmenu();
			}
		});
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String buildingname = room_txt.getText();
				String address = addr_txt.getText();
				String acceptpeonum= num_txt.getText();
				String Rentcost = price_txt.getText();
				String Ownername = gui.getUser().getName();
				String ownerE = gui.getUser().getEmail();
				conferenceRoom room;
				
				if(photo_txt.getText().equals("파일경로"))
				{
					room = new conferenceRoom(buildingname, address, acceptpeonum, Rentcost, Ownername,ownerE);
				}
				else
				{
					ImageIcon photo = new ImageIcon(photo_txt.getText());
					room = new conferenceRoom(buildingname, address, acceptpeonum, Rentcost, Ownername,ownerE,photo);
				}
				
				gui.sendToSeverRoom(room);
				gui.moveBmenu();
			}
		});

		add(btnfilesearch);
		add(btnMenu);
		add(btnInsert);
		JLabel background = new JLabel();
//		background.setIcon(new ImageIcon("C:\\src\\sub.png"));
		background.setIcon(new ImageIcon("./src/sub.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
}
