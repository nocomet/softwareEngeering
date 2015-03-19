package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

enum Addr1 {
	선택, 서울특별시, 부산광역시, 대구광역시, 인천광역시, 광주광역시, 대전광역시, 울산광역시, 경기도, 강원도, 충청북도, 충청남도, 전라북도, 전라남도, 경상북도, 경상남도, 제주도;
}

enum SAddr1 {// 서울특별시
	선택, 강남구, 강동구, 강서구, 강북구, 관악구, 광진구, 구로구, 금천구, 노원구, 동대문구, 도봉구, 동작구, 마포구, 서대문구, 성동구, 성북구, 서초구, 송파구, 영등포구, 용산구, 양천구, 은평구, 종로구, 중구, 중랑구
}

enum SAddr2 {// 부산광역시
	선택, 부산
}

enum SAddr3 {// 대구광역시
	선택, 대구
}

enum SAddr4 {// 인천광역시
	선택, 인천
}

enum SAddr5 {// 광주광역시
	선택, 광주
}

enum SAddr6 {// 대전광역시
	선택, 대전
}

enum SAddr7 {// 울산광역시
	선택, 울산
}

enum SAddr8 {// 경기도
	선택, 수원시, 성남시, 의정부시, 안양시, 부천시, 광명시, 평택시, 동두천시, 안산시, 고양시, 과천시, 구리시, 남양주시, 오산시, 시흥시, 군포시, 의왕시, 하남시, 용인시, 파주시, 김포시, 이천시, 화성시, 광주시, 양주시, 포천시, 여주군, 연천군, 가평군, 양평군
}

enum SAddr9 {// 강원도
	선택, 춘천시, 원주시, 강릉시, 동해시, 태백시, 속초시, 삼척시, 홍천군, 횡성군, 영월군, 평창군, 정선군, 철원군, 화천군, 양구군, 인제군, 고성군, 양양군
}

enum SAddr10 {// 충청북도
	선택, 청주시, 충주시, 제천시, 청원군, 보은군, 영동군, 옥천군, 진천군, 괴산군, 증평군, 음성군, 단양군
}

enum SAddr11 {// 충청남도
	선택, 천안시, 공주시, 보령시, 아산시, 서산시, 논산시, 계룡시, 금산군, 연기군, 부여군, 서천군, 청양군, 홍성군, 예산군, 태안군, 당진군
}

enum SAddr12 {// 전라북도
	선택, 전주시, 군산시, 익산시, 정읍시, 남원시, 김제시, 완주군, 진안군, 무주군, 장수군, 임실군, 순창군, 고창군, 부안군
}

enum SAddr13 {// 전라남도
	선택, 목포시, 여수시, 순천시, 나주시, 광양시, 담양군, 곡성군, 구례군, 소흥군, 보성군, 화순군, 장흥군, 강진군, 해남군, 영암군, 무안군, 함평군, 영광군, 장성군, 완도군, 진도군, 신안군
}

enum SAddr14 {// 경상북도
	선택, 포항시, 경주시, 김천시, 안동시, 구미시, 영주시, 상주시, 문경시, 경산시, 군위군, 의성군, 청송군, 영양군, 영덕군, 청도군, 고령군, 성주군, 칠곡군, 예천군, 봉화군, 울진군, 울릉군
}

enum SAddr15 {// 경상남도
	선택, 창원시, 마산시, 진주시, 진해시, 통영시, 사천시, 김해시, 밀양시, 거제시, 양산시, 의령군, 함안군, 창녕군, 고성군, 남해군, 하동군, 산청군, 함양군, 거창군, 합천군
}

enum SAddr16 {// 제주도
	선택, 제주시, 서귀포시, 남제주군, 북제주군
}

public class C_searchPage extends JPanel {
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
				new String[] { "2014", "2015" }));
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

		final JComboBox cbAddr1 = new JComboBox();
		cbAddr1.setBackground(Color.WHITE);
		cbAddr1.setFont(new Font("돋움", Font.PLAIN, 12));
		cbAddr1.setModel(new DefaultComboBoxModel(Addr1.values()));
		cbAddr1.setBounds(303, 136, 90, 21);

		final JComboBox cbAddr2 = new JComboBox();
		cbAddr2.setBackground(Color.WHITE);
		cbAddr2.setFont(new Font("돋움", Font.PLAIN, 12));
		cbAddr2.setBounds(401, 136, 68, 21);
		cbAddr2.setModel(new DefaultComboBoxModel(new String[] { "선택" }));

		cbAddr1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				switch (Addr1.valueOf(cbAddr1.getSelectedItem().toString())
						.ordinal()) {
						case 1:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr1.values()));
							break;
						case 2:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr2.values()));
							break;
						case 3:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr3.values()));
							break;
						case 4:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr4.values()));
							break;
						case 5:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr5.values()));
							break;
						case 6:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr6.values()));
							break;
						case 7:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr7.values()));
							break;
						case 8:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr8.values()));
							break;
						case 9:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr9.values()));
							break;
						case 10:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr10.values()));
							break;
						case 11:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr11.values()));
							break;
						case 12:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr12.values()));
							break;
						case 13:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr13.values()));
							break;
						case 14:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr14.values()));
							break;
						case 15:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr15.values()));
							break;
						case 16:
							cbAddr2.setModel(new DefaultComboBoxModel(SAddr16.values()));
							break;
						default:
							cbAddr2.setModel(new DefaultComboBoxModel(
									new String[] { "선택" }));
							break;
				}
			}
		});

		cbAddr2.setVisible(true);
		add(cbAddr1);
		add(cbAddr2);

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

				String address;
				address = cbAddr1.getSelectedItem().toString()
						+ cbAddr2.getSelectedItem().toString();

				String num;
				num = num_txt.getText();

				gui.searchRoom(date, address, num);
				roomList roomlist = gui.getRoomListResponse();
				if(roomlist.size()==0)
				{
					int result = 1;
					String[] buttons = {"네", "아니요"};
					result = JOptionPane.showOptionDialog(null, "검색된 결과가 없습니다.\n차선책 검색을 하시겠습니까?", " ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "아니요");
					if(result==0)
					{
						int newNum=Integer.parseInt(num);
						newNum+=5;
						String temp="";
						temp+=newNum;
						gui.searchRoom(date, address, temp);
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

			JLabel lblAddr = new JLabel("주 소 :  "+roomlist.getRoom(i).getAddress());
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
