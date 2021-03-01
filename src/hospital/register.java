package hospital;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import hospital.dbconfig;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
public class register {

	public JFrame regframe;
	private JTextField hospname;
	private JTextField email;

	


	Connection con=null;
	private JPasswordField password;
	private JPasswordField cpassword;
	
	public register() {
		con=dbconfig.dbconf();
		regframe = new JFrame();
		regframe.setBounds(100, 100, 810, 558);
		regframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regframe.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regframe.dispose();
				new hospital_login().frame.setVisible(true);
				
			}
		});
		
		cpassword = new JPasswordField();
		cpassword.setBounds(255, 429, 240, 36);
		regframe.getContentPane().add(cpassword);
		
		password = new JPasswordField();
		password.setBounds(255, 336, 240, 36);
		regframe.getContentPane().add(password);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon(register.class.getResource("/images/tinyarrow.png")));
		btnNewButton_2.setBounds(22, 24, 56, 35);
		regframe.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Hospital Register");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(255, 24, 257, 59);
		regframe.getContentPane().add(lblNewLabel);
		
		hospname = new JTextField();
		hospname.setText("Hospital Name");
		hospname.setBorder(null);
		hospname.setBounds(255, 122, 240, 36);
		regframe.getContentPane().add(hospname);
		hospname.setColumns(10);
		
		email = new JTextField();
		email.setText("Email");
		email.setBorder(null);
		email.setColumns(10);
		email.setBounds(255, 226, 240, 36);
		regframe.getContentPane().add(email);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(register.class.getResource("/images/hospname.png")));
		lblNewLabel_1.setBounds(201, 116, 42, 42);
		regframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setIcon(new ImageIcon(register.class.getResource("/images/email.png")));
		lblEmail.setBounds(203, 215, 36, 59);
		regframe.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setIcon(new ImageIcon(register.class.getResource("/images/passwordd.png")));
		lblPassword.setBounds(207, 326, 36, 46);
		regframe.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("");
		lblConfirmPassword.setIcon(new ImageIcon(register.class.getResource("/images/passwordd.png")));
		lblConfirmPassword.setBounds(207, 430, 36, 35);
		regframe.getContentPane().add(lblConfirmPassword);
		
		JButton btnNewButton = new JButton("");
		
		btnNewButton.setBackground(Color.WHITE);
		
		btnNewButton.setIcon(new ImageIcon(register.class.getResource("/images/icons8-tick-box-100.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hospitalname = hospname.getText();
				String Email =email.getText();
				String Password = password.getText();
				String Cpassword= cpassword.getText();
				int flag=0;
				
				
				if(hospitalname.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Hospital name field is empty");
					flag=1;
				}
				else if(Email.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Email field is empty");
					flag=1;
				}
				else if(Password.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Password field is empty");
					flag=1;
				}
				else if(Cpassword.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Confirm Password field is empty");
					flag=1;
				}
				else if(!Password.equals(Cpassword))
				{
					JOptionPane.showMessageDialog(null, "Password and confirm password  do not match");
					flag=1;
				}
				String reg_email = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
				boolean res_email = Email.matches(reg_email);
				if(!(res_email)) {
					JOptionPane.showMessageDialog(null,"Enter a valid mail id","Alert",JOptionPane.WARNING_MESSAGE);
					flag=1;
				}
			
				
			
				
				
				
				else
				{
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conec = DriverManager.getConnection("jdbc:mysql://localhost/birth","root","");
						String queryfetch="SELECT email FROM register";
						PreparedStatement pstmts=conec.prepareStatement(queryfetch);
						ResultSet rs = pstmts.executeQuery();
						
						if(!Email.isEmpty())
						{
						while(rs.next())
						{
							String emai_reg=rs.getString("email");
							if(emai_reg.equals(Email))
							{
								flag=1;
							JOptionPane.showMessageDialog(null,"Email Exists");
							}
						}
					    }
						if(flag==0) {
				
						String query="INSERT INTO register(hosp_name,email,password,approval_status) VALUES(?, ?, ?,'"+-1+"')";
						PreparedStatement pstmp = con.prepareStatement(query);
						pstmp.setString(1,hospitalname);
						pstmp.setString(2, Email);
						pstmp.setString(3, Password);
						pstmp.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Request Sent Successfully");
						
						}
						}
						
						 
						
						catch(Exception excep)
						{
							JOptionPane.showMessageDialog(null, excep);
						}
 					
					
			
				}
				
			}
		});
		btnNewButton.setBounds(633, 217, 80, 73);
		regframe.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(register.class.getResource("/images/6906.jpg")));
		lblNewLabel_2.setBounds(0, -30, 792, 541);
		regframe.getContentPane().add(lblNewLabel_2);
	}
}
