package admin;
import hospital.dbconfig;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import hospital.hospital_login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class login {

	 public JFrame framelogin;
	 private JTextField email;
	 private JPasswordField password;


	Connection con =null;
	public login() {
		con=dbconfig.dbconf();
		framelogin = new JFrame();
		framelogin.setBounds(100, 100, 918, 609);
		framelogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framelogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Admin ");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setBounds(416, 51, 87, 44);
		framelogin.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Hospital");
		lblNewLabel.setFont(new Font("Calibri", Font.ITALIC, 20));
		lblNewLabel.setBounds(335, 440, 73, 26);
		framelogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Calibri", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(575, 440, 59, 26);
		framelogin.getContentPane().add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(346, 220, 259, 35);
		framelogin.getContentPane().add(password);
		password.setEchoChar('*');
		
		email = new JTextField();
		email.setText("Username");
		email.setBounds(346, 108, 259, 35);
		framelogin.getContentPane().add(email);
		email.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(298, 344, 141, 95);
		framelogin.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon(login.class.getResource("/images/hospitalicon.png")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(533, 344, 141, 95);
		framelogin.getContentPane().add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(login.class.getResource("/images/loginicon.png")));
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(284, 99, 50, 44);
		framelogin.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(login.class.getResource("/images/usernameicon.png")));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(284, 210, 50, 53);
		framelogin.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(login.class.getResource("/images/passwordicon.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/images/adminloginbackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 900, 562);
		framelogin.getContentPane().add(lblNewLabel_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="SELECT * FROM admin WHERE Email=? AND Password=?";
					PreparedStatement stmt =con.prepareStatement(query);
					stmt.setString(1,email.getText());
					stmt.setString(2,password.getText());
					ResultSet rs =stmt.executeQuery();
					int count=0;
					while(rs.next())
					{
						count+=1;
						
					}
					if(count==1)
					{
						JOptionPane.showMessageDialog(null, "Login Success");
						framelogin.dispose();
						admin_dash admin = new admin_dash();
						admin.frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Username And Password is Incorrect");

					}
					
					
					
				}
				catch(Exception ead1)
				{
					JOptionPane.showMessageDialog(null, ead1);
				}
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framelogin.dispose();
				hospital_login lgn = new hospital_login();
				lgn.frame.setVisible(true);
			}
		});
	}

}
