package GUI;

import java.awt.*;

import javax.swing.*;

import PhysicalArchitecture.Client;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class nomal_FramePage extends JFrame {
	private JPanel contentPane;

	public nomal_FramePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 588);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		set();
	}

	public void set() {
		nomal_IndexPage join = new nomal_IndexPage();
		setContentPane(join);
		setVisible(true);
	}
}