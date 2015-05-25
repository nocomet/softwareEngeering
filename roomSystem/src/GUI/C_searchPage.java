package GUI;
//#흔정 2015 05 21 수정
//#흔정 2015 05 25 수정
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import Foundation.roomList;
import ProblemDomain.conferenceRoom;

public class C_searchPage extends JPanel {
	
	private static final String[] cityNames = {"선택","서울 특별시","인천 광역시","광주 광역시","울산 광역시 ","대전 광역시","대구 광역시 ","부산 광역시"};
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
	
	private JTextField num_txt;
	private JPanel table_p = new JPanel();
	private JScrollPane scroll = new JScrollPane(table_p,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton btnSearch ;
	
	private GUI_console gui;

	public C_searchPage() {
		gui=GUI_console.getInstance();		
		setLayout(null);

		JLabel label = new JLabel("MY회의실");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(32, 46, 68, 24);
		add(label);

		table_p.setBounds(32, 165, 630, 300);
		table_p.setLayout(new BoxLayout(table_p, BoxLayout.Y_AXIS));

		scroll.setMinimumSize(new Dimension(630, 300));
		scroll.setPreferredSize(new Dimension(630, 300));
		scroll.setBorder(null);

		JPanel border = new JPanel();
		border.setBounds(32, 165, 630, 300);
		border.setLayout(new BorderLayout());

		border.add(scroll);
		add(border);

		JLabel lblDate = new JLabel("날짜");
		lblDate.setForeground(new Color(44, 62, 80));
		lblDate.setFont(new Font("돋움", Font.PLAIN, 12));
		lblDate.setBounds(30, 135, 24, 20);
		add(lblDate);

		
		final JComboBox cbyear = new JComboBox();
		cbyear.setBackground(Color.WHITE);
		cbyear.setFont(new Font("돋움", Font.PLAIN, 12));
		cbyear.setModel(new DefaultComboBoxModel(
				new String[] {"2014", "2015" }));
		cbyear.setBounds(66, 135, 55, 21);
		add(cbyear);

		final JComboBox cbmonth = new JComboBox();
		cbmonth.setBackground(Color.WHITE);
		cbmonth.setFont(new Font("돋움", Font.PLAIN, 12));
		cbmonth.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3",
				"4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cbmonth.setBounds(133, 135, 55, 21);
		add(cbmonth);

		final JComboBox cbday = new JComboBox();
		cbday.setBackground(Color.WHITE);
		cbday.setFont(new Font("돋움", Font.PLAIN, 12));
		cbday.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3",
				"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" }));
		cbday.setBounds(200, 136, 55, 21);
		add(cbday);

		JLabel lblSAddr = new JLabel("위치");
		lblSAddr.setForeground(new Color(44, 62, 80));
		lblSAddr.setFont(new Font("돋움", Font.PLAIN, 12));
		lblSAddr.setBounds(267, 136, 24, 20);
		add(lblSAddr);

		final JComboBox cityName = new JComboBox(cityNames);
		cityName.setBackground(Color.WHITE);
		cityName.setFont(new Font("돋움", Font.PLAIN, 12));
		//cityName.setModel(new DefaultComboBoxModel(cityName.values()));
		cityName.setBounds(303, 136, 90, 21);

		final JComboBox districtName = new JComboBox(districtNames[choice]);
		districtName.setBackground(Color.WHITE);
		districtName.setFont(new Font("돋움", Font.PLAIN, 12));
		districtName.setBounds(401, 136, 68, 21);
		//districtName.setModel(new DefaultComboBoxModel(new String[] { "선택" }));

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

		districtName.setVisible(true);
		add(cityName);
		add(districtName);

		JLabel lblSNum = new JLabel("인원");
		lblSNum.setForeground(new Color(44, 62, 80));
		lblSNum.setFont(new Font("돋움", Font.PLAIN, 12));
		lblSNum.setBounds(481, 136, 24, 20);
		add(lblSNum);

		num_txt = new JTextField();
		num_txt.setFont(new Font("돋움", Font.PLAIN, 12));
		num_txt.setBounds(517, 136, 68, 21);
		add(num_txt);
		num_txt.setColumns(10);
		num_txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch.doClick();
			}
		});
		btnSearch = new JButton("검색");
		btnSearch.setBackground(new Color(52, 152, 219));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("돋움", Font.PLAIN, 12));
		btnSearch.setBounds(597, 135, 64, 23);

		JButton btnMenu = new JButton("MENU");
		btnMenu.setForeground(Color.white);
		btnMenu.setFont(new Font("돋움", Font.PLAIN, 12));
		btnMenu.setBackground(new Color(52, 152, 219));
		btnMenu.setBounds(32, 473, 90, 35);

		// button Listener
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String date;
				date = cbyear.getSelectedItem().toString()+"#"
						+ cbmonth.getSelectedItem().toString()+"#"
						+ cbday.getSelectedItem().toString();

				String city;
				city = cityName.getSelectedItem().toString();
				
				String district;
				district = districtName.getSelectedItem().toString();

				String num;
				num = num_txt.getText();

				gui.searchRoom(date, city, district, num);////#흔정 ~ 파라미터 고침에 따른 input값 변경
				roomList roomlist = gui.getRoomListResponse();
				if(roomlist.size()==0)
				{
					int result = 1;
					String[] buttons = {"네", "아니요"};
					result = JOptionPane.showOptionDialog(null, "검색된 결과가 없습니다.\n차선책 검색을 하시겠습니까?", " ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "아니요");
					if(result==0)
					{
						/*
						int newNum=Integer.parseInt(num);
						newNum+=5;
						String temp="";
						temp+=newNum;
						gui.searchRoom(date, city, district, temp);*/
						
						gui.recommendSecond(date, city, district, num);
						roomList templist = gui.getRoomListResponse();
						resultPrint(templist);	
					}
					else
					{
						//아니요면 아무일도 일어나지 않는다.
					}					
				}
				else
					resultPrint(roomlist);
			}
		});
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveCMenu();
			}
		});

		add(btnSearch);
		add(btnMenu);
		JLabel background = new JLabel();
//		background.setIcon(new ImageIcon("C:\\src\\sub.png"));
		background.setIcon(new ImageIcon("./src/sub.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}

	public void resultPrint( final roomList roomlist) {

		table_p.removeAll();
		for (int i = 0; i < roomlist.size(); i++) {
			JPanel row_p = new JPanel();
			table_p.add(row_p);
			final conferenceRoom room=roomlist.getRoom(i);
			row_p.setLayout(new MigLayout("", "[120px][510]", "[100px]"));
			JLabel lblPhoto;

			if(roomlist.getRoom(i).getPhoto()!=null){

				ImageIcon img = roomlist.getRoom(i).getPhoto();
				Image temp = img.getImage().getScaledInstance(120, 100, java.awt.Image.SCALE_SMOOTH);
				img.setImage(temp);
				lblPhoto = new JLabel(img);
			}
			else{
				lblPhoto = new JLabel(new ImageIcon("C:\\src\\no_room.png"));
			}
			row_p.add(lblPhoto, "cell 0 0,grow");
			lblPhoto.setForeground(new Color(44, 62, 80));
			lblPhoto.setFont(new Font("돋움", Font.PLAIN, 12));

			JLabel lblRoom = new JLabel("회의실 이름 :  "+roomlist.getRoom(i).getName());
			row_p.add(lblRoom, "flowy,cell 1 0,alignx left,growy");
			lblRoom.setForeground(new Color(44, 62, 80));
			lblRoom.setFont(new Font("돋움", Font.PLAIN, 12));

			JLabel lblNum = new JLabel("수용 인원 :  "+roomlist.getRoom(i).getAcceptPeoNum());
			row_p.add(lblNum, "cell 1 0,alignx left,growy");
			lblNum.setForeground(new Color(44, 62, 80));
			lblNum.setFont(new Font("돋움", Font.PLAIN, 12));

			JLabel lblPrice = new JLabel("대여 비용 :  "+roomlist.getRoom(i).getRentcost());
			row_p.add(lblPrice, "cell 1 0,alignx left,growy");
			lblPrice.setForeground(new Color(44, 62, 80));
			lblPrice.setFont(new Font("돋움", Font.PLAIN, 12));

			JLabel lblAddr = new JLabel("주 소 :  "+roomlist.getRoom(i).getCity()+ roomlist.getRoom(i).getDistrict());			//#수정
			row_p.add(lblAddr, "cell 1 0,alignx left,growy");
			lblAddr.setForeground(new Color(44, 62, 80));
			lblAddr.setFont(new Font("돋움", Font.PLAIN, 12));

			row_p.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int roomNum=room.getRoomNumber();
					gui.getRoomListFromServer();
					gui.moveCalendar(roomNum);
				}
			});

		}
	}

}
