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

import net.miginfocom.swing.MigLayout;
import Foundation.roomList;
import ProblemDomain.conferenceRoom;
//#���� 2015 05 21 ����
public class B_myroomInfo extends JPanel {
	private JTextField num_txt;
	private JPanel table_p = new JPanel();
	private JScrollPane scroll = new JScrollPane(table_p,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private GUI_console gui;
	
	public B_myroomInfo() {
		gui=GUI_console.getInstance();		
		setLayout(null);

		JLabel label = new JLabel("MYȸ�ǽ�");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("���� ���", Font.BOLD, 15));
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
				
				gui.viewList();
				//-------------------roomlist�� ���� �� �ۿ� ����-------------//
				roomList roomlist = gui.getRoomListResponse();
				if(roomlist.getSize()==0)
				{
					JOptionPane.showMessageDialog(null,"����� ȸ�ǽ��� �����ϴ�.");
				}
				else
					resultPrint(roomlist);

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

	public void resultPrint(roomList roomlist) {
		table_p.removeAll();
		for (int i = 0; i < roomlist.size(); i++) {
			JPanel row_p = new JPanel();
			table_p.add(row_p);
			row_p.setLayout(new MigLayout("", "[120px][510]", "[100px]"));
			final conferenceRoom room=roomlist.getRoom(i);
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
			lblPhoto.setFont(new Font("����", Font.PLAIN, 12));

			final JLabel lblRoom = new JLabel("ȸ�ǽ��̸�: "+roomlist.getRoom(i).getName());
			row_p.add(lblRoom, "flowy,cell 1 0,alignx left,growy");
			lblRoom.setForeground(new Color(44, 62, 80));
			lblRoom.setFont(new Font("����", Font.PLAIN, 12));

			JLabel lblNum = new JLabel("�����ο�  : "+roomlist.getRoom(i).getAcceptPeoNum());
			row_p.add(lblNum, "cell 1 0,alignx left,growy");
			lblNum.setForeground(new Color(44, 62, 80));
			lblNum.setFont(new Font("����", Font.PLAIN, 12));

			JLabel lblPrice = new JLabel("�뿩���  : "+roomlist.getRoom(i).getRentcost());
			row_p.add(lblPrice, "cell 1 0,alignx left,growy");
			lblPrice.setForeground(new Color(44, 62, 80));
			lblPrice.setFont(new Font("����", Font.PLAIN, 12));

			JLabel lblAddr = new JLabel("�ּ�      : "+roomlist.getRoom(i).getCity()+roomlist.getRoom(i).getDistrict());			//#����
			row_p.add(lblAddr, "cell 1 0,alignx left,growy");
			lblAddr.setForeground(new Color(44, 62, 80));
			lblAddr.setFont(new Font("����", Font.PLAIN, 12));

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
