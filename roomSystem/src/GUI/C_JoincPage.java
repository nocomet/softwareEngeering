//05_21 이신영
//회원가입 제약사항

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


public class C_JoincPage extends JPanel {
	private JTextField email_txt;
	private JPasswordField pw_txt;
	private JPasswordField pwchk_txt;
	private JTextField name_txt;
	private JTextField tel_txt;
	
	private GUI_console gui;

	public C_JoincPage() {
		gui=GUI_console.getInstance();		
		setLayout(null);

		JLabel label = new JLabel("회원가입");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(36, 46, 68, 24);
		add(label);

		JLabel lblEmail = new JLabel("학교E-mail");
		lblEmail.setForeground(new Color(44, 62, 80));
		lblEmail.setFont(new Font("돋움", Font.PLAIN, 12));
		lblEmail.setBounds(170, 108, 63, 15);
		add(lblEmail);

		email_txt = new JTextField();
		email_txt.setBounds(245, 100, 225, 30);
		email_txt.setColumns(10);
		add(email_txt);

		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setForeground(new Color(44, 62, 80));
		lblPassword.setFont(new Font("돋움", Font.PLAIN, 12));
		lblPassword.setBounds(185, 147, 48, 15);
		add(lblPassword);

		pw_txt = new JPasswordField();
		pw_txt.setBounds(245, 140, 225, 30);
		add(pw_txt);

		JLabel lblPasswordchk = new JLabel("비밀번호확인");
		lblPasswordchk.setForeground(new Color(44, 62, 80));
		lblPasswordchk.setFont(new Font("돋움", Font.PLAIN, 12));
		lblPasswordchk.setBounds(161, 187, 72, 15);
		add(lblPasswordchk);

		pwchk_txt = new JPasswordField();
		pwchk_txt.setBounds(245, 180, 225, 30);
		add(pwchk_txt);

		JLabel lblName = new JLabel("이름");
		lblName.setForeground(new Color(44, 62, 80));
		lblName.setFont(new Font("돋움", Font.PLAIN, 12));
		lblName.setBounds(209, 227, 24, 15);
		add(lblName);

		name_txt = new JTextField();
		name_txt.setColumns(10);
		name_txt.setBounds(245, 220, 225, 30);
		add(name_txt);

		JLabel lbltel = new JLabel("연락처");
		lbltel.setForeground(new Color(44, 62, 80));
		lbltel.setFont(new Font("돋움", Font.PLAIN, 12));
		lbltel.setBounds(197, 267, 36, 15);
		add(lbltel);

		tel_txt = new JTextField();
		tel_txt.setColumns(10);
		tel_txt.setBounds(245, 260, 225, 30);
		add(tel_txt);

		JButton btnMenu = new JButton("MENU");
		btnMenu.setForeground(Color.white);
		btnMenu.setFont(new Font("돋움", Font.PLAIN, 15));
		btnMenu.setBackground(new Color(52, 152, 219));
		btnMenu.setBounds(80, 330, 215, 47);

		JButton btnJoin = new JButton("JOIN");
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setBackground(new Color(231, 76, 60));
		btnJoin.setFont(new Font("돋움", Font.PLAIN, 15));
		btnJoin.setBounds(405, 330, 215, 47);

		// button Listener
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveMain();
			}
		});
		
		
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String e=email_txt.getText();
				String pass=pw_txt.getText();
				String pass_re=pwchk_txt.getText();
				String name=name_txt.getText();
				String tel=tel_txt.getText();
				boolean check = true;
				Pattern pattern;
				Matcher matcher;
				//#빈칸확인
				if(e.equals("")||pass.equals("")||pass_re.equals("")||name.equals("")||tel.equals(""))
				{
				
					JOptionPane.showMessageDialog(null, "빈칸없이 입력하세요");
					check = false;
				}
				//#중복이메일 체크
				/*else if(!e.isEmpty())
				{
					userFile userFile = new userFile();
					userList userlist = userFile.fileRead();
					
						
					for(int i = 0; i<userlist.size(); i++)
					{
						if(userlist.getUser(i).getEmail() == e)
						{
							JOptionPane.showMessageDialog(null, "E-mail이 중복됩니다.");
							check = false;
						}
						else 
						{
							if(check == false)
								check = false;
							else check = true;
						}
					}
				}
				*/
				//#이메일이 전부 알파벳과 숫자로 이루어져있는가
				if(!e.isEmpty())
				{
					System.out.println("1");
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
					System.out.println("2");
					JOptionPane.showMessageDialog(null, "E-mail을 6자리 이상으로 입력해주세요");
					check = false;
				}
			
				//#비밀번호 6자리 이상 12자리 이하
				if(pass.length() < 6 || pass.length() > 12)
				{
					System.out.println("3");
					JOptionPane.showMessageDialog(null, "비밀번호는 6자이상 12자 이하로 입력해주세요");
					check = false;
				}
				
				//#비밀번호 재 입력 확인
				if(!pass.equals(pass_re))
				{
					System.out.println("4");
					
					JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호확인이\n서로 다릅니다.");
					check = false;
				}
				
				//#이름은 한글과 영문자만 가능
				if(!name.isEmpty())
				{
					System.out.println("5");
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
				if(!tel.isEmpty())
				{
					System.out.println("6");
					pattern = Pattern.compile("^[0-9]*$");
					matcher = pattern.matcher(tel);
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
					System.out.println("7");
					JOptionPane.showMessageDialog(null, "회원가입되었습니다.");
					gui.Cjoin(e, pass_re, name,  tel);
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
