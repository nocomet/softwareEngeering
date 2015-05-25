//05_25 �̽ſ�
//�������� ȸ����������
//GUI����, ȸ��Ż�� �� ����

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

import ProblemDomain.companyUser;

public class B_InfobPage extends JPanel {
	private JTextField email_txt;
	private JPasswordField originalpw_txt;
	private JPasswordField pw_txt;
	private JPasswordField pwchk_txt;
	private JTextField name_txt;
	private JTextField bn_txt;
	private JTextField tel_txt1;
	private JTextField tel_txt2;
	private JTextField tel_txt3;

	private String phonenum ;
	
	private GUI_console gui;
	public B_InfobPage() {
		gui=GUI_console.getInstance();
		setLayout(null);

		JLabel label = new JLabel("��������");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("���� ���", Font.BOLD, 15));
		label.setBounds(36, 46, 68, 24);
		add(label);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(44, 62, 80));
		lblEmail.setFont(new Font("����", Font.PLAIN, 12));
		lblEmail.setBounds(197, 97, 36, 15);
		add(lblEmail);

		email_txt = new JTextField(gui.getUser().getEmail());
		email_txt.setEnabled(false);
		email_txt.setBounds(245, 90, 225, 30);
		email_txt.setColumns(10);
		add(email_txt);
		
		JLabel lblOriginalPassword = new JLabel("�����й�ȣ");
		lblOriginalPassword.setForeground(new Color(44, 62, 80));
		lblOriginalPassword.setFont(new Font("����", Font.PLAIN, 12));
		lblOriginalPassword.setBounds(165, 137, 100, 15);
		add(lblOriginalPassword);

		originalpw_txt = new JPasswordField();
		originalpw_txt.setBounds(245, 130, 225, 30);
		add(originalpw_txt);

		JLabel lblPassword = new JLabel("����й�ȣ");
		lblPassword.setForeground(new Color(44, 62, 80));
		lblPassword.setFont(new Font("����", Font.PLAIN, 12));
		lblPassword.setBounds(175, 177, 100, 15);
		add(lblPassword);

		pw_txt = new JPasswordField();
		pw_txt.setBounds(245, 170, 225, 30);
		add(pw_txt);

		JLabel lblPasswordchk = new JLabel("����й�ȣȮ��");
		lblPasswordchk.setForeground(new Color(44, 62, 80));
		lblPasswordchk.setFont(new Font("����", Font.PLAIN, 12));
		lblPasswordchk.setBounds(151, 217, 100, 15);
		add(lblPasswordchk);

		pwchk_txt = new JPasswordField();
		pwchk_txt.setBounds(245, 210, 225, 30);
		add(pwchk_txt);

		JLabel lblName = new JLabel("�̸�");
		lblName.setForeground(new Color(44, 62, 80));
		lblName.setFont(new Font("����", Font.PLAIN, 12));
		lblName.setBounds(209, 257, 24, 15);
		add(lblName);

		name_txt = new JTextField(gui.getUser().getName());
		name_txt.setEnabled(false);
		name_txt.setColumns(10);
		name_txt.setBounds(245, 250, 225, 30);
		add(name_txt);

		JLabel lblBN = new JLabel("����ڹ�ȣ");
		lblBN.setForeground(new Color(44, 62, 80));
		lblBN.setFont(new Font("����", Font.PLAIN, 12));
		lblBN.setBounds(173, 297, 60, 15);
		add(lblBN);
		companyUser user=(companyUser)gui.getUser();
		bn_txt = new JTextField(user.getBusinessNumber());
		bn_txt.setEnabled(false);
		bn_txt.setColumns(10);
		bn_txt.setBounds(245, 290, 225, 30);
		add(bn_txt);

		JLabel lbltel = new JLabel("����ó");
		lbltel.setForeground(new Color(44, 62, 80));
		lbltel.setFont(new Font("����", Font.PLAIN, 12));
		lbltel.setBounds(197, 337, 36, 15);
		add(lbltel);

		tel_txt1 = new JTextField(user.getPhoneNumber());
		tel_txt1.setColumns(10);
		tel_txt1.setBounds(245, 330, 225, 30);
		add(tel_txt1);
		


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

		JButton btndisconnect = new JButton("Ż���ϱ�");
		btndisconnect.setForeground(Color.GRAY);
		btndisconnect.setFont(new Font("����", Font.PLAIN, 15));
		btndisconnect.setBackground(new Color(52, 152, 219));
		btndisconnect.setBounds(240, 430, 215, 47);
		
		// button Listener
		btnUpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String e  = email_txt.getText();
				String oripw = originalpw_txt.getText();
				String pass = pw_txt.getText();
				String pass_re = pwchk_txt.getText();
				String name = name_txt.getText();
				String bn = bn_txt.getText();
				String tel1=tel_txt1.getText();
				String tel2=tel_txt2.getText();
				String tel3=tel_txt3.getText();

				boolean check = true;
				Pattern pattern;
				Matcher matcher;
				
				
				//#��ĭȮ��
				if(pass.equals("")||pass_re.equals("")||name.equals("")||tel1.equals("")||tel2.equals("")||tel3.equals(""))
				{
				
					JOptionPane.showMessageDialog(null, "��ĭ���� �Է��ϼ���");
					check = false;
				}
			
			
				//#��й�ȣ 6�ڸ� �̻� 12�ڸ� ����
				if(pass.length() < 6 || pass.length() > 12)
				{
					
					JOptionPane.showMessageDialog(null, "��й�ȣ�� 6���̻� 12�� ���Ϸ� �Է����ּ���");
					check = false;
				}
				
				//#��й�ȣ �� �Է� Ȯ��
				if(!pass.equals(pass_re))
				{
					
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��й�ȣȮ����\n���� �ٸ��ϴ�.");
					check = false;
				}
				
				
				//#����ó�� ���ڸ����� �̷�������Ѵ�.
				if(!tel1.isEmpty() && !tel2.isEmpty() && !tel3.isEmpty())
				{
					phonenum = tel1+tel2+tel3;
					pattern = Pattern.compile("^[0-9]*$");
					matcher = pattern.matcher(phonenum);
					if(!matcher.matches()){
						JOptionPane.showMessageDialog(null, "����ó�� ���ڸ� �Է����ּ���");
						check = false;
					}
					else 
					{
						if(check == false)
							check = false;
						else check = true;
					}
					
				}
				//#��� ��� ���� ȭ������ �Ѿ��.
				if(check == true)
				{
			
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
					gui.Cjoin(e, pass_re, name,  phonenum);
					gui.moveMain();
					
				}
			}
				
		});
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.moveBmenu();
			}
		});
		add(btnMenu);
		add(btnUpd);
		add(btndisconnect);
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./src/sub.png"));

		background.setBounds(0, 0, 700, 550);
		add(background);
	}
}
