package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import net.miginfocom.swing.MigLayout;
import Foundation.userList;
import ProblemDomain.User;
import ProblemDomain.stateType;

public class A_mainPage extends JPanel implements stateType  {

	private GUI_console gui;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;


	private JPanel border;

	private JPanel table_p = new JPanel();
	private JScrollPane scroll = new JScrollPane(table_p,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public A_mainPage() {
		gui=GUI_console.getInstance();
		setLayout(null);

		JLabel label = new JLabel("ADMIN");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(36, 46, 68, 24);
		add(label);

		//--------//
		table_p.setBounds(32, 185, 630, 250);
		table_p.setLayout(new BoxLayout(table_p, BoxLayout.Y_AXIS));
		scroll.setMinimumSize(new Dimension(630, 300));
		scroll.setPreferredSize(new Dimension(630, 300));
		scroll.setBorder(null);

		border = new JPanel();
		border.setBounds(32, 185, 630, 250);
		border.setLayout(new BorderLayout());

		border.add(scroll);
		add(border);
		//--------//

		setBtn();
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./src/sub.png"));
		//		background.setIcon(new ImageIcon("C:\\src\\sub.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
	public void setBtn()
	{
		btnA= new JButton("회원열람");
		btnA.setForeground(Color.white);
		btnA.setFont(new Font("돋움", Font.PLAIN, 14));
		btnA.setBackground(Color.GRAY);
		btnA.setBounds(70, 120, 140, 47);
		add(btnA);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_p.removeAll();
				gui.getUserListFromServer();
				userList userlist=gui.getUserListResponse();
				for(int i = 0 ; i < userlist.size(); i++)
				{					
					btnAclick();
				}
			}
		});
		btnB= new JButton("승인회원 열람");
		btnB.setForeground(Color.white);
		btnB.setFont(new Font("돋움", Font.PLAIN, 14));
		btnB.setBackground(Color.GRAY);
		btnB.setBounds(70+140+70, 120, 140, 47);
		add(btnB);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBClick();
			}
		});
		btnC= new JButton("결재 취소 열람");
		btnC.setForeground(Color.white);
		btnC.setFont(new Font("돋움", Font.PLAIN, 14));
		btnC.setBackground(Color.GRAY);
		btnC.setBounds(70+140+70+140+70, 120, 140, 47);
		add(btnC);



		btnD= new JButton("돌아가기");
		btnD.setForeground(Color.white);
		btnD.setFont(new Font("돋움", Font.PLAIN, 15));
		btnD.setBackground(new Color(52, 152, 219));
		btnD.setBounds(300, 445, 100, 47);
		add(btnD);		
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.moveMain();
			}
		});
		

	}
	public void btnAclick()
	{
		table_p.removeAll();
		gui.getUserListFromServer();
		userList userlist=gui.getUserListResponse();
		for(int i = 0 ; i < userlist.size(); i++)
		{

			final PanelTest row_p=addResultPanel(userlist, i);
			row_p.panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int result;
					if(row_p.user.getUser(row_p.index).getState()==OLD)
					{
						row_p.panel.setBackground(new Color(254,240,254));
						result = JOptionPane.showConfirmDialog(null,"이 회원을 제재하시겠습니까?", "BAN",JOptionPane.YES_NO_OPTION);
						if(result==0)
						{
							row_p.user.getUser(row_p.index).setState(BAD);

							//#서버로 보내서 userlist 저장해야.
							gui.sendToSeverUserList(row_p.user);
							table_p.removeAll();
							btnAclick();
						}
						else
						{
							row_p.panel.setBackground(new Color(235,235,235));		
						}
					}
					else if(row_p.user.getUser(row_p.index).getState()==BAD)
					{
						row_p.panel.setBackground(new Color(254,240,254));
						result = JOptionPane.showConfirmDialog(null,"제재를 푸시겠습니까?", "BAN",JOptionPane.YES_NO_OPTION);
						if(result==0)
						{
							row_p.user.getUser(row_p.index).setState(OLD);

							//#서버로 보내서 userlist 저장해야.
							gui.sendToSeverUserList(row_p.user);
							table_p.removeAll();
							btnAclick();
						}
						else
						{
							row_p.panel.setBackground(new Color(235,235,235));		
						}
					}
					
				}
			});

		}
	}
	public void btnBClick()
	{
		table_p.removeAll();
		gui.getUserListFromServer();
		userList userlist=gui.getUserListResponse();
		for(int i = 0 ; i < userlist.size(); i++)
		{
			if(userlist.getUser(i).getState()==NEW)
			{
				final PanelTest row_p=addResultPanel(userlist, i);
				row_p.panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int result;
						if(row_p.user.getUser(row_p.index).getState()==NEW)
						{
							row_p.panel.setBackground(new Color(254,240,254));
							result =JOptionPane.showConfirmDialog(null,"회원가입을 승인하시겠습니까?", "승인",JOptionPane.YES_NO_OPTION);
							if(result==0)
							{
								row_p.user.getUser(row_p.index).setState(OLD);

								//#서버로 보내서 userlist 저장해야.
								gui.sendToSeverUserList(row_p.user);
								table_p.removeAll();
								btnBClick();
							}
							else
							{
								row_p.panel.setBackground(new Color(235,235,235));					
							}
						}
					}
				});
			}
		}
	}
	public PanelTest addResultPanel(userList list, int i)
	{
		
		final JPanel row_p = new JPanel();
		row_p.setBackground(new Color(235,235,235));	
		//System.out.println(userlist.getUser(i).getName());
		table_p.add(row_p);
		//row_p.setLayout(new MigLayout("", "[120px][510]", "[100px]"));
		row_p.setLayout(new MigLayout("", "[100px][50]", "[50px]"));
		//row_p.setLayout(new FlowLayout());
		row_p.setSize(110, 44);
		JLabel email = new JLabel("E-mail :  "+list.getUser(i).getEmail());
		row_p.add(email, "flowy,cell 1 0,alignx left,growy");
		email.setForeground(new Color(44, 62, 80));
		email.setFont(new Font("돋움", Font.PLAIN, 12));				
		JLabel name = new JLabel("사용자 이름 :  "+list.getUser(i).getName());
		row_p.add(name, "flowy,cell 1 0,alignx left,growy");
		name.setForeground(new Color(44, 62, 80));
		name.setFont(new Font("돋움", Font.PLAIN, 12));
		JLabel number = new JLabel("휴대폰 번호 :  "+list.getUser(i).getPhoneNumber());
		row_p.add(number, "flowy,cell 1 0,alignx left,growy");					
		number.setForeground(new Color(44, 62, 80));
		number.setFont(new Font("돋움", Font.PLAIN, 12));
		String line;
		if(list.getUser(i).getState()==NEW)
			line="New";
		else if(list.getUser(i).getState()==OLD)
			line="Old";
		else
			line="Ban";
		JLabel state = new JLabel("   회원상태:  "+line);
		row_p.add(state, "cell 5 0,grow");						
		state.setForeground(Color.RED);
		state.setFont(new Font("돋움", Font.PLAIN, 14));

		return new PanelTest(row_p, list,i);

	}
}
