//05_25 이신영
//일반사용자 회원정보수정
//GUI수정, 회원탈퇴 미 구현
//구현완료


package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataManagement.userFile;
import Foundation.userList;
import ProblemDomain.User;

public class C_InfocPage extends JPanel {
	private JTextField email_txt;
	private JPasswordField originalpw_txt;
	private JPasswordField pw_txt;
	private JPasswordField pwchk_txt;
	private JTextField name_txt;
	private JTextField tel_txt1;
	private JTextField tel_txt2;
	private JTextField tel_txt3;
	
	private String phonenum ;
	
	private GUI_console gui;
	public C_InfocPage() {
		gui=GUI_console.getInstance();	
		setLayout(null);

		JLabel label = new JLabel("정보수정");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(36, 46, 68, 24);
		add(label);

		JLabel lblEmail = new JLabel("학교E-mail");
		lblEmail.setForeground(new Color(44, 62, 80));
		lblEmail.setFont(new Font("돋움", Font.PLAIN, 12));
		lblEmail.setBounds(160, 108, 100, 15);
		add(lblEmail);

		email_txt = new JTextField(gui.getUser().getEmail());
		email_txt.setEnabled(false);
		email_txt.setBounds(245, 100, 225, 30);
		email_txt.setColumns(10);
		add(email_txt);
		
		JLabel lblOriginalPassword = new JLabel("현재비밀번호");
		lblOriginalPassword.setForeground(new Color(44, 62, 80));
		lblOriginalPassword.setFont(new Font("돋움", Font.PLAIN, 12));
		lblOriginalPassword.setBounds(160, 147, 100, 15);
		add(lblOriginalPassword);

		originalpw_txt = new JPasswordField();
		originalpw_txt.setBounds(245, 140, 225, 30);
		add(originalpw_txt);

		JLabel lblPassword = new JLabel("새비밀번호");
		lblPassword.setForeground(new Color(44, 62, 80));
		lblPassword.setFont(new Font("돋움", Font.PLAIN, 12));
		lblPassword.setBounds(160, 187, 72, 15);
		add(lblPassword);

		pw_txt = new JPasswordField();
		pw_txt.setBounds(245, 180, 225, 30);
		add(pw_txt);

		JLabel lblPasswordchk = new JLabel("새비밀번호확인");
		lblPasswordchk.setForeground(new Color(44, 62, 80));
		lblPasswordchk.setFont(new Font("돋움", Font.PLAIN, 12));
		lblPasswordchk.setBounds(160, 227, 100, 15);
		add(lblPasswordchk);

		pwchk_txt = new JPasswordField();
		pwchk_txt.setBounds(245, 220, 225, 30);
		add(pwchk_txt);

		JLabel lblName = new JLabel("이름");
		lblName.setForeground(new Color(44, 62, 80));
		lblName.setFont(new Font("돋움", Font.PLAIN, 12));
		lblName.setBounds(197, 267, 36, 15);
		add(lblName);

		name_txt = new JTextField(gui.getUser().getName());
		name_txt.setEnabled(false);
		name_txt.setColumns(10);
		name_txt.setBounds(245, 260, 225, 30);
		add(name_txt);

		JLabel lbltel = new JLabel("연락처");
		lbltel.setForeground(new Color(44, 62, 80));
		lbltel.setFont(new Font("돋움", Font.PLAIN, 12));
		lbltel.setBounds(197, 307, 36, 15);
		add(lbltel);

		String phone = gui.getUser().getPhoneNumber();

		String[] tokenP = phone.split("-");

		tel_txt1 = new JTextField(tokenP[0]);
		tel_txt1.setColumns(10);
		tel_txt1.setBounds(245, 307, 50, 30);
		add(tel_txt1);

		tel_txt2 = new JTextField(tokenP[1]);
		tel_txt2.setColumns(10);
		tel_txt2.setBounds(300, 307, 50, 30);
		add(tel_txt2);
		
		tel_txt3 = new JTextField(tokenP[2]);
		tel_txt3.setColumns(10);
		tel_txt3.setBounds(355, 307, 50, 30);
		add(tel_txt3);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setForeground(Color.white);
		btnMenu.setFont(new Font("돋움", Font.PLAIN, 15));
		btnMenu.setBackground(new Color(52, 152, 219));
		btnMenu.setBounds(80, 370, 215, 47);

		JButton btnUpd = new JButton("수정");
		btnUpd.setForeground(new Color(255, 255, 255));
		btnUpd.setBackground(new Color(231, 76, 60));
		btnUpd.setFont(new Font("돋움", Font.PLAIN, 15));
		btnUpd.setBounds(405, 370, 215, 47);

		JButton btndisconnect = new JButton("탈퇴하기");
		btndisconnect.setForeground(Color.WHITE);
		btndisconnect.setFont(new Font("돋움", Font.PLAIN, 15));
		btndisconnect.setBackground(Color.GRAY);
		btndisconnect.setBounds(240, 430, 215, 47);
		
		btndisconnect.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				userFile userfile = new userFile();
				userList userlist = new userList();
				User user = null;
				int Userindex = -1;
				userlist = userfile.fileRead();
				
				String email = email_txt.getText();
				for(int i=1; i<userlist.size(); i++)
				{
					if(email.equals(userlist.getUser(i).getEmail()))
					{
							user = userlist.getUser(i);
							Userindex = i;
					}
					
				}
				
				if(user == null || Userindex == -1)
					JOptionPane.showMessageDialog(null, "탈퇴되지 않았습니다.");
				else
				{
					userlist.deleteUser(Userindex);
					userfile.fileSave(userlist);
					JOptionPane.showMessageDialog(null, "탈퇴되었습니다.");
				}
				gui.moveMain();
				
			}
		});
		
		
		// button Listener
		btnUpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String e = email_txt.getText();
				String oripw = originalpw_txt.getText();
				String pass = pw_txt.getText();
				String pass_re = pwchk_txt.getText();
				String name = name_txt.getText();
				String tel1 = tel_txt1.getText();
				String tel2 = tel_txt2.getText();
				String tel3 = tel_txt3.getText();
				
				String tel = tel1 + tel2 + tel3;

				boolean check = true;
				Pattern pattern;
				Matcher matcher;
				
				
				//#빈칸확인
				if(pass.equals("")||pass_re.equals("")||name.equals("")||tel1.equals("")||tel2.equals("")||tel3.equals(""))
				{
				
					JOptionPane.showMessageDialog(null, "빈칸없이 입력하세요");
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
			
					JOptionPane.showMessageDialog(null, "회원가입되었습니다.");
					gui.Cjoin(e, pass_re, name,  phonenum);
					gui.moveMain();
					
				}
			}
				
		});
		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveCMenu();
			}
		});
		add(btnMenu);
		add(btnUpd);
		add(btndisconnect);
		JLabel background = new JLabel();
//		background.setIcon(new ImageIcon("C:\\src\\sub.png"));
		background.setIcon(new ImageIcon("./src/sub.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
}
