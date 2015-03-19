package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

				if(e.equals("")||pass.equals("")||pass_re.equals("")||name.equals("")||tel.equals(""))
				{
					//빈칸을 확인하세요
					JOptionPane.showMessageDialog(null, "빈칸없이 입력하세요");
				}
				else
				{
					if(pass.equals(pass_re))
					{
						gui.Cjoin(e, pass_re, name,  tel);
						gui.moveMain();
					}
					else
					{
						//비번틀리니 확인하세요
						JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호확인이\n서로 다릅니다.");
					}
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
