package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import Foundation.CbookList;
import ProblemDomain.bookedRoom;
import ProblemDomain.conferenceRoom;

public class C_mybookInfo extends JPanel {
	private JTextField num_txt;
	private JPanel table_p = new JPanel();
	private JScrollPane scroll = new JScrollPane(table_p,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JButton btnSearch;
	private GUI_console gui;

	public C_mybookInfo() {
		gui=GUI_console.getInstance();		
		setLayout(null);

		JLabel label = new JLabel("MY예약정보");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		label.setBounds(28, 46, 100, 24);
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

		btnSearch = new JButton("조회");
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
				//-------------------roomlist만 받을 수 밖에 없다-------------//
				gui.getBookListFromServerWithEmail();
				CbookList booklist = gui.getBookListResponse();
				if(booklist.getSize()==0)
					JOptionPane.showMessageDialog(null,"예약한 룸이 없습니다.");

				resultPrint(booklist);

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
		background.setIcon(new ImageIcon("./src/sub.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}

	public void resultPrint(final CbookList booklist) {
		table_p.removeAll();
		for (int i = 0; i < booklist.size(); i++) {
			JPanel row_p = new JPanel();
			table_p.add(row_p);
			row_p.setLayout(new MigLayout("", "[120px][210px][165px][95px]", "[100px]"));
			conferenceRoom tempRoom=gui.getConferenceRoomForRoomNumber(booklist.getBook(i).getroomNum());

			final JLabel hiddenNumber = new JLabel(String.valueOf(i));

			JLabel lblPhoto;			
			if(tempRoom.getPhoto()!=null){

				ImageIcon img = tempRoom.getPhoto();
				Image temp = img.getImage().getScaledInstance(120, 100, java.awt.Image.SCALE_SMOOTH);
				img.setImage(temp);
				lblPhoto = new JLabel(img);
			}
			else{
				lblPhoto = new JLabel(new ImageIcon("./src/no_room.png"));
			}
			row_p.add(lblPhoto, "cell 0 0,grow");
			lblPhoto.setForeground(new Color(44, 62, 80));
			lblPhoto.setFont(new Font("돋움", Font.PLAIN, 12));


			final JLabel lblRoom = new JLabel("회의실 이름: " + tempRoom.getName());
			row_p.add(lblRoom, "flowy,cell 1 0,alignx left,growy");
			lblRoom.setForeground(new Color(44, 62, 80));
			lblRoom.setFont(new Font("돋움", Font.PLAIN, 12));

			JLabel lblNum = new JLabel("수용인원: "+tempRoom.getAcceptPeoNum());
			row_p.add(lblNum, "cell 1 0,alignx left,growy");
			lblNum.setForeground(new Color(44, 62, 80));
			lblNum.setFont(new Font("돋움", Font.PLAIN, 12));

			JLabel lblPrice = new JLabel("대여비용: "+tempRoom.getRentcost());
			row_p.add(lblPrice, "cell 1 0,alignx left,growy");
			lblPrice.setForeground(new Color(44, 62, 80));
			lblPrice.setFont(new Font("돋움", Font.PLAIN, 12));

			JLabel lblAddr = new JLabel("위치: "+tempRoom.getAddress());
			row_p.add(lblAddr, "cell 1 0,alignx left,growy");
			lblAddr.setForeground(new Color(44, 62, 80));
			lblAddr.setFont(new Font("돋움", Font.PLAIN, 12));

			final JLabel lblState = new JLabel("결재대기");
			lblState.setForeground(Color.red);
			lblState.setHorizontalAlignment(SwingConstants.CENTER);
			row_p.add(lblState, "cell 2 0,alignx center");
			lblState.setFont(new Font("돋움", Font.PLAIN, 12));

			if(booklist.getBook(i).getState()==1){
				lblState.setText("결재승인");
				lblState.setForeground(Color.blue);
			}

			//예약일 추가
			JLabel lbldate = new JLabel("예약일: "+booklist.getBook(i).getyear()+"."+booklist.getBook(i).getmonth()+"."+booklist.getBook(i).getday());
			lbldate.setHorizontalAlignment(SwingConstants.CENTER);
			row_p.add(lbldate, "cell 2 0,alignx center");
			lbldate.setForeground(new Color(44, 62, 80));
			lbldate.setFont(new Font("돋움", Font.PLAIN, 12));

			//취소 버튼 추가

			JButton btnCharge = new JButton("결재");
			row_p.add(btnCharge, "flowy,cell 3 0,alignx left");
			btnCharge.setFont(new Font("돋움", Font.PLAIN, 12));

			JButton btnCancel = new JButton("취소");
			row_p.add(btnCancel, "cell 3 0,alignx left");
			btnCancel.setFont(new Font("돋움", Font.PLAIN, 12));

			row_p.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int result = 1;
					String[] buttons = {"네", "아니요"};
					result = JOptionPane.showOptionDialog(null, "취소하시겠습니까?", " ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "아니요");
					if(result == 0)
					{
						int roomnum = booklist.getBook(Integer.valueOf(hiddenNumber.getText())).getroomNum();
						int year = booklist.getBook(Integer.valueOf(hiddenNumber.getText())).getyear();
						int month =  booklist.getBook(Integer.valueOf(hiddenNumber.getText())).getmonth();
						int day = booklist.getBook(Integer.valueOf(hiddenNumber.getText())).getday();
						gui.cancelBook(roomnum, year, month, day);

						btnSearch.doClick();
					}
				}
			});

			btnCharge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int result = 1;
					String[] buttons = {"네", "아니요"};
					result = JOptionPane.showOptionDialog(null, "결재하시겠습니까?", " ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "아니요");


					bookedRoom temp = booklist.getBook(Integer.valueOf(hiddenNumber.getText()));
					temp.setState((result==0)?1:0);
					booklist.setBook(Integer.valueOf(hiddenNumber.getText()), temp);
					gui.sendToServerBookList(booklist);

					if(booklist.getBook(Integer.valueOf(hiddenNumber.getText())).getState() == 1)
					{
						lblState.setText("결재승인");
						lblState.setForeground(Color.blue);
					}
				}
			});
		}
		
	}

}
