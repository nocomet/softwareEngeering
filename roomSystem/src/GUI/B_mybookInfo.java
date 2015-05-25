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
import ProblemDomain.bookStateType;
import ProblemDomain.bookedRoom;
import ProblemDomain.conferenceRoom;
//#���� 2015 05 21 ����
/*#	������ 2015 05 25
	���� ���� ����Ȯ���� ���� implements �߰�
*/
public class B_mybookInfo extends JPanel implements bookStateType {
	private JTextField num_txt;
	private JPanel table_p = new JPanel();
	private JScrollPane scroll = new JScrollPane(table_p,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private GUI_console gui;

	public B_mybookInfo() {
		gui=GUI_console.getInstance();		
		setLayout(null);

		JLabel label = new JLabel("MY��������");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("���� ���", Font.BOLD, 14));
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

		JButton btnSearch = new JButton("��ȸ");
		btnSearch.setBackground(new Color(52, 152, 219));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("����", Font.PLAIN, 12));
		btnSearch.setBounds(597, 135, 64, 23);

		JButton btnMenu = new JButton("MENU");
		btnMenu.setForeground(Color.white);
		btnMenu.setFont(new Font("����", Font.PLAIN, 12));
		btnMenu.setBackground(new Color(52, 152, 219));
		btnMenu.setBounds(32, 473, 90, 35);

		// button Listener
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.getBookListFromServerWithOwnerEmail();
				CbookList booklist = gui.getBookListResponse();
				if(booklist.getSize()==0)
				{
					JOptionPane.showMessageDialog(null,"������ ���� �����ϴ�.");
				}
				else
					resultPrint(booklist);
			}
		});	
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveBmenu();
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
				lblPhoto = new JLabel(new ImageIcon("C:\\src\\no_room.png"));
			}
			row_p.add(lblPhoto, "cell 0 0,grow");
			lblPhoto.setForeground(new Color(44, 62, 80));
			lblPhoto.setFont(new Font("����", Font.PLAIN, 12));


			final JLabel lblRoom = new JLabel("ȸ�ǽ� �̸�: " + tempRoom.getName());
			row_p.add(lblRoom, "flowy,cell 1 0,alignx left,growy");
			lblRoom.setForeground(new Color(44, 62, 80));
			lblRoom.setFont(new Font("����", Font.PLAIN, 12));

			JLabel lblNum = new JLabel("�����ο�: "+tempRoom.getAcceptPeoNum());
			row_p.add(lblNum, "cell 1 0,alignx left,growy");
			lblNum.setForeground(new Color(44, 62, 80));
			lblNum.setFont(new Font("����", Font.PLAIN, 12));

			JLabel lblPrice = new JLabel("�뿩���: "+tempRoom.getRentcost());
			row_p.add(lblPrice, "cell 1 0,alignx left,growy");
			lblPrice.setForeground(new Color(44, 62, 80));
			lblPrice.setFont(new Font("����", Font.PLAIN, 12));

			JLabel lblAddr = new JLabel("��ġ: "+tempRoom.getCity()+tempRoom.getDistrict()); //	#����
			row_p.add(lblAddr, "cell 1 0,alignx left,growy");
			lblAddr.setForeground(new Color(44, 62, 80));
			lblAddr.setFont(new Font("����", Font.PLAIN, 12));

			final JLabel lblState = new JLabel("������");
			lblState.setForeground(Color.red);
			lblState.setHorizontalAlignment(SwingConstants.CENTER);
			row_p.add(lblState, "cell 2 0,alignx center");
			lblState.setFont(new Font("����", Font.PLAIN, 12));

			if(booklist.getBook(i).getState()==waitCharge){
				lblState.setText("������");
				lblState.setForeground(Color.red);
			}
			if(booklist.getBook(i).getState()==waitCancel){
				lblState.setText("��Ҵ��");
				lblState.setForeground(Color.ORANGE);
				lblState.setFont(new Font("����", Font.BOLD, 12));
			}
			if(booklist.getBook(i).getState()==BOOKED){
				lblState.setText("����Ϸ�");
				lblState.setForeground(Color.blue);
				lblState.setFont(new Font("����", Font.BOLD, 12));
			}
			//������ �߰�
			JLabel lbldate = new JLabel("������: "+booklist.getBook(i).getyear()+"."+booklist.getBook(i).getmonth()+"."+booklist.getBook(i).getday());
			lbldate.setHorizontalAlignment(SwingConstants.CENTER);
			row_p.add(lbldate, "cell 2 0,alignx center");
			lbldate.setForeground(new Color(44, 62, 80));
			lbldate.setFont(new Font("����", Font.PLAIN, 12));

			row_p.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

				}
			});
		
		}
	}

}
