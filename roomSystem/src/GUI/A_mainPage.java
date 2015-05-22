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

import ProblemDomain.companyUser;

public class A_mainPage extends JPanel {
	
	private GUI_console gui;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;
	
	public A_mainPage() {
		gui=GUI_console.getInstance();
		setLayout(null);

		JLabel label = new JLabel("ADMIN");
		label.setForeground(new Color(41, 128, 185));
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		label.setBounds(36, 46, 68, 24);
		add(label);

		btnA= new JButton("AAAAA");
		btnA.setForeground(Color.white);
		btnA.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		btnA.setBackground(Color.GRAY);
		btnA.setBounds(10, 120, 100, 47);
		add(btnA);
		
		btnB= new JButton("BBBBB");
		btnB.setForeground(Color.white);
		btnB.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		btnB.setBackground(Color.GRAY);
		btnB.setBounds(110, 120, 100, 47);
		add(btnB);
		
		btnC= new JButton("CCCCC");
		btnC.setForeground(Color.white);
		btnC.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		btnC.setBackground(Color.GRAY);
		btnC.setBounds(220, 120, 80, 47);
		add(btnC);
		
		btnD= new JButton("DDDDD");
		btnD.setForeground(Color.white);
		btnD.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		btnD.setBackground(Color.GRAY);
		btnD.setBounds(330, 120, 70, 47);
		add(btnD);
		
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./src/sub.png"));
//		background.setIcon(new ImageIcon("C:\\src\\sub.png"));
		background.setBounds(0, 0, 700, 550);
		add(background);
	}
}
