//05_21 이신영
//05_25 이신영
//기업사용자 회원가입 제약사항
//GUI수정, 라벨 붙이기, 이메일 중복확인

package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataManagement.userFile;
import Foundation.userList;

public class B_JoinbPage extends JPanel {
	private JTextField email_txt;
	private JComboBox email_address;
	private JButton ckeckbutton;
	private JPasswordField pw_txt;
	private JPasswordField pwchk_txt;
	private JTextField name_txt;
	private JTextField bn_txt;
	private JTextField tel_txt1;
	private JTextField tel_txt2;
	private JTextField tel_txt3;

	private String phonenum ;
	private String businessNum;

	
	private GUI_console gui;
	public B_JoinbPage() {
		gui=GUI_console.getInstance();
		setLayout(null);

		JLabel label = new JLabel("회원가입");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(36, 46, 68, 24);
		add(label);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(44, 62, 80));
		lblEmail.setFont(new Font("돋움", Font.PLAIN, 12));
		lblEmail.setBounds(197, 110, 36, 15);
		add(lblEmail);

		email_txt = new JTextField();
		email_txt.setBounds(245, 108, 100, 30);
		email_txt.setColumns(10);
		add(email_txt);
		
		email_address = new JComboBox();
		email_address.setBounds(370, 108, 100, 30);
		email_address.setModel(new DefaultComboBoxModel(new String[] {"naver.com","google.com", "hanmail.net"}));
		email_address.setEditable(true);
		add(email_address);

		ckeckbutton  = new JButton("중복체크");
		ckeckbutton.setBounds(480, 108, 100, 30);
		ckeckbutton.setForeground(Color.white);
		ckeckbutton.setBackground(Color.GRAY);
		ckeckbutton.setFont(new Font("돋움", Font.PLAIN, 12));
		add(ckeckbutton);
		
		JLabel ExlblEmail = new JLabel("영문자, 숫자만 가능, 6자리 이상");
		ExlblEmail.setFont(new Font("돋음", Font.PLAIN, 10));
		ExlblEmail.setBounds(245, 140, 200, 11);
		add(ExlblEmail);
		
		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setForeground(new Color(44, 62, 80));
		lblPassword.setFont(new Font("돋움", Font.PLAIN, 12));
		lblPassword.setBounds(185, 168, 48, 15);
		add(lblPassword);

		pw_txt = new JPasswordField();
		pw_txt.setBounds(245, 158, 225, 30);
		add(pw_txt);

		JLabel ExlblPassword = new JLabel("6자리 이상, 12자리 이하");
		ExlblPassword.setFont(new Font("돋음", Font.PLAIN, 10));
		ExlblPassword.setBounds(245, 190, 200, 11);
		add(ExlblPassword);
		
		
		JLabel lblPasswordchk = new JLabel("비밀번호확인");
		lblPasswordchk.setForeground(new Color(44, 62, 80));
		lblPasswordchk.setFont(new Font("돋움", Font.PLAIN, 12));
		lblPasswordchk.setBounds(161, 208, 72, 15);
		add(lblPasswordchk);

		pwchk_txt = new JPasswordField();
		pwchk_txt.setBounds(245, 203, 225, 30);
		add(pwchk_txt);

		JLabel lblName = new JLabel("이름");
		lblName.setForeground(new Color(44, 62, 80));
		lblName.setFont(new Font("돋움", Font.PLAIN, 12));
		lblName.setBounds(209, 248, 24, 15);
		add(lblName);

		name_txt = new JTextField();
		name_txt.setColumns(10);
		name_txt.setBounds(245, 248, 225, 30);
		add(name_txt);

		JLabel ExlblName = new JLabel("영문자, 한글만 가능");
		ExlblName.setFont(new Font("돋음", Font.PLAIN, 10));
		ExlblName.setBounds(245, 280, 200, 11);
		add(ExlblName);
		
		JLabel lbltel = new JLabel("연락처");
		lbltel.setForeground(new Color(44, 62, 80));
		lbltel.setFont(new Font("돋움", Font.PLAIN, 12));
		lbltel.setBounds(197, 293, 36, 15);
		add(lbltel);
		
		tel_txt1 = new JTextField();
		tel_txt1.setColumns(10);
		tel_txt1.setBounds(245, 295, 50, 30);
		add(tel_txt1);
		
		tel_txt2 = new JTextField();
		tel_txt2.setColumns(10);
		tel_txt2.setBounds(303, 295, 50, 30);
		add(tel_txt2);
		
		tel_txt3 = new JTextField();
		tel_txt3.setColumns(10);
		tel_txt3.setBounds(360, 295, 50, 30);
		add(tel_txt3);

		JLabel Exlbltel = new JLabel("숫자만 기능");
		Exlbltel.setFont(new Font("돋음", Font.PLAIN, 10));
		Exlbltel.setBounds(245, 325, 200, 11);
		add(Exlbltel);
		
		
		JLabel lblBN = new JLabel("사업자번호");
		lblBN.setForeground(new Color(44, 62, 80));
		lblBN.setFont(new Font("돋움", Font.PLAIN, 12));
		lblBN.setBounds(173, 340, 60, 15);
		add(lblBN);
		

		bn_txt = new JTextField();
		bn_txt.setColumns(10);
		bn_txt.setBounds(245, 340, 225, 30);
		businessNum = bn_txt.getText();
		add(bn_txt);
		

	
		JButton btnMenu = new JButton("MENU");
		btnMenu.setForeground(Color.white);
		btnMenu.setFont(new Font("돋움", Font.PLAIN, 15));
		btnMenu.setBackground(new Color(52, 152, 219));
		btnMenu.setBounds(80, 400, 215, 47);

		JButton btnJoin = new JButton("JOIN");
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setBackground(new Color(231, 76, 60));
		btnJoin.setFont(new Font("돋움", Font.PLAIN, 15));
		btnJoin.setBounds(405, 400, 215, 47);
		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveMain();
			}
		});
		
		ckeckbutton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				userFile userfile = new userFile();
				userList userlist = new userList();

				int checknum = 0;
				
				userlist = userfile.fileRead();
				
				String checkEmail = email_txt.getText() + "@" + email_address.getSelectedItem().toString();

				for(int i=0; i<userlist.size(); i++)
				{
					if(checkEmail.equals(userlist.getUser(i).getEmail()))
						checknum = 1;

					else
						continue;
				}
				
				if(checknum == 1)
					JOptionPane.showMessageDialog(null, "중복된 이메일 입니다.\n다시 입력하세요");
				else
					JOptionPane.showMessageDialog(null, "사용가능한 이메일 입니다.");
			}
		});
		
		
		// button Listener
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String e = email_txt.getText();
				String eaddress =email_address.getSelectedItem().toString();
				String pass = pw_txt.getText();
				String pass_re = pwchk_txt.getText();
				String name = name_txt.getText();
				String bn = bn_txt.getText();
				String tel1 = tel_txt1.getText();
				String tel2 = tel_txt2.getText();
				String tel3 = tel_txt3.getText();
				
				boolean check = true;
				Pattern pattern;
				Matcher matcher;
				
			
				//#빈칸확인
				if(e.equals("")||pass.equals("")||pass_re.equals("")||name.equals("")||tel1.equals("")||tel2.equals("")||tel3.equals(""))
				{
				
					JOptionPane.showMessageDialog(null, "빈칸없이 입력하세요");
					check = false;
				}
				
				ckeckbutton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
			
				//#이메일이 전부 알파벳과 숫자로 이루어져있는가
				if(!e.isEmpty())
				{
				
					pattern  = Pattern.compile("^[a-zA-Z0-9]*$");
					matcher = pattern.matcher(e);
					if(!matcher.matches())
					{
						JOptionPane.showMessageDialog(null, "E-mail은 영문자만 가능 합니다");
						check = false;
					}
					else 
					{
						if(check == false)
							check = false;
						else check = true;
					}
					
					
				}
				
				
				//#이메일 길이확인(6자이상)
				if(e.length() < 6)
				{
				
					JOptionPane.showMessageDialog(null, "E-mail을 6자리 이상으로 입력해주세요");
					check = false;
				}
			
				//#비밀번호 6자리 이상 12자리 이하
				if(pass.length() < 6 || pass.length() > 12)
				{
					
					JOptionPane.showMessageDialog(null, "비밀번호는 6자이상 12자 이하로 입력해주세요");
					check = false;
				}
				
				//#비밀번호 재 입력 확인
				if(!pass.equals(pass_re))
				{
					
					
					JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호확인이\n서로 다릅니다.");
					check = false;
				}
				
				//#이름은 한글과 영문자만 가능
				if(!name.isEmpty())
				{
					
					pattern = Pattern.compile("^[가-힣a-zA-Z]*$");
					matcher = pattern.matcher(name);
					if(!matcher.matches()){
						JOptionPane.showMessageDialog(null, "이름은 한글과 영문자만 가능합니다");
						check = false;
					}
					else 
					{
						if(check == false)
							check = false;
						else check = true;
					}
				}
					
				
				//#연락처는 숫자만으로 이루어져야한다.
				if(!tel1.isEmpty() && !tel2.isEmpty() && !tel3.isEmpty())
				{
					phonenum = tel1+tel2+tel3;
					pattern = Pattern.compile("^[0-9]*$");
					matcher = pattern.matcher(phonenum);
					if(!matcher.matches()){
						JOptionPane.showMessageDialog(null, "연락처는 숫자만 입력해주세요");
						check = false;
					}
					else 
					{
						if(check == false)
							check = false;
						else check = true;
					}
					
				}
				//#모두 통과 다음 화면으로 넘어간다.
				if(check == true)
				{
					String email = e+"@"+eaddress;
					String phone = tel1 + "-" + tel2 + "-" + tel3;
					JOptionPane.showMessageDialog(null, "회원가입되었습니다.");
					gui.Bjoin(email, pass_re, name,  phone,businessNum);
					gui.moveMain();
					
				}
			}
				
		});

		
		add(btnMenu);
		add(btnJoin);
		JLabel background = new JLabel();
//		background.setIcon(new ImageIcon("C:\\src\\sub.png"));
		background.setIcon(new ImageIcon("./src/sub.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
}
