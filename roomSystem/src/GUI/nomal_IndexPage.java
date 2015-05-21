package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ProblemDomain.admin;

public class nomal_IndexPage extends JPanel {

	private JPanel contentPane;
	private JTextField email_txt;
	private JPasswordField pw_txt;
	private JButton btnLogin;
	private JButton btnJoin;
	private JButton btnAdminLogin;
	
	private GUI_console gui;
	public nomal_IndexPage() {
		gui=GUI_console.getInstance();		

		setLayout(null);

		// component ¼±¾ð
		JLabel lblLogin = new JLabel("Login");
		JLabel lblEmail = new JLabel("E-mail");
		email_txt = new JTextField();
		JLabel lblPassword = new JLabel("Password");
		pw_txt = new JPasswordField();
		btnJoin = new JButton("JOIN");
		btnLogin = new JButton("LOGIN");
		btnAdminLogin = new JButton("ADMIN");

		// component À§Ä¡ ¹× ¼Ó¼º Á¤ÇÏ±â
		lblLogin.setBounds(395, 125, 31, 15);
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("µ¸¿ò", Font.PLAIN, 12));

		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("µ¸¿ò", Font.PLAIN, 12));
		lblEmail.setBounds(347, 157, 36, 15);
		email_txt.setBounds(395, 150, 225, 30);
		email_txt.setColumns(10);

		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("µ¸¿ò", Font.PLAIN, 12));
		lblPassword.setBounds(326, 197, 57, 15);
		pw_txt.setBounds(395, 190, 225, 30);
		pw_txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
			}
		});
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setBackground(new Color(231, 76, 60));
		btnJoin.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		btnJoin.setBounds(80, 355, 215, 47);

		btnLogin.setForeground(Color.white);
		btnLogin.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(52, 152, 219));
		btnLogin.setBounds(405, 355, 215, 47);

		btnAdminLogin.setForeground(Color.white);
		btnAdminLogin.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		btnAdminLogin.setBackground(Color.GRAY);
		btnAdminLogin.setBounds(242, 430, 215, 47);
		
		// button Listener
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveJoinPage();		
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String e = email_txt.getText();
				String pass = pw_txt.getText();

				if (e.equals("") || pass.equals("")) {
					JOptionPane.showMessageDialog(null, "ºóÄ­¾øÀÌ ÀÔ·ÂÇÏ¼¼¿ä");
				} else {
					gui.login(e,pass);
				}
			}
		});
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String adminCode = JOptionPane.showInputDialog("Push admin code");
				admin temp=new admin();
				if(adminCode.equals(temp.getAdminCode()))
				{
					//# ¾îµå¹Î ·Î±×ÀÎ
					gui.moveAdminPage();
				}
				else
				{
					//# ½ÇÆÐ
					
				}
			}
		});
		//javax.swing.UIManager.put("Button.defaultButtonFollowsFocus", true); 
		// JPanel¿¡ add
		add(lblLogin);
		add(lblEmail);
		add(email_txt);
		add(lblPassword);
		add(pw_txt);
		add(btnJoin);
		add(btnLogin);
		add(btnAdminLogin);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./src/index.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
	
}

