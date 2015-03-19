package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Foundation.CbookList;
import Foundation.roomList;
import PhysicalArchitecture.Client;
import ProblemDomain.bookedRoom;
import ProblemDomain.conferenceRoom;
import ProblemDomain.personalUser;

public class nomal_calendarPage extends JFrame implements ActionListener
{
	private Client client;
	private int roomNumber;
	private String[] days = { "일", "월", "화", "수", "목", "금", "토" };
	private conferenceRoom conferenceroom;
	private int year, month, day, togle = 0;
	private Calendar today;
	private Calendar cal;
	private roomList roomlist;
	Font font;
	JButton btnBefore, btnAfter, btnBack;
	JButton[] calBtn = new JButton[49];
	JPanel panNorth;
	JPanel panSouth;
	JTextField txtMonth, txtYear;

	private GUI_console gui;
	public nomal_calendarPage(int roomnum) {
		gui=GUI_console.getInstance();
		roomlist = gui.getRoomListResponse();
		conferenceroom = roomlist.getRoom(roomnum);
		roomNumber = roomnum;
		today = Calendar.getInstance(); 
		cal = new GregorianCalendar();
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;

		panNorth = new JPanel();
		panSouth = new JPanel(new GridLayout(7, 7));
		font = new Font("돋움", Font.BOLD, 18);

		panNorth.add(btnBefore = new JButton("Before"));
		panNorth.add(txtYear = new JTextField(year + "년"));
		panNorth.add(txtMonth = new JTextField(month + "월"));
		panNorth.add(btnAfter = new JButton("After"));
		txtYear.setEnabled(false);
		txtMonth.setEnabled(false);
		txtYear.setFont(font);
		txtMonth.setFont(font);

		add(panNorth,"North");
		add(panSouth,"Center");

		gridInit();
		calSet();
		hideInit();

		btnBefore.addActionListener(this);
		btnAfter.addActionListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("예약현황");
		setBounds(0, 0, 700, 550);
		setVisible(true);
	}

	public void calSet() {
		cal.set(Calendar.YEAR, year);//현재 년도 설정
		cal.set(Calendar.MONTH, (month - 1));//현재 달 설정
		cal.set(Calendar.DATE, 1);//현재 일 설정

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//현재요일 저장
		int j = 0;
		int hopping = 0;

		for (int i = cal.getFirstDayOfWeek(); i < dayOfWeek; i++) {
			j++;
		}//첫번째 요일 찾기.
		hopping = j;
		for (int kk = 0; kk < hopping; kk++) {
			calBtn[kk + 7].setText("");
		}//첫번째 요일전까지 모두 빈칸
		for (int i = cal.getMinimum(Calendar.DAY_OF_MONTH); i <= cal.getMaximum(Calendar.DAY_OF_MONTH); i++) 
		{
			cal.set(Calendar.DATE, i);
			if (cal.get(Calendar.MONTH) != month - 1) 
			{
				break;
			}
			calBtn[i + 6 + hopping].setText((i) + "");
		}//일수별 칸에 숫자 적어줌.
	}
	//버튼 생성부분, 리스너도 같이 달아줌.
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnBack){

		} else if (ae.getSource() == btnBefore) {
			if (togle != 0) {
				this.panSouth.removeAll();
				togle--;
				calInput(-1);
				gridInit();
				panelInit();
				calSet();
				hideInit();
				this.txtYear.setText(year + "년");
				this.txtMonth.setText(month + "월");
			}
		} else if (ae.getSource() == btnAfter) {
			this.panSouth.removeAll();
			togle++;
			if (conferenceroom.getCalendar(conferenceroom.getcalendarListSize()-1).getYear() <= year && conferenceroom.getCalendar(conferenceroom.getcalendarListSize()-1).getmonth() <= month) //달력이 만들어져있는지 체크함
			{
				conferenceroom.addcalendarList();
			}
			calInput(1);
			gridInit();
			panelInit();
			calSet();
			hideInit();
			this.txtYear.setText(year + "년");
			this.txtMonth.setText(month + "월");
		} else if (Integer.parseInt(ae.getActionCommand()) >= 1
				&& Integer.parseInt(ae.getActionCommand()) <= 31) {
			day = Integer.parseInt(ae.getActionCommand());
			for (int i = 0; i < 49; i++)
				if (calBtn[i].getText() == ae.getActionCommand()) {
					int result = 1;
					String[] buttons = {"네", "아니요"};
					if(gui.getUser() instanceof personalUser)
					{	
						result = JOptionPane.showOptionDialog(null, "예약하시겠습니까?", " ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "아니요");

						if(result == 0)
						{
							conferenceroom.setSchedule(year, month, day);
							bookedRoom bookedroom = new bookedRoom((gui.getUser().getEmail()),conferenceroom.getOwnerEmail(),year, month, day, roomNumber);

							gui.getBookListFromServer();
							CbookList booklist=gui.getBookListResponse();
							boolean check=true;
							for(int j = 0 ; j < booklist.getSize();j++)
							{
								if(booklist.getBook(j).equalBook(bookedroom))
								{
									check=false;
									break;
								}
							}
							if(check)
							{
								JOptionPane.showMessageDialog(null, "예약완료하였습니다.\n결재대기상태입니다.");
								gui.sendToSeverBook(bookedroom);
								gui.sendToSeverRoomList(roomlist);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "다른분이 먼저 이미 예약신청을 하였습니다.\n다시 시도 하세요");
								dispose();
							}
						}
					}
					else
					{
						result = JOptionPane.showOptionDialog(null, "검색 불가로 설정하시겠습니까?", " ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "아니요");

						if(result == 0)
						{
							conferenceroom.setSchedule(year, month, day);
							bookedRoom bookedroom = new bookedRoom((gui.getUser().getEmail()),conferenceroom.getOwnerEmail(),year, month, day, roomNumber);
							bookedroom.setState(2);
							gui.getBookListFromServer();
							CbookList booklist=gui.getBookListResponse();

							JOptionPane.showMessageDialog(null, "검색불가로 설정했습니다.");
							gui.sendToSeverBook(bookedroom);
							gui.sendToSeverRoomList(roomlist);
							dispose();
						}
					}
					break;
				}
		}
	}
	//필요없는 칸 비활성화
	public void hideInit() {
		for (int i = 0; i < calBtn.length; i++) {
			if ((calBtn[i].getText()).equals(""))
				calBtn[i].setEnabled(false);
		}
		for (int i = 0; i < calBtn.length; i++) {
			if (calBtn[i].isEnabled()) {
				int temp = Integer.parseInt(calBtn[i].getText());
				if (conferenceroom.getCalendar(togle).getbook(temp - 1))
					calBtn[i].setEnabled(false);
			}
		}
	}


	//각 버튼 Init
	public void gridInit() {
		for (int i = 0; i < days.length; i++) {
			panSouth.add(calBtn[i] = new JButton(days[i]));
			calBtn[i].setEnabled(false);
			calBtn[i].setContentAreaFilled(false);
			calBtn[i].setBorderPainted(false);
		}//요일 부분은 비활성화.
		for (int i = days.length; i < 49; i++) {
			panSouth.add(calBtn[i] = new JButton(""));
			calBtn[i].addActionListener(this);
		}//날짜 부분 ActionListener생성
	}
	//그리드 레이아웃 설정
	public void panelInit() {
		GridLayout gridLayout1 = new GridLayout(7, 7);
		panSouth.setLayout(gridLayout1);
	}
	//날짜 숫자 설정
	public void calInput(int gap) {
		month += (gap);
		if (month <= 0) {
			month = 12;
			year = year - 1;
		} else if (month >= 13) {
			month = 1;
			year = year + 1;
		}
	}
}