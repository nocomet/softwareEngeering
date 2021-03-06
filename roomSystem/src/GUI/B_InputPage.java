package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Foundation.roomList;
import ProblemDomain.conferenceRoom;

//#흔정 2015 05 21 수정
//#흔정 2015 05 25 수정
public class B_InputPage extends JPanel{

	private static final String[] cityNames = {"선택","서울 특별시","인천 광역시","광주 광역시","울산 광역시 ","대전 광역시","대구 광역시","부산 광역시"};
	private static final String[] nullNames = {"선택"};
	private static final String[] seoulDistrictNames = {"선택","도봉구", "강북구", "노원구", "은평구","성북구","동대문구","중량구","종로구","서대문구"
														, "마포구", "용산구", "중구", "성동구", "광진구"
															,"강서구", "양천구", "구로구", "영등포구", "동작구", "금천구", "관악구", "서초구 "
																	,"강남구","송파구", "강동구"};
	private static final String[] incheonDistrictNames = {"선택","동구","남구","연수구","남동구","계양구","서구","중구","부평구","강화군","옹진군"};
	private static final String[] gwangjuDistrictNames = {"선택","북구","동구","서구","남구","광산구"};
	private static final String[] ulsanDistrictNames = {"선택","중구","동구","울주군","남구","북구"};
	private static final String[] daejeonDistrictNames = {"선택","동구","중구","서구","유성구","대덕구"};	
	private static final String[] deagueDistrictNames = {"선택","북구","동구","서구","중구","남구","달성구","수성구","달성군"};
	private static final String[] busanDistrictNames = {"선택","동구","영도구","부산진구","동래구","서구","남구","북구","해운대구","금정구","강서구"
															,"연제구","수영구", "사상구", "기장구","기장군","중구","사하구"};
	private static final String[][] districtNames = {nullNames, seoulDistrictNames, incheonDistrictNames, gwangjuDistrictNames, ulsanDistrictNames 
										,daejeonDistrictNames, deagueDistrictNames, busanDistrictNames};	
	int choice =0;
		
	private JPanel contentPane;
	private JTextField room_txt;
	private JTextField price_txt;
	private JTextField photo_txt;
//	private JTextField addr_txt;		#삭제
	private JTextField addr_txt1;//		#추가
	private JTextField addr_txt2;//		#추가
	
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

		JLabel lblAddr = new JLabel("시, 구");
		lblAddr.setForeground(new Color(44, 62, 80));
		lblAddr.setFont(new Font("돋움", Font.PLAIN, 12));
		lblAddr.setBounds(130, 181, 24, 15);
		add(lblAddr);

		final JComboBox cityName = new JComboBox(cityNames);
		cityName.setBackground(Color.WHITE);
		cityName.setFont(new Font("돋움", Font.PLAIN, 12));
		//cityName.setModel(new DefaultComboBoxModel(new String[] { "서울", "부산", "대구", "우리집" }));
		cityName.setBounds(166, 173, 100, 30);
		add(cityName);

		final JComboBox districtName = new JComboBox(districtNames[choice]);
		districtName.setFont(new Font("돋움", Font.PLAIN, 12));
		districtName.setBackground(Color.WHITE);
		districtName.setBounds(280, 173, 140, 30);
		add(districtName);
		
		cityName.addItemListener(new ItemListener() {
			//@Override
			public void itemStateChanged(ItemEvent arg0) {		
				if(arg0.getStateChange() == ItemEvent.SELECTED)
				{				
					districtName.removeAllItems();
					choice = cityName.getSelectedIndex();							
					for(int i=0; i< districtNames[choice].length;i++)
						districtName.addItem(districtNames[choice][i]);																		
				}			
			}
		});

		//addr_txt1 = new JTextField();
		//addr_txt1.setColumns(8);
		//addr_txt1.setBounds(300, 174, 253, 30);
		//add(addr_txt1);
		
		//addr_txt2 = new JTextField();
		//addr_txt2.setColumns(8);
		//addr_txt2.setBounds(310, 174, 253, 30);
		//add(addr_txt2);

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
//				String address = addr_txt.getText();		#삭제
				
				//#흔정
				String city = cityName.getSelectedItem().toString();//		#추가
				String district = districtName.getSelectedItem().toString();//		#추가
				
				String acceptpeonum= num_txt.getText();
				String Rentcost = price_txt.getText();
				String Ownername = gui.getUser().getName();
				String ownerE = gui.getUser().getEmail();
				conferenceRoom room;
				
				if(photo_txt.getText().equals("파일경로"))
				{
					room = new conferenceRoom(buildingname, city, district, acceptpeonum, Rentcost, Ownername,ownerE);
				}
				else
				{
					ImageIcon photo = new ImageIcon(photo_txt.getText());
					room = new conferenceRoom(buildingname, city, district, acceptpeonum, Rentcost, Ownername,ownerE,photo);
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
