package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import admin.login;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
public class main {

	public JFrame frame;

	public main() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 883, 524);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Hospital");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_3.setBounds(482, 343, 56, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Admin");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_2.setBounds(319, 343, 56, 16);
		panel.add(lblNewLabel_2);
		
		JButton btnAdmin = new JButton("");
		btnAdmin.setBackground(new Color(255, 255, 255));
		btnAdmin.setIcon(new ImageIcon(main.class.getResource("/images/adminicon.png")));
		btnAdmin.setBounds(263, 202, 155, 128);
		panel.add(btnAdmin);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login adminlogn = new login();
				adminlogn.framelogin.setVisible(true);
			}
		});
		
		JButton btnhospital = new JButton("");
		btnhospital.setIcon(new ImageIcon(main.class.getResource("/images/hospitalicon.png")));
		btnhospital.setBackground(new Color(255, 255, 255));
		btnhospital.setBounds(430, 202, 155, 128);
		panel.add(btnhospital);
		
		JLabel lblNewLabel_1 = new JLabel("Birth Certificate Management System");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel_1.setBounds(286, 27, 355, 87);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(main.class.getResource("/images/background.jpg")));
		lblNewLabel.setBounds(0, 13, 883, 511);
		panel.add(lblNewLabel);
		btnhospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				frame.dispose();
//				hospital_login hsl =new hospital_login();
//				hsl.setVisible(true);
				frame.dispose();
				hospital_login lgn = new hospital_login();
			    lgn.frame.setVisible(true);
				
			}
		});
	}
	public static void main(String[] args) {
		
		main window = new main();
		window.frame.setVisible(true);
				
	
	}
}
