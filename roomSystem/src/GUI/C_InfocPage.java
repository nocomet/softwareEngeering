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

public class C_InfocPage extends JPanel {
	private JTextField email_txt;
	private JPasswordField originalpw_txt;
	private JPasswordField pw_txt;
	private JPasswordField pwchk_txt;
	private JTextField name_txt;
	private JTextField tel_txt;
	
	private GUI_console gui;
	public C_InfocPage() {
		gui=GUI_console.getInstance();	
		setLayout(null);

		JLabel label = new JLabel("��������");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("���� ���", Font.BOLD, 15));
		label.setBounds(36, 46, 68, 24);
		add(label);

		JLabel lblEmail = new JLabel("�б�E-mail");
		lblEmail.setForeground(new Color(44, 62, 80));
		lblEmail.setFont(new Font("����", Font.PLAIN, 12));
		lblEmail.setBounds(160, 108, 100, 15);
		add(lblEmail);

		email_txt = new JTextField(gui.getUser().getEmail());
		email_txt.setEnabled(false);
		email_txt.setBounds(245, 100, 225, 30);
		email_txt.setColumns(10);
		add(email_txt);
		
		JLabel lblOriginalPassword = new JLabel("�����й�ȣ");
		lblOriginalPassword.setForeground(new Color(44, 62, 80));
		lblOriginalPassword.setFont(new Font("����", Font.PLAIN, 12));
		lblOriginalPassword.setBounds(160, 147, 100, 15);
		add(lblOriginalPassword);

		originalpw_txt = new JPasswordField();
		originalpw_txt.setBounds(245, 140, 225, 30);
		add(originalpw_txt);

		JLabel lblPassword = new JLabel("����й�ȣ");
		lblPassword.setForeground(new Color(44, 62, 80));
		lblPassword.setFont(new Font("����", Font.PLAIN, 12));
		lblPassword.setBounds(160, 187, 72, 15);
		add(lblPassword);

		pw_txt = new JPasswordField();
		pw_txt.setBounds(245, 180, 225, 30);
		add(pw_txt);

		JLabel lblPasswordchk = new JLabel("����й�ȣȮ��");
		lblPasswordchk.setForeground(new Color(44, 62, 80));
		lblPasswordchk.setFont(new Font("����", Font.PLAIN, 12));
		lblPasswordchk.setBounds(160, 227, 100, 15);
		add(lblPasswordchk);

		pwchk_txt = new JPasswordField();
		pwchk_txt.setBounds(245, 220, 225, 30);
		add(pwchk_txt);

		JLabel lblName = new JLabel("�̸�");
		lblName.setForeground(new Color(44, 62, 80));
		lblName.setFont(new Font("����", Font.PLAIN, 12));
		lblName.setBounds(197, 267, 36, 15);
		add(lblName);

		name_txt = new JTextField(gui.getUser().getName());
		name_txt.setEnabled(false);
		name_txt.setColumns(10);
		name_txt.setBounds(245, 260, 225, 30);
		add(name_txt);

		JLabel lbltel = new JLabel("����ó");
		lbltel.setForeground(new Color(44, 62, 80));
		lbltel.setFont(new Font("����", Font.PLAIN, 12));
		lbltel.setBounds(197, 307, 36, 15);
		add(lbltel);

		tel_txt = new JTextField(gui.getUser().getPhoneNumber());
		tel_txt.setColumns(10);
		tel_txt.setBounds(245, 300, 225, 30);
		add(tel_txt);

		JButton btnMenu = new JButton("MENU");
		btnMenu.setForeground(Color.white);
		btnMenu.setFont(new Font("����", Font.PLAIN, 15));
		btnMenu.setBackground(new Color(52, 152, 219));
		btnMenu.setBounds(80, 370, 215, 47);

		JButton btnUpd = new JButton("����");
		btnUpd.setForeground(new Color(255, 255, 255));
		btnUpd.setBackground(new Color(231, 76, 60));
		btnUpd.setFont(new Font("����", Font.PLAIN, 15));
		btnUpd.setBounds(405, 370, 215, 47);

		// button Listener
		btnUpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String e = email_txt.getText();
				String oripw = originalpw_txt.getText();
				String pass = pw_txt.getText();
				String pass_re = pwchk_txt.getText();
				String name = name_txt.getText();
				String tel = tel_txt.getText();

				if (e.equals("") || pass.equals("") || pass_re.equals("")
						|| name.equals("") || tel.equals("")) {
					// ��ĭ�� Ȯ���ϼ���
					JOptionPane.showMessageDialog(null, "��ĭ���� �Է��ϼ���");
				}  else {
					if (pass.equals(pass_re)) {
						gui.updateInfo(e, oripw, pass_re, name, tel);
						String response=gui.getStringResponse();
						if(response.equalsIgnoreCase("��й�ȣ����"))
						{
							JOptionPane.showMessageDialog(null, "��й�ȣ�� ���� �ʽ��ϴ�.");
						}
						else if(response.equalsIgnoreCase("#update"))
						{
							gui.moveCMenu();
						}
					} else {
						// ���Ʋ���� Ȯ���ϼ���
						JOptionPane.showMessageDialog(null, "�������ȣ�� ��й�ȣȮ���� ���� ���� �ʽ��ϴ�.");
					}
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
		JLabel background = new JLabel();
//		background.setIcon(new ImageIcon("C:\\src\\sub.png"));
		background.setIcon(new ImageIcon("./src/sub.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
}
