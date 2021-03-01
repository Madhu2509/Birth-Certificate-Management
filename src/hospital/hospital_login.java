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
import admin.login;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
public class hospital_login {

	public JFrame frame;
	public JTextField email;

	Connection con = null;
	private JPasswordField password;
	
	public hospital_login() {
		
		con=dbconfig.dbconf();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 627, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Register");
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_7.setBounds(466, 359, 56, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Login");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_6.setBounds(298, 359, 41, 17);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(120, 359, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(178, 199, 234, 33);
		frame.getContentPane().add(password);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(265, 87, 56, 39);
		frame.getContentPane().add(lblNewLabel);
		
		email = new JTextField();
		email.setText("Email");
		email.setBounds(178, 139, 234, 33);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(hospital_login.class.getResource("/images/loginicon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(email.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Email field is empty");
					
				}
				else if(password.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Password field is empty");
				}
				else {
				try {
				
					String query="SELECT * FROM register WHERE email=? AND password=?";
					PreparedStatement pstm=con.prepareStatement(query);
					pstm.setString(1, email.getText());
					pstm.setString(2, password.getText());
					ResultSet rs =pstm.executeQuery();
					int count=0;
					int status=0;
					while(rs.next())
					{
						count=count+1;
						 status = rs.getInt("approval_status");
						
					}
					if(count ==1 && status==1)
					{
						JOptionPane.showMessageDialog(null, "Login Success");
						
						
						frame.dispose();
						HospitalDashboard dashboard = new HospitalDashboard();
						dashboard.hos_name.setText(email.getText());
//						dashboard.hospitalid.setText(email.getText());
						
//						String query2="SELECT hospita_id FROM register WHERE email='"+email.getText()+"'";
//						PreparedStatement pst =con.prepareStatement(query2);
//						ResultSet rst =pst.executeQuery();
//						while(rst.next())
//						{
//							String id=rst.getString("hospita_id");
//							dashboard.hospitalid.setText(id);
//						}
						dashboard.jframe_1.setVisible(true);
					}
					else if(status==-1)
					{
						JOptionPane.showMessageDialog(null, "Registration pending");
						
					}
					else if(status==0)
					{
						JOptionPane.showMessageDialog(null, "Hospital Denied or password incorrect ");
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
					}
					
					
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null, ex1);
				}
			}
		}
		});
		btnNewButton.setBounds(253, 282, 126, 76);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon(hospital_login.class.getResource("/images/icontodolist.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				register reg = new register();
				reg.regframe.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(426, 282, 126, 76);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnadmin = new JButton("");
		btnadmin.setBackground(new Color(255, 255, 255));
		btnadmin.setIcon(new ImageIcon(hospital_login.class.getResource("/images/adminicon.png")));
		btnadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login admin =new login();
				admin.framelogin.setVisible(true);
				
				
			}
		});
		btnadmin.setBounds(81, 282, 126, 76);
		frame.getContentPane().add(btnadmin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(115, 363, 61, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(hospital_login.class.getResource("/images/usernameicon.png")));
		lblNewLabel_3.setBounds(115, 122, 56, 50);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(hospital_login.class.getResource("/images/passwordicon.png")));
		lblNewLabel_4.setBounds(115, 183, 50, 64);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(hospital_login.class.getResource("/images/loginback.jpg")));
		lblNewLabel_5.setBounds(0, -3, 614, 392);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
