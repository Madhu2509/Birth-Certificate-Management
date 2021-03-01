package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class profile {

	public JFrame frame;
	public JTextField hospitalname;
	public JTextField hospitalemail;




	public profile() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main Main = new main();
				Main.frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new HospitalDashboard().hos_name.setText(hospitalemail.getText());
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(profile.class.getResource("/images/tinyarrow.png")));
		btnNewButton_2.setBounds(12, 15, 51, 38);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_1.setBounds(482, 15, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(profile.class.getResource("/images/passwordd.png")));
		lblNewLabel_4.setBounds(189, 264, 37, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(profile.class.getResource("/images/email.png")));
		lblNewLabel_3.setBounds(189, 168, 37, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(profile.class.getResource("/images/hospname.png")));
		lblNewLabel_2.setBounds(189, 72, 37, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Profile");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setBounds(262, 13, 97, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		hospitalname = new JTextField();
		hospitalname.setBorder(null);
		hospitalname.setFont(new Font("Calibri", Font.BOLD, 15));
		hospitalname.setBounds(228, 72, 168, 31);
		frame.getContentPane().add(hospitalname);
		hospitalname.setColumns(10);
		hospitalname.setOpaque(false);
		hospitalname.setEditable(false);
		
		hospitalemail = new JTextField();
		hospitalemail.setBorder(null);
		hospitalemail.setFont(new Font("Calibri", Font.BOLD, 15));
		hospitalemail.setColumns(10);
		hospitalemail.setBounds(228, 168, 168, 31);
		frame.getContentPane().add(hospitalemail);
		hospitalemail.setOpaque(false);
		hospitalemail.setEditable(false);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(228, 264, 147, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(profile.class.getResource("/images/6906.jpg")));
		lblNewLabel.setBounds(0, 0, 591, 383);
		frame.getContentPane().add(lblNewLabel);

	}

	

}
