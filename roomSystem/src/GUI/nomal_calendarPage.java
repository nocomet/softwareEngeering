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
	private String[] days = { "��", "��", "ȭ", "��", "��", "��", "��" };
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
		font = new Font("����", Font.BOLD, 18);

		panNorth.add(btnBefore = new JButton("Before"));
		panNorth.add(txtYear = new JTextField(year + "��"));
		panNorth.add(txtMonth = new JTextField(month + "��"));
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
		setTitle("������Ȳ");
		setBounds(0, 0, 700, 550);
		setVisible(true);
	}

	public void calSet() {
		cal.set(Calendar.YEAR, year);//���� �⵵ ����
		cal.set(Calendar.MONTH, (month - 1));//���� �� ����
		cal.set(Calendar.DATE, 1);//���� �� ����

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//������� ����
		int j = 0;
		int hopping = 0;

		for (int i = cal.getFirstDayOfWeek(); i < dayOfWeek; i++) {
			j++;
		}//ù��° ���� ã��.
		hopping = j;
		for (int kk = 0; kk < hopping; kk++) {
			calBtn[kk + 7].setText("");
		}//ù��° ���������� ��� ��ĭ
		for (int i = cal.getMinimum(Calendar.DAY_OF_MONTH); i <= cal.getMaximum(Calendar.DAY_OF_MONTH); i++) 
		{
			cal.set(Calendar.DATE, i);
			if (cal.get(Calendar.MONTH) != month - 1) 
			{
				break;
			}
			calBtn[i + 6 + hopping].setText((i) + "");
		}//�ϼ��� ĭ�� ���� ������.
	}
	//��ư �����κ�, �����ʵ� ���� �޾���.
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
				this.txtYear.setText(year + "��");
				this.txtMonth.setText(month + "��");
			}
		} else if (ae.getSource() == btnAfter) {
			this.panSouth.removeAll();
			togle++;
			if (conferenceroom.getCalendar(conferenceroom.getcalendarListSize()-1).getYear() <= year && conferenceroom.getCalendar(conferenceroom.getcalendarListSize()-1).getmonth() <= month) //�޷��� ��������ִ��� üũ��
			{
				conferenceroom.addcalendarList();
			}
			calInput(1);
			gridInit();
			panelInit();
			calSet();
			hideInit();
			this.txtYear.setText(year + "��");
			this.txtMonth.setText(month + "��");
		} else if (Integer.parseInt(ae.getActionCommand()) >= 1
				&& Integer.parseInt(ae.getActionCommand()) <= 31) {
			day = Integer.parseInt(ae.getActionCommand());
			for (int i = 0; i < 49; i++)
				if (calBtn[i].getText() == ae.getActionCommand()) {
					int result = 1;
					String[] buttons = {"��", "�ƴϿ�"};
					if(gui.getUser() instanceof personalUser)
					{	
						result = JOptionPane.showOptionDialog(null, "�����Ͻðڽ��ϱ�?", " ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "�ƴϿ�");

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
								JOptionPane.showMessageDialog(null, "����Ϸ��Ͽ����ϴ�.\n����������Դϴ�.");
								gui.sendToSeverBook(bookedroom);
								gui.sendToSeverRoomList(roomlist);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "�ٸ����� ���� �̹� �����û�� �Ͽ����ϴ�.\n�ٽ� �õ� �ϼ���");
								dispose();
							}
						}
					}
					else
					{
						result = JOptionPane.showOptionDialog(null, "�˻� �Ұ��� �����Ͻðڽ��ϱ�?", " ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "�ƴϿ�");

						if(result == 0)
						{
							conferenceroom.setSchedule(year, month, day);
							bookedRoom bookedroom = new bookedRoom((gui.getUser().getEmail()),conferenceroom.getOwnerEmail(),year, month, day, roomNumber);
							bookedroom.setState(2);
							gui.getBookListFromServer();
							CbookList booklist=gui.getBookListResponse();

							JOptionPane.showMessageDialog(null, "�˻��Ұ��� �����߽��ϴ�.");
							gui.sendToSeverBook(bookedroom);
							gui.sendToSeverRoomList(roomlist);
							dispose();
						}
					}
					break;
				}
		}
	}
	//�ʿ���� ĭ ��Ȱ��ȭ
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


	//�� ��ư Init
	public void gridInit() {
		for (int i = 0; i < days.length; i++) {
			panSouth.add(calBtn[i] = new JButton(days[i]));
			calBtn[i].setEnabled(false);
			calBtn[i].setContentAreaFilled(false);
			calBtn[i].setBorderPainted(false);
		}//���� �κ��� ��Ȱ��ȭ.
		for (int i = days.length; i < 49; i++) {
			panSouth.add(calBtn[i] = new JButton(""));
			calBtn[i].addActionListener(this);
		}//��¥ �κ� ActionListener����
	}
	//�׸��� ���̾ƿ� ����
	public void panelInit() {
		GridLayout gridLayout1 = new GridLayout(7, 7);
		panSouth.setLayout(gridLayout1);
	}
	//��¥ ���� ����
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